import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Employee extends Person {
    String designation;
    double salary;

    Employee(String name, int age, String designation, double salary) {
        super(name, age);
        this.designation = designation;
        this.salary = salary;
    }
    void displayEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        displayPersonDetails();
        System.out.println("Designation: " + designation);
        System.out.println("Salary: ₹" + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter employee designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, age, designation, salary);
        emp.displayEmployeeDetails();

        sc.close();
    }
}
