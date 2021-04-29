package com.sezzle.calculator.domain;

public class Number {
    Double number;

    public Number(String num) {
        number = Double.valueOf(num);
    }

    public Number(double num) {
        number = num;
    }

    @Override
    public String toString() {
        String numberAsString = number.toString();
        String[] decimalSplit = numberAsString.split("[.]");
        if (decimalSplit[1].equals("0")) {
            return decimalSplit[0];
        }
        return numberAsString;
    }

    @Override
    public boolean equals(Object obj) {
        Number otherNumber = (Number) obj;
        return otherNumber.toString().equals(toString());
    }

    public double getDouble() {
        return Double.valueOf(number);
    }
}
