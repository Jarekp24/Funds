package com.jarek.funds.services.impl;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.model.enums.ProfileOfInvesting;
import com.jarek.funds.services.CalculateService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculateServiceImplTest {

    private static final BigDecimal TEN_THOUSAND = new BigDecimal("10000");
    private static final BigDecimal TEN_THOUSAND_ONE = new BigDecimal("10001");
    private static final BigDecimal MONETARY_RESULT_EXAMPLE1 = new BigDecimal("500.00");
    private static final BigDecimal POLAND_RESULT_EXAMPLE1 = new BigDecimal("1000.00");
    private static final BigDecimal FOREIGN_RESULT_EXAMPLE1 = new BigDecimal("2500.00");
    

    CalculateService calculateService;

//     public List<Calculations> listOfObjectsForCalculation(Map<FundType, List<BigDecimal>> percentagesValues, Map<FundType, Integer> numberOfFundType, BigDecimal totalAmount) {
    
    @Test
    public void shouldReturnCalculationsWithAmountsAndPercentages() {
        //given
        List<Fund> funds = createFundListExample1();
        //when
        Map<FundType, Integer> numberOfFundType = calculateService.numberOfFundType(funds);
        Map<FundType, BigDecimal> percentages = calculateService.percentagesForFundType(ProfileOfInvesting.SAFE, numberOfFundType);
        Map<FundType, List<BigDecimal>> percentagesValues = calculateService.percentagesValues(percentages, numberOfFundType);
        List<Calculations> result = calculateService.listOfObjectsForCalculation(percentagesValues, numberOfFundType, TEN_THOUSAND);
        //then
        assertEquals(6, result.size());
    }
    
    @Test
    public void shouldReturnPercentagesIfPercentagesHasRestExample1() {
        //given
        List<Fund> funds = createFundListExample1();
        //when
        Map<FundType, Integer> numberOfFundType = calculateService.numberOfFundType(funds);
        Map<FundType, BigDecimal> percentages = calculateService.percentagesForFundType(ProfileOfInvesting.SAFE, numberOfFundType);
        Map<FundType, List<BigDecimal>> result = calculateService.percentagesValues(percentages, numberOfFundType);
        //then
        assertEquals(1, result.get(FundType.POLAND).size());
        assertEquals(1, result.get(FundType.FOREIGN).size());
        assertEquals(1, result.get(FundType.MONETARY).size());
    }
    
    @Test
    public void shouldReturnPercentagesIfPercentagesHasRestExample2() {
        //given
        List<Fund> funds = createFundListExample2();
        //when
        Map<FundType, Integer> numberOfFundType = calculateService.numberOfFundType(funds);
        Map<FundType, BigDecimal> percentages = calculateService.percentagesForFundType(ProfileOfInvesting.SAFE, numberOfFundType);
        Map<FundType, List<BigDecimal>> result = calculateService.percentagesValues(percentages, numberOfFundType);
        //then
        assertEquals(2, result.get(FundType.POLAND).size());
        assertEquals(1, result.get(FundType.FOREIGN).size());
        assertEquals(1, result.get(FundType.MONETARY).size());
    }
    
    @Test
    public void shouldReturnPercentagesForFundType() {
        //given
        List<Fund> funds = createFundListExample1();
        //when
        Map<FundType, Integer> numberOfFundType = calculateService.numberOfFundType(funds);
        Map<FundType, BigDecimal> result = calculateService.percentagesForFundType(ProfileOfInvesting.SAFE, numberOfFundType);
        //then
        assertEquals(new BigDecimal("10.00"), result.get(FundType.POLAND).setScale(2));
        assertEquals(new BigDecimal("25.00"), result.get(FundType.FOREIGN).setScale(2));
        assertEquals(new BigDecimal("5.00"), result.get(FundType.MONETARY).setScale(2));
    }

    @Test
    public void shouldReturnNumberOfFundType() {
        //given
        List<Fund> funds = createFundListExample1();
        //when
        Map<FundType, Integer> result = calculateService.numberOfFundType(funds);
        //then
        assertEquals(Integer.valueOf(2), result.get(FundType.POLAND));
        assertEquals(Integer.valueOf(3), result.get(FundType.FOREIGN));
        assertEquals(Integer.valueOf(1), result.get(FundType.MONETARY));
    }
    
    @Test
    public void shouldReturnAmountForCalculation() {
        //given
        BigDecimal amount = TEN_THOUSAND_ONE;
        //when
        BigDecimal result = calculateService.amountForCalculations(amount);
        //then
        assertEquals(TEN_THOUSAND, result);
    }

    @Test
    public void shouldReturnAmountForCalculation2() {
        //given
        BigDecimal amount = TEN_THOUSAND;
        //when
        BigDecimal result = calculateService.amountForCalculations(amount);
        //then
        assertEquals(TEN_THOUSAND, result);
    }

    @Test
    public void shouldReturnRemainder() {
        //given
        //when
        BigDecimal result = calculateService.remainder(TEN_THOUSAND_ONE);
        //then
        assertEquals(new BigDecimal(BigInteger.ONE), result);
    }

    @Before
    public void setUp() {
        calculateService = new CalculateServiceImpl();
    }

    private List<Fund> createFundListExample1() {
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
    
    private List<Fund> createFundListExample2() {
        List<Fund> funds = new ArrayList<>();

        Fund fund1 = new Fund(1L, "Fundusz Polski 1", FundType.POLAND);
        Fund fund2 = new Fund(2L, "Fundusz Polski 2", FundType.POLAND);
        Fund fund3 = new Fund(3L, "Fundusz Polski 3", FundType.POLAND);
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

}
