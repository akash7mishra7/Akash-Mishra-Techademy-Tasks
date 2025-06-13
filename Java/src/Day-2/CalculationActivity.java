import mathutils.Calculator;

public class CalculationActivity {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        System.out.println("Addition: " + Calculator.add(num1, num2));
        System.out.println("Subtraction: " + Calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + Calculator.multiply(num1, num2));
    }
}