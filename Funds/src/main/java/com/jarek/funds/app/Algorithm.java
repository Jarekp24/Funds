package com.jarek.funds.app;

import com.jarek.funds.model.Division;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.model.enums.ProfileOfInvesting;
import com.jarek.funds.services.CalculateService;
import com.jarek.funds.services.DivisionService;
import com.jarek.funds.services.FundsService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Algorithm {

    private final CalculateService calculateService;
    private final FundsService fundsService;
    private final DivisionService divisionService;

    public Algorithm(CalculateService calculateService, FundsService fundsService, DivisionService divisionService) {
        this.calculateService = calculateService;
        this.fundsService = fundsService;
        this.divisionService = divisionService;
    }

    public void start(BigDecimal totalAmount, ProfileOfInvesting profile, List<Fund> fundsList) {

        fundsService.showFunds(fundsList);

        System.out.println("Kwota całkowita: " + totalAmount);
        BigDecimal amount = calculateService.amountForCalculations(totalAmount);
        System.out.println("Kwota bez reszty do obliczeń: " + amount);

        //zwraca mape z iloscia powtorzen danego fundusza
        Map<FundType, Integer> numberOfFundType = calculateService.numberOfFundType(fundsList);

        //zwraca mape, z obliczonymi procentami dla kazdego typu fundusza
        Map<FundType, BigDecimal> percentagesForFundType = calculateService.percentagesForFundType(profile, numberOfFundType);

        //zwraca typy i wartosci w procentach które mogą wystąpić
        Map<FundType, List<BigDecimal>> percentagesValues = calculateService.percentagesValues(percentagesForFundType, numberOfFundType);

        //lista kwot i procentow dla każdego typu funduszu
        List<Calculations> percentageForCalc = calculateService.listOfObjectsForCalculation(percentagesValues, numberOfFundType, amount);

        List<Division> result = divisionService.createDivions(fundsList, percentageForCalc);

        divisionService.showResult(result);

        BigDecimal remainder = calculateService.remainder(totalAmount);
        System.out.println("Kwota nierozdzielona: " + remainder);
    }

}
