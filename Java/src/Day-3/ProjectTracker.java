import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ProjectTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter project start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(sc.nextLine());
        LocalDate endDate = startDate.plusWeeks(2).plusDays(3);

        Period remaining = Period.between(LocalDate.now(), endDate);
        long daysRemaining = remaining.getDays();

        System.out.println("\nProject Timeline:");
        System.out.println("Start: " + startDate);
        System.out.println("End: " + endDate);
        System.out.println("Remaining: " + daysRemaining + " days");

        sc.close();
    }
}