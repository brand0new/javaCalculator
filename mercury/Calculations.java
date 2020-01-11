package com.mercury;

import java.util.Stack;

public class Calculations {
    public static double main(String input) {

        // transforming input to string array for calculating results 
        //String[] parts = input.split("^(\\d+)([/+\\-*])(\\d+)");

        char[] rpn = input.toCharArray();   // e.g. ['5','+','4']

        double x = Double.parseDouble(rpn[1].toString()), y, result = 0.0;
        System.out.println(rpn);

        // a stack for the Double object is created since a stack can't handle a primitive type (double)
        // for each character in the string will be checked if it is a operator or not
        // in case of an operator the preceding entries will be processed


        return evalOperation(x,y,ops);
    }
    private static double evalOperation(double x, double y, char c){
        // simple switch to decide which calculation to do. possible to use the operator char??
        double result = 0.0;

        switch (c) {
            case '+': result = x + y;
                break;
            case '*': result = x * y;
                break;
            case '/': result = x / y;
                break;
            case '-': result = x - y;
                break;
        }
        return result;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
}

