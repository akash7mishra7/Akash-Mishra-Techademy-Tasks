import java.util.Scanner;

interface Calculator2 {
    int operate(int a, int b);
}

public class LambdaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println("\nChoose operation:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        int choice = sc.nextInt();

        Calculator2 add = (a, b) -> a + b;
        Calculator2 subtract = (a, b) -> a - b;
        Calculator2 multiply = (a, b) -> a * b;
        Calculator2 divide = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            return a / b;
        };

        try {
            switch (choice) {
                case 1:
                    System.out.println("Result: " + add.operate(num1, num2));
                    break;
                case 2:
                    System.out.println("Result: " + subtract.operate(num1, num2));
                    break;
                case 3:
                    System.out.println("Result: " + multiply.operate(num1, num2));
                    break;
                case 4:
                    System.out.println("Result: " + divide.operate(num1, num2));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}