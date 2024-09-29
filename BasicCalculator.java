import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");

        // Prompt the user to input two numbers
        System.out.print("Enter the first number: ");
        double num1 = getValidDoubleInput(sc);

        System.out.print("Enter the second number: ");
        double num2 = getValidDoubleInput(sc);

        System.out.println("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        // Perform the calculation based on the operator
        double result = performOperation(num1, num2, operator);

        // If a valid result was returned, display it
        if (!Double.isNaN(result)) {
            System.out.println("The result of " + num1 + " " + operator + " " + num2 + " is: " + result);
        }

        sc.close();
    }

    /**
     * Performs the arithmetic operation based on the operator.
     * @param num1 The first number.
     * @param num2 The second number.
     * @param operator The operator for the operation.
     * @return The result of the operation, or NaN if the operation is invalid.
     */
    public static double performOperation(double num1, double num2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return Double.NaN;
                }
                break;
            default:
                System.out.println("Error: Invalid operator. Please use one of (+, -, *, /).");
                return Double.NaN;
        }
        return result;
    }

    /**
     * Validates and retrieves a valid double input from the user.
     * @param sc The scanner to read input.
     * @return The valid double entered by the user.
     */
    public static double getValidDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Clear invalid input
        }
        return sc.nextDouble();
    }
}
