package com.sezzle.calculator.domain;

import com.sezzle.calculator.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void TestEvaluateShouldReturn12ForGivenInput() throws InvalidInputException {
        Calculator calculator = new Calculator();
        String result = calculator.evaluate("12/10*10+8-8");
        assertEquals("12", result);
    }

    @Test
    void TestEvaluateShouldReturn2Point5ForGivenInput() throws InvalidInputException {
        Calculator calculator = new Calculator();
        String result = calculator.evaluate("2.5/2*2");
        assertEquals("2.5", result);
    }

    @Test
    void TestEvaluateShouldThrowInvalidInputException() {
        Calculator calculator = new Calculator();
        assertThrows(InvalidInputException.class, () -> calculator.evaluate("2.5/sdfj*2"));
    }
}