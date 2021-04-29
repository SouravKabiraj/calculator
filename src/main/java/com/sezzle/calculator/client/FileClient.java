package com.sezzle.calculator.client;

import com.sezzle.calculator.interaction.CommandFactory;

import java.io.BufferedReader;

public class FileClient extends Client {
    public FileClient(BufferedReader inputReader, CommandFactory commandFactory) {
        super(inputReader, commandFactory);
    }
}
