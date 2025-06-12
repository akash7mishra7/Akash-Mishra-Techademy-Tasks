import java.util.*;

public class ActivityPrograms {
    public static void TwoSum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int num2 = scanner.nextInt();
        System.out.print("Sum of Integers is: " +(num1+num2));
    }

    public static void PrintNumbers() {
        System.out.println("Even numbers between 1 and 100 (skipping multiples of 10):");
        for (int i = 2; i <= 100; i += 2) {
            if (i % 10 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        //TwoSum();
        //PrintNumbers();
    }
}