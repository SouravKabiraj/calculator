package com.sezzle.calculator.handlers;

import com.sezzle.calculator.domain.Calculator;
import com.sezzle.calculator.exceptions.InvalidInputException;

public class CalculatorCommandHandler {
    Calculator calculator;

    public CalculatorCommandHandler() {
        createCalculator();
    }

    public void createCalculator() {
        calculator = new Calculator();
    }

    public void evaluate(String input) {
        try {
            String output = calculator.evaluate(input);
            System.out.printf("ANS: %s%n", output);
        } catch (InvalidInputException invalidInputException) {
            System.out.println(invalidInputException);
        }
    }
}
