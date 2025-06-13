abstract class Employee2 {
    String name;
    int id;

    Employee2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}
class FullTimeEmployee extends Employee2 {
    double monthlySalary;
    double bonus;

    FullTimeEmployee(String name, int id, double monthlySalary, double bonus) {
        super(name, id);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return monthlySalary + bonus;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Full-Time");
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateSalary());
    }
}
class PartTimeEmployee extends Employee2 {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Part-Time");
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: " + calculateSalary());
    }
}
public class AbstractClass {
    public static void main(String[] args) {

        Employee2 fullTimer = new FullTimeEmployee("Akash Mishra", 101, 5000, 1000);
        Employee2 partTimer = new PartTimeEmployee("Yash Nirgun", 102, 20.5, 80);

        fullTimer.displayDetails();
        System.out.println();
        partTimer.displayDetails();
    }
}