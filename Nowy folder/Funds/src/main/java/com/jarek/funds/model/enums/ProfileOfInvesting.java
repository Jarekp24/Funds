package com.jarek.funds.model.enums;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum ProfileOfInvesting {

    SAFE(new BigDecimal(20), new BigDecimal(75), new BigDecimal(5)),
    BALANCED(new BigDecimal(30), new BigDecimal(60), new BigDecimal(10)),
    AGGRESSIVE(new BigDecimal(40), new BigDecimal(20), new BigDecimal(40));

    private final BigDecimal polandPercentage;
    private final BigDecimal foreignPercentage;
    private final BigDecimal monetaryPercentage;

    private ProfileOfInvesting(BigDecimal polandPercentage, BigDecimal foreignPercentage, BigDecimal monetaryPercentage) {
        this.polandPercentage = polandPercentage;
        this.foreignPercentage = foreignPercentage;
        this.monetaryPercentage = monetaryPercentage;
    }

    public BigDecimal getPolandPercentage() {
        return polandPercentage;
    }

    public BigDecimal getForeignPercentage() {
        return foreignPercentage;
    }

    public BigDecimal getMonetaryPercentage() {
        return monetaryPercentage;
    }

    public Map<FundType, BigDecimal> getPercentages() {
        Map<FundType, BigDecimal> percentages = new HashMap<>();
        percentages.put(FundType.POLAND, getPolandPercentage());
        percentages.put(FundType.FOREIGN, getForeignPercentage());
        percentages.put(FundType.MONETARY, getMonetaryPercentage());
        return percentages;
    }

}
