package com.sezzle.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractorTest {

    @Test
    void testExecuteShouldReturn3() {
        Number result = new Subtractor().execute(new Number("10"), new Number("7"));
        assertEquals(new Number("3"), result);
    }
}