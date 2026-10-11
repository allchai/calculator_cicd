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
        if (mode == 0) calculatorMode();
        if (mode == 1) saveValue();
    }

    public static void calculatorMode() {
        Scanner s = new Scanner(System.in);
        
        System.out.println("===Welcome to calculator mode!===");
        System.out.println("Write a simple expression: ");
        
        String expression = s.nextLine();

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
                System.out.println("Error in expression!");
                s.close();
                return;
        }

        System.out.println(String.format("Result: %f", result));
        s.close();
    }

    public static void saveValue() {
        Scanner s = new Scanner(System.in);

        System.out.println("===Welcome to value saver===");
        System.out.println("Print value to save:");
        _savedValue = s.nextInt();
        System.out.println("Now you can use this value with %0!");
        
        s.close();
        main(null);
    }
}
