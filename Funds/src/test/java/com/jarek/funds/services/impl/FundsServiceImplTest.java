package com.jarek.funds.services.impl;

import com.jarek.funds.model.Fund;
import com.jarek.funds.services.FundsService;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FundsServiceImplTest {
    
    FundsService fundsService;
    
    @Test
    public void shouldReturnFundListExample1() {
        //given
        //when
        List<Fund> result = fundsService.createFundsExample1();
        //then
        assertEquals(6, result.size());
    }
    
    @Test
    public void shouldReturnFundListExample2() {
        //given
        //when
        List<Fund> result = fundsService.createFundsExample2();
        //then
        assertEquals(6, result.size());
    }
    
    @Before()
    public void setUp() {
        fundsService = new FundsServiceImpl();
    }
    
}
