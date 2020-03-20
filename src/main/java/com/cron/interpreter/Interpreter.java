package com.cron.interpreter;

public class Interpreter {

    protected String expression;

    //TODO: Move the the method to an interface
    public void interpret() {
        System.out.println("Success");
    }

    public Interpreter(String expression) {
        this.expression = expression;
    }
}