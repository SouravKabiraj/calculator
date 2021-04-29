package com.sezzle.calculator.exceptions;

public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String name) {
        super(name);
    }
}
