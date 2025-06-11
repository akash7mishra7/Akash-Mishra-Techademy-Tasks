import java.util.Scanner;

public class AreaCalculator {
    static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    static double calculateArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        double radius = scanner.nextDouble();
        System.out.println("Area of circle: " + calculateArea(radius));

        System.out.print("\nEnter length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        double width = scanner.nextDouble();
        System.out.println("Area of rectangle: " + calculateArea(length, width));

        scanner.close();
    }
}