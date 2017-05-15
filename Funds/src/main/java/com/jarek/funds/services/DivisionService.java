package com.jarek.funds.services;

import com.jarek.funds.model.Calculations;
import com.jarek.funds.model.Division;
import com.jarek.funds.model.Fund;
import java.util.List;

public interface DivisionService {

    List<Division> createDivions(List<Fund> fundsList, List<Calculations> percentageForCalc);

    void showResult(List<Division> result);
    
}
