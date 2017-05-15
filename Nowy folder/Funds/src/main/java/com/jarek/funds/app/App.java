package com.jarek.funds.app;

import com.jarek.funds.model.Fund;
import com.jarek.funds.model.enums.ProfileOfInvesting;
import com.jarek.funds.services.FundsService;
import com.jarek.funds.services.impl.CalculateServiceImpl;
import com.jarek.funds.services.impl.DivisionServiceImpl;
import com.jarek.funds.services.impl.FundsServiceImpl;
import java.math.BigDecimal;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm(new CalculateServiceImpl(), new FundsServiceImpl(), new DivisionServiceImpl());
        FundsService fundsService = new FundsServiceImpl();
        List<Fund> fundsListexample1 = fundsService.createFundsExample1();
        List<Fund> fundsListexample2 = fundsService.createFundsExample2();
        //przykłąd 1 dla kwoty 10 000
        System.out.println("===============================Przykład 1 dla kwoty 10 000=======================");
        algorithm.start(new BigDecimal("10000"), ProfileOfInvesting.SAFE, fundsListexample1);
        //przykład 1 dla kwoty 10 001
        System.out.println("===============================Przykład 1 dla kwoty 10 001=========================");
        algorithm.start(new BigDecimal("10001"), ProfileOfInvesting.SAFE, fundsListexample1);
        //przykład 2 dla kwoty 10 000
        System.out.println("===============================Przykład 2 dla kwoty 10 000========================");
        algorithm.start(new BigDecimal("10000"), ProfileOfInvesting.SAFE, fundsListexample2);

    }

}
