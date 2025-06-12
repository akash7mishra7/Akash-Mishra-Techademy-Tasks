class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Calculation {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum of 5 and 10 (int): " + calc.add(5, 10));
        System.out.println("Sum of 3.5 and 2.7 (double): " + calc.add(3.5, 2.7));
        System.out.println("Sum of 10, 20, and 30 (three ints): " + calc.add(10, 20, 30));
    }
}