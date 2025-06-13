import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventCountdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your event date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        try {
            LocalDate eventDate = LocalDate.parse(inputDate);
            LocalDate today = LocalDate.now();

            Period period = Period.between(today, eventDate);

            if (period.isNegative()) {
                System.out.println("This event has already passed!");
            } else {
                System.out.printf("Your event is in %d months and %d days.%n",
                        period.getMonths(), period.getDays());
            }

        } catch (Exception e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }

        sc.close();
    }
}