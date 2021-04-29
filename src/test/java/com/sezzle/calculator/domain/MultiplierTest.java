package com.sezzle.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierTest {

    @Test
    void testExecuteShouldReturn10() {
        Number result = new Multiplier().execute(new Number(2), new Number("5"));
        assertEquals(new Number(10), result);
    }
}