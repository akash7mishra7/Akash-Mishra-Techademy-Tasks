import java.util.Scanner;

class Payment {
    public void payAmount() {
        System.out.println("Generic payment method selected.");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void payAmount() {
        System.out.println("Paying via Credit Card.");
    }
}

class UPIPayment extends Payment {
    @Override
    public void payAmount() {
        System.out.println("Paying via UPI.");
    }
}

class CashPayment extends Payment {
    @Override
    public void payAmount() {
        System.out.println("Paying via Cash.");
    }
}

public class Transaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose payment method: 1-Credit Card, 2-UPI, 3-Cash");
        int choice = sc.nextInt();

        Payment payment;
        switch (choice) {
            case 1:
                payment = new CreditCardPayment();
                break;
            case 2:
                payment = new UPIPayment();
                break;
            case 3:
                payment = new CashPayment();
                break;
            default:
                payment = new Payment();
        }
        payment.payAmount();
        System.out.println("Transaction Successful");
        sc.close();
    }
}
