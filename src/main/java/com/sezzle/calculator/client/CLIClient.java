package com.sezzle.calculator.client;


import com.sezzle.calculator.interaction.CommandFactory;

import java.io.BufferedReader;

public class CLIClient extends Client {
    public CLIClient(BufferedReader inputReader, CommandFactory commandFactory) {
        super(inputReader, commandFactory);
    }
}