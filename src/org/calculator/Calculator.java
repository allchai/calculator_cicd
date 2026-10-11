package org.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private int _savedValue;

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to calculator!");
        System.out.println("Choose operation:");
        System.out.println("0 - calculator");
        System.out.println("1 - save value");

        int mode = scanner.nextInt();
        if (mode == 0) {
            System.out.println("===Welcome to calculator mode!===");
            System.out.println("Write a simple expression: ");
            String expression = scanner.nextLine();
            try {
                double result = calculatorMode(expression);
                System.out.println(String.format("Result: %f", result));
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong expression!");
                scanner.close();
                return;
            }      
        } else if (mode == 1) {
            System.out.println("===Welcome to value saver===");
            System.out.println("Print value to save:");
            try {
                int inputValue = scanner.nextInt();
                saveValue(inputValue);
                System.out.println("Now you can use this value with %0!");
                main(null);
            } catch(InputMismatchException e) {
                System.out.println("This is not integer!");
                scanner.close();
                return;
            }
        }
        scanner.close();
    }

    public double calculatorMode(String expression) {
        var expressionParts = expression.split(" ");
        int arg_a = 0;
        int arg_b = 0;
        double result = 0;

        if (expressionParts[0].equals("%0")) {
            arg_a = _savedValue;
        }
        else arg_a = Integer.parseInt(expressionParts[0]);

        if (expressionParts[2].equals("%0")) {
            arg_b = _savedValue;
        } 
        else arg_b = Integer.parseInt(expressionParts[2]);

        switch (expressionParts[1]) {
            case "+":
                result = arg_a + arg_b;
                break;
        
            case "-":
                result = arg_a - arg_b;
                break;
            
            case "/":
                result = arg_a / arg_b;
                break;

            case "*":
                result = arg_a / arg_b;
                break;

            case "^":
                result = Math.pow(arg_a, arg_b);
                break;

            default:
                throw new IllegalArgumentException("Error in expression");
        }

        return result;
    }

    public void saveValue(int value) {
        _savedValue = value;
    }
}
