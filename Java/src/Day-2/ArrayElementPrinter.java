import java.util.Scanner;

public class ArrayElementPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the index to print: ");
        int index = sc.nextInt();

        try {
            System.out.println("Element at index " + index + " is: " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is out of bounds for array of size " + size);
        }

        sc.close();
    }
}