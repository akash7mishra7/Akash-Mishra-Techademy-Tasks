import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double balance = 5000.00;
        System.out.println("Current Balance: ₹" + balance);
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        try {
            withdraw(balance, amount);
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: ₹" + (balance - amount));
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for banking with us!");
            sc.close();
        }
    }

    public static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. You tried to withdraw ₹" + amount +
                            " but only have $" + balance + " available."
            );
        }
    }
}