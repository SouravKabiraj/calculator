package com.sezzle.calculator.domain;


import com.sezzle.calculator.exceptions.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {
    private Map<OperationSymbol, List<Integer>> symbolLocations;
    private Map<OperationSymbol, Operation> symbolOperationMap;
    private List<OperationSymbol> bodmasSequence;

    public Calculator() {
        symbolLocations = new HashMap<>();
        symbolOperationMap = new HashMap<>();
        symbolOperationMap.put(OperationSymbol.ADD, new Adder());
        symbolOperationMap.put(OperationSymbol.SUB, new Subtractor());
        symbolOperationMap.put(OperationSymbol.MUL, new Multiplier());
        symbolOperationMap.put(OperationSymbol.DIV, new Divider());
        bodmasSequence = Arrays.asList(OperationSymbol.DIV, OperationSymbol.MUL, OperationSymbol.ADD, OperationSymbol.SUB);
    }

    public String evaluate(String input) throws InvalidInputException {
        List<OperationSymbol> ops = new ArrayList<>();
        int symbolCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            switch (currChar) {
                case '+':
                    ops.add(OperationSymbol.ADD);
                    registerOperation(symbolCount, OperationSymbol.ADD);
                    symbolCount++;
                    break;
                case '-':
                    ops.add(OperationSymbol.SUB);
                    registerOperation(symbolCount, OperationSymbol.SUB);
                    symbolCount++;
                    break;
                case '*':
                    ops.add(OperationSymbol.MUL);
                    registerOperation(symbolCount, OperationSymbol.MUL);
                    symbolCount++;
                    break;
                case '/':
                    ops.add(OperationSymbol.DIV);
                    registerOperation(symbolCount, OperationSymbol.DIV);
                    symbolCount++;
                    break;
                case '.':
                    break;
                default:
                    if ('0' > currChar || currChar > '9') {
                        throw new InvalidInputException("INVALID CHARACTER ENTERED!");
                    }
            }
        }
        List<Number> operands = Arrays.asList(input.split("[-+*/]")).stream().map(operand -> new Number(operand)).collect(Collectors.toList());
        bodmasSequence.stream().forEach(op -> {
            for (int i = 0; i < ops.size(); i++) {
                if (op == ops.get(i)) {
                    Number result = symbolOperationMap.get(op).execute(operands.get(i), operands.get(i + 1));
                    operands.add(i, result);
                    operands.remove(i + 1);
                    operands.remove(i + 1);
                    ops.remove(i);
                    i--;
                }
            }
        });
        return operands.get(0).toString();
    }

    private void registerOperation(int index, OperationSymbol add) {
        if (!symbolLocations.containsKey(add)) {
            symbolLocations.put(add, new ArrayList<>());
        }
        List<Integer> indexes = symbolLocations.get(add);
        indexes.add(index);
        symbolLocations.put(add, indexes);
    }
}
