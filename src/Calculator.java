import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static int _savedValue;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to calculator!");
        System.out.println("Choose operation:");
        System.out.println("0 - calculator");
        System.out.println("1 - save value");

        int mode = s.nextInt();
        s.close();
        // if (mode == 0) calculatorMode();
        // if (mode == 1) saveValue();
        if (mode == 0) {
            System.out.println("===Welcome to calculator mode!===");
            System.out.println("Write a simple expression: ");

            String expresion = s.nextLine();
            try {
                double result = calculatorMode(expresion);
                System.out.println(String.format("Result: %f", result));
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong expression!");
                return;
            }      
        } else if (mode == 1) {
            System.out.println("===Welcome to value saver===");
            System.out.println("Print value to save:");
            try {
                int inputValue = s.nextInt();
                saveValue(inputValue);
                System.out.println("Now you can use this value with %0!");
                main(null);
            } catch(InputMismatchException e) {
                System.out.println("This is not integer!");
                return;
            }
        }
    }

    public static double calculatorMode(String expression) {
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

    public static void saveValue(int value) {
        _savedValue = value;
    }
}
