import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 12, 5, 24, 3, 18, 9, 14, 6, 11));
        Collections.sort(numbers);

        System.out.println("Even numbers:");

        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }

        HashMap<Integer, String> employees = new HashMap<>();
        employees.put(101, "Akash");
        employees.put(102, "Rishi");
        employees.put(103, "Pratham");

        System.out.println("\nEmployees:");
        for (int id : employees.keySet()) {
            System.out.println(id + " -> " + employees.get(id));
        }
    }
}