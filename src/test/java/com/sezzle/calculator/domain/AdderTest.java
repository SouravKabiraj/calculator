package com.sezzle.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @Test
    void testExecuteShouldReturn12Point01() {
        Number result = new Adder().execute(new Number("12"), new Number("0.01"));
        assertEquals(new Number("12.01"), result);
    }

    @Test
    void testExecuteShouldReturn12() {
        Number result = new Adder().execute(new Number("5"), new Number("7"));
        assertEquals(new Number("12"), result);
    }
}