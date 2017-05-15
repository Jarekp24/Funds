package com.jarek.funds.services.impl;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Division;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.services.DivisionService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DivisionServiceImplTest {

    DivisionService divisionService;

    private static final BigDecimal SOME_AMOUNT = new BigDecimal("150.00");
    private static final BigDecimal SOME_PERCENTAGE = new BigDecimal("10.00");

    @Test
    public void shouldReturnListOfDivision() {
        List<Fund> fundsList = createFundsList();
        List<Calculations> calcList = createCalculationsList();

        List<Division> result = divisionService.createDivions(fundsList, calcList);

        assertEquals(fundsList.size(), result.size());
    }

    private List<Fund> createFundsList() {
        List<Fund> funds = new ArrayList<>();

        Fund fund1 = new Fund(1L, "Fundusz Polski 1", FundType.POLAND);
        Fund fund2 = new Fund(2L, "Fundusz Polski 2", FundType.POLAND);
        Fund fund3 = new Fund(3L, "Fundusz Zagraniczny 1", FundType.FOREIGN);
        Fund fund4 = new Fund(4L, "Fundusz Zagraniczny 2", FundType.FOREIGN);
        Fund fund5 = new Fund(5L, "Fundusz Zagraniczny 3", FundType.FOREIGN);
        Fund fund6 = new Fund(6L, "Fundusz Pieniężny 1", FundType.MONETARY);

        funds.add(fund1);
        funds.add(fund2);
        funds.add(fund3);
        funds.add(fund4);
        funds.add(fund5);
        funds.add(fund6);

        return funds;
    }

    private List<Calculations> createCalculationsList() {
        List<Calculations> calculations = new ArrayList<>();

        Calculations calc1 = new Calculations(FundType.POLAND, SOME_AMOUNT, SOME_PERCENTAGE);
        Calculations calc2 = new Calculations(FundType.POLAND, SOME_AMOUNT, SOME_PERCENTAGE);
        Calculations calc3 = new Calculations(FundType.FOREIGN, SOME_AMOUNT, SOME_PERCENTAGE);
        Calculations calc4 = new Calculations(FundType.FOREIGN, SOME_AMOUNT, SOME_PERCENTAGE);
        Calculations calc5 = new Calculations(FundType.FOREIGN, SOME_AMOUNT, SOME_PERCENTAGE);
        Calculations calc6 = new Calculations(FundType.MONETARY, SOME_AMOUNT, SOME_PERCENTAGE);

        calculations.add(calc1);
        calculations.add(calc2);
        calculations.add(calc3);
        calculations.add(calc4);
        calculations.add(calc5);
        calculations.add(calc6);

        return calculations;
    }

    @Before
    public void setUp() {
        divisionService = new DivisionServiceImpl();
    }
}
