package com.jarek.funds.services.impl;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Division;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.services.DivisionService;
import java.util.ArrayList;
import java.util.List;

public class DivisionServiceImpl implements DivisionService {

    @Override
    public List<Division> createDivions(List<Fund> fundsList, List<Calculations> percentageForCalc) {
        List<Division> result = new ArrayList<>();
        fundsList.forEach(fund -> {
            percentageForCalc.forEach(calc -> {
                final FundType fundType = fund.getType();
                final FundType calcType = calc.getFundType();
                if (fundType.equals(calcType)) {
                    result.add(new Division(fund, calc));
                }
            });
        });
        cleanFirst(result);
        cleanSecond(result);
        return result;
    }
    
    @Override
    public void showResult(List<Division> result) {
        System.out.println("===============Lista Wynikowa============");
        result.forEach(div -> {
            final Fund fund = div.getFund();
            final Calculations calc = div.getCalculations();
            System.out.println("Id: " + fund.getId() + " " + fund.getName() + " " + fund.getType() + " " + calc.getAmount() + " " + calc.getPercentage());
        });
    }
    
    private void cleanSecond(List<Division> result) {
        for (int i = 1; i < result.size(); i++) {
            Division div = result.get(i);
            Fund fund1 = result.get(i).getFund();
            Fund fund2 = result.get(i - 1).getFund();
            if (fund1.equals(fund2)) {
                if (i!=1){
                    result.remove(i-1);
                } else {
                    result.remove(i);
                }
            }
        }
    }

    private void cleanFirst(List<Division> result) {
        for (int i = 1; i < result.size(); i++) {
            Division div = result.get(i);
            Fund fund1 = result.get(i).getFund();
            Fund fund2 = result.get(i - 1).getFund();
            if (fund1.equals(fund2)) {
                result.remove(i);
            }
        }
    }

}
