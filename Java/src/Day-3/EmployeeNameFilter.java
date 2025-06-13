import java.util.Arrays;
import java.util.List;

public class EmployeeNameFilter {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Alice", "Bob", "Anna", "Alex", "David", "Amanda", "Aaron");

        List<String> result = employees.stream()
                .filter(name -> name.startsWith("A"))
                .map(name -> name.toUpperCase())
                .toList();
        System.out.println(result);
    }
}