package com.sezzle.calculator.interaction.commands;

import java.io.IOException;
import java.security.InvalidParameterException;

public interface Command {
    String helpText();

    void execute(String[] params) throws InvalidParameterException, IOException, InterruptedException;
}
