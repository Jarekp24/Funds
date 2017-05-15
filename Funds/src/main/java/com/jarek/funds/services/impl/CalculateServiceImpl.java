package com.jarek.funds.services.impl;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.model.enums.ProfileOfInvesting;
import com.jarek.funds.services.CalculateService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateServiceImpl implements CalculateService {

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    @Override
    public Map<FundType, Integer> numberOfFundType(List<Fund> funds) {
        Map<FundType, Integer> fundsTypesNumbers = new HashMap<>();
        for (FundType type : FundType.values()) {
            int fundsNumber = funds.stream()
                    .filter(fund -> fund.getType().equals(type))
                    .collect(Collectors.toList()).size();
            fundsTypesNumbers.put(type, fundsNumber);
        }
        return fundsTypesNumbers;
    }

    @Override
    public Map<FundType, BigDecimal> percentagesForFundType(ProfileOfInvesting profile, Map<FundType, Integer> numberOfFundType) {
        Map<FundType, BigDecimal> percentages = new HashMap<>();

        Map<FundType, BigDecimal> profilePercentages = profile.getPercentages();

        profilePercentages.entrySet().stream()
                .forEach(e -> {
                    FundType key = e.getKey();
                    numberOfFundType.entrySet().stream()
                            .forEach(x -> {
                                if (e.getKey().equals(x.getKey())) {
                                    BigDecimal numbers = new BigDecimal(x.getValue());
                                    BigDecimal percentagePerType = e.getValue().divide(numbers, 4, RoundingMode.FLOOR);
                                    percentages.put(e.getKey(), percentagePerType);
                                }
                            });
                });
        return percentages;
    }
    
    @Override
    public Map<FundType, List<BigDecimal>> percentagesValues(Map<FundType, BigDecimal> percentagesForFundType, Map<FundType, Integer> numberOfFundType) {
        Map<FundType, List<BigDecimal>> percentagesValues = new HashMap<>();
        percentagesForFundType
                .forEach((k, v) -> {
                    BigDecimal valueFloor4 = v.setScale(4, RoundingMode.FLOOR);
                    BigDecimal value = v.setScale(2, RoundingMode.FLOOR);
                    BigDecimal rest = valueFloor4.subtract(value);
                    int compareTo = rest.compareTo(BigDecimal.ZERO);
                    List<BigDecimal> percentageList = new ArrayList<>();
                    if (compareTo == 1) {
                        Integer count = numberOfFundType.get(k);
                        BigDecimal numbersOfTypes = new BigDecimal(count);
                        BigDecimal addedValue = rest.multiply(numbersOfTypes).setScale(2, RoundingMode.UP);
                        percentageList.add(value.add(addedValue));
                    }
                    percentageList.add(value);
                    percentagesValues.put(k, percentageList);
                });
        return percentagesValues;
    }
    
    @Override
    public List<Calculations> listOfObjectsForCalculation(Map<FundType, List<BigDecimal>> percentagesValues, Map<FundType, Integer> numberOfFundType, BigDecimal totalAmount) {
        List<Calculations> objForCalc = new ArrayList<>();
        percentagesValues.entrySet()
                .stream()
                .forEach(percenatege -> {
                    Iterator<BigDecimal> iterator = percenatege.getValue().iterator();
                    int i = 1;
                    Integer typeCount = numberOfFundType.get(percenatege.getKey());
                    BigDecimal firstValue = null;
                    BigDecimal secondValue = null;
                    while (iterator.hasNext()) {
                        BigDecimal next = iterator.next();
                        i++;
                        if (i == 2) {
                            firstValue = next;
                        } else {
                            secondValue = next;
                        }
                    }
                    for (int j = 1; j <= typeCount; j++) {
                        FundType type = percenatege.getKey();
                        if (secondValue != null && j > 1) {
                            BigDecimal value = totalAmount.multiply(secondValue).divide(new BigDecimal("100"));
                            objForCalc.add(new Calculations(type, secondValue, value));
                        } else {
                            BigDecimal value = totalAmount.multiply(firstValue).divide(new BigDecimal("100"));
                            objForCalc.add(new Calculations(type, firstValue, value));
                        }
                    }
                });
        return objForCalc;
    }
    
    @Override
    public BigDecimal amountForCalculations(BigDecimal totalAmount) {
        BigDecimal rest = totalAmount.remainder(HUNDRED);
        return totalAmount.subtract(rest);
    }

    @Override
    public BigDecimal remainder(BigDecimal totalAmount) {
        return totalAmount.remainder(HUNDRED);
    }

}
