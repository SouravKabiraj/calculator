package com.sezzle.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void TestToStringShouldReturnInteger() {
        Number number = new Number(12.000);
        String actualResult = number.toString();
        assertEquals("12", actualResult);
    }

    @Test
    void TestToStringShouldReturnDouble() {
        Number number = new Number(12.001);
        String actualResult = number.toString();
        assertEquals("12.001", actualResult);
    }

    @Test
    void TestGetDoubleShouldDoubleValue() {
        Number number = new Number(12.001);
        assertEquals(number.getDouble(), 12.001);
    }
}