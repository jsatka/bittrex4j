package com.github.ccob.bittrex4j.dao;


import org.junit.Test;

import java.time.Instant;
import java.math.BigDecimal;

public class FillTest {

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowWhenConstructedWithBothPriceAndRate(){
        new Fill(1L,null,"ORDER","FILL",BigDecimal.valueOf(1.0),BigDecimal.valueOf(2.0),BigDecimal.valueOf(1.0),BigDecimal.valueOf(1.0), Instant.now(),2,null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowWhenConstructedWithoutBothPriceAndRate(){
        new Fill(1L,null,"ORDER","FILL",null,null,BigDecimal.valueOf(1.0),BigDecimal.valueOf(1.0), Instant.now(),2,null);
    }
}
