package com.example.gbandroidcalculator;

import java.util.LinkedList;

class Calculator {
    private double result;
    private LinkedList<String> expression;
    private StringBuilder digitBuffer;

    Calculator() {
        expression = new LinkedList<>();
        result = 0;
        digitBuffer = new StringBuilder();
    }

    public void add(char c) {
        if (c == '=') {
            expression.clear();
            expression.add(Double.toString(result));
            digitBuffer.delete(0, digitBuffer.length());
            digitBuffer.append(result);
            result = 0;
            return;
        }
        if (c == 'C') {
            expression.clear();
            digitBuffer.delete(0, digitBuffer.length());
            result = 0;
            return;
        }

        if (symbolIsCorrect(c)) {
            if (digitBuffer.length() > 0) {
                expression.removeLast();
            }
            digitBuffer.append(c);
            expression.add(digitBuffer.toString());
            calculate();
        } else {
            if (digitBuffer.length() != 0) {
                digitBuffer.delete(0, digitBuffer.length());
            }

            switch (expression.getLast()) {
                case "-":
                case "+":
                case "*":
                case "/":
                    expression.removeLast();
                    break;
            }
            expression.add(String.valueOf(c));
        }

    }

    private boolean symbolIsCorrect(char c) {
        if (Character.isDigit(c))
            return true;

        if (c == '-' && expression.isEmpty())
            return true;

        if (c == '.' && digitBuffer.length() != 0 && digitBuffer.indexOf(".") == -1)
            return true;
        //TODO: доделать обработку двойных точек
        return false;
    }

    private void calculate() {
        if (expression.size() < 3)
            return;

        LinkedList<String> exp = new LinkedList<>(expression);
        int prior = 2;
        double res;

        while (prior > 0) {
            for (int i = 0; i < exp.size(); i++) {
                if (priority(exp.get(i)) == prior) {
                    res = calc(exp.get(i - 1), exp.get(i + 1), exp.get(i));
                    exp.set(i, String.valueOf(res));
                    exp.remove(i + 1);
                    exp.remove(i - 1);
                    i--;
                }
            }
            prior--;
        }
        result = Double.parseDouble(exp.getFirst());
    }

    private int priority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private double calc(String o1, String o2, String operation) {
        double a = Double.parseDouble(o1);
        double b = Double.parseDouble(o2);
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0)
                    return a / b;
                else
                    return Double.MAX_VALUE;
                //TODO: доделать деление на ноль
        }
        return 0;
    }

    public String getResult() {
        return Double.toString(result);
    }

    public String getExpression() {
        StringBuilder expr = new StringBuilder();
        for (String symbol : expression) {
            expr.append(symbol);
        }
        return expr.toString();
    }
}
