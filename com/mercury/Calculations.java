package com.mercury;
import java.util.Stack;

public class Calculations {
    public static double main(String input) {
        char chars[] = input.toCharArray();
        Stack<Integer> inputInt = new Stack<>();
        Stack<Character> inputChar = new Stack<>();

        for (char aChar : chars) {
            if (isOperator(aChar)) {
                inputChar.push(aChar);
            } else {
                inputInt.push(Character.digit(aChar, 10));
            }
        }

        int x = inputInt.pop(), y = inputInt.pop();
        char ops = inputChar.pop();

        System.out.println(x + y + ops);

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

