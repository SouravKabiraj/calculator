package com.sezzle.calculator.interaction.commands;

import com.sezzle.calculator.handlers.CalculatorCommandHandler;

import java.security.InvalidParameterException;

public class ClearCommand implements Command {
    private CalculatorCommandHandler parkingLotCommandHandler;

    public ClearCommand(CalculatorCommandHandler parkingLotCommandHandler) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "@ To clear screen type @\n clean";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        // TODO: need to be implemented
    }
}
