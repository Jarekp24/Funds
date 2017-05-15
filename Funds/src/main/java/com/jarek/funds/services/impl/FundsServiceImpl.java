package com.jarek.funds.services.impl;

import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.FundType;
import com.jarek.funds.services.FundsService;
import java.util.ArrayList;
import java.util.List;

public class FundsServiceImpl implements FundsService{

        @Override
        public List<Fund> createFundsExample1() {
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
        
        @Override
        public List<Fund> createFundsExample2() {
                List<Fund> funds = new ArrayList<>();

                Fund fund1 = new Fund(1L, "Fundusz Polski 1", FundType.POLAND);
                Fund fund2 = new Fund(2L, "Fundusz Polski 2", FundType.POLAND);
                Fund fund3 = new Fund(3L, "Fundusz Polski 3", FundType.POLAND);
                Fund fund4 = new Fund(4L, "Fundusz Zagraniczny 1", FundType.FOREIGN);
                Fund fund5 = new Fund(5L, "Fundusz Zagraniczny 2", FundType.FOREIGN);
                Fund fund6 = new Fund(6L, "Fundusz Pieniężny 1", FundType.MONETARY);

                funds.add(fund1);
                funds.add(fund2);
                funds.add(fund3);
                funds.add(fund4);
                funds.add(fund5);
                funds.add(fund6);

                return funds;
        }
        
        @Override
        public void showFunds(List<Fund> funds) {
                System.out.println("================Lista funduszy==============");
                funds.forEach(fund -> {
                        System.out.println(fund.getId() + " " + fund.getName() + " " + fund.getType());
                });
        }

}
