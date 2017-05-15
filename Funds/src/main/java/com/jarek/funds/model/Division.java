package com.jarek.funds.model;

public class Division {

    private Fund fund;
    private Calculations calculations;

    public Division(Fund fund, Calculations calculations) {
        this.fund = fund;
        this.calculations = calculations;
    }

    public Fund getFund() {
        return fund;
    }

    public Calculations getCalculations() {
        return calculations;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public void setCalculations(Calculations calculations) {
        this.calculations = calculations;
    }

}
