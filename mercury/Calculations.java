package com.mercury;

public class Calculations {
    public static double main(String input){
        char operator = '+';
        double x = 0.0, y = 0.0, result = 0.0;
        switch(operator){
            case '+' : result = Calculations.addition(x,y);
                break;
            case '*' : result = Calculations.multiplication(x,y);
                break;
            case '/' : result = Calculations.division(x,y);
                break;
            case '-' : result = Calculations.substraction(x,y);
                break;
        }

        return result;
    }

    public static double addition(double x, double y){

        return x + y;
    }

    public static double division(double x, double y){

        return x / y;
    }

    public static double multiplication(double x, double y){

        return x * y;
    }

    public static double substraction(double x, double y){

        return x - y;
    }
}
