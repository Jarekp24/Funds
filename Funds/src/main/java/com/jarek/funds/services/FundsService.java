package com.jarek.funds.services;

import com.jarek.funds.model.Fund;
import java.util.List;

public interface FundsService {
        
        List<Fund> createFundsExample1();
        
        List<Fund> createFundsExample2();
        
        void showFunds(List<Fund> funds);
        
}
