package com.jarek.funds.services;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.model.enums.ProfileOfInvesting;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CalculateService {

        Map<FundType, Integer> numberOfFundType(List<Fund> funds);
                
        Map<FundType, BigDecimal> percentagesForFundType(ProfileOfInvesting profile, Map<FundType, Integer> numberOfFundType);
        
        Map<FundType, List<BigDecimal>> percentagesValues(Map<FundType, BigDecimal> percentagesForFundType, Map<FundType, Integer> numberOfFundType);
        
        List<Calculations> listOfObjectsForCalculation(Map<FundType, List<BigDecimal>> percentagesValues, Map<FundType, Integer> numberOfFundType, BigDecimal totalAmount);
        
        BigDecimal amountForCalculations(BigDecimal totalAmount);
        
        BigDecimal remainder(BigDecimal totalAmount);
}
