package com.sezzle.calculator.interaction.commands;

import com.sezzle.calculator.handlers.CalculatorCommandHandler;

import java.security.InvalidParameterException;

public class CalculateCommand implements Command {
    private CalculatorCommandHandler calculatorCommandHandler;

    public CalculateCommand(CalculatorCommandHandler calculatorCommandHandler) {
        this.calculatorCommandHandler = calculatorCommandHandler;
    }

    @Override
    public String helpText() {
        return "@ To execute calculator operations type @ \n> {number}{operation}{number}{operation}...";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        if (params.length < 1) {
            throw new InvalidParameterException("Expected one parameter!");
        }
        if (params[0].equals("help")) {
            System.out.println(helpText());
            return;
        }
        calculatorCommandHandler.evaluate(params[0]);
    }
}