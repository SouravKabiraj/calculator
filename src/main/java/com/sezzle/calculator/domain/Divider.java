package com.sezzle.calculator.domain;

public class Divider implements Operation {
    @Override
    public Number execute(Number num1, Number num2) {
        return new Number(num1.getDouble() / num2.getDouble());
    }
}
