package com.sezzle.calculator.exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String s) {
        super(s);
    }

    public String toString() {
        return String.format("ERR: %s", this.getMessage());
    }
}
