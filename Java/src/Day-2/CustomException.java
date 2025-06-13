import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers for division:");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        try {
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            double result = num1 / num2;
            System.out.println("Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nEnter your age:");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older");
            }
            System.out.println("Age is valid!");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}