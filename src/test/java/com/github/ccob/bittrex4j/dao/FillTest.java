package com.github.ccob.bittrex4j.dao;

import org.junit.Test;

import java.time.Instant;
import java.math.BigDecimal;

public class FillTest {

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowWhenConstructedWithBothPriceAndRate() {
        new Fill(
            1L, null, "ORDER", "FILL",
            BigDecimal.valueOf(1.0),  // price
            BigDecimal.valueOf(1.0),  // rate
            BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0), Instant.now(), 2L, null
        );
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowWhenConstructedWithoutBothPriceAndRate() {
        new Fill(
            1L, null, "ORDER", "FILL",
            null,  // price
            null,  // rate
            BigDecimal.valueOf(1.0), BigDecimal.valueOf(1.0), Instant.now(), 2L, null
        );
    }
}
