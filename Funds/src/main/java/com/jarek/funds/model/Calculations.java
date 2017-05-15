package com.jarek.funds.model;

import com.jarek.funds.model.enums.FundType;
import java.math.BigDecimal;

public class Calculations {

    private FundType fundType;
    private BigDecimal percentage;
    private BigDecimal amount;

    public Calculations(FundType fundType, BigDecimal percentage, BigDecimal amount) {
        this.fundType = fundType;
        this.percentage = percentage;
        this.amount = amount;
    }

    public FundType getFundType() {
        return fundType;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
