interface PaymentGateway {
    void processPayment(double amount);
}

class CreditCard_Payment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of ₹" + amount);
    }
}

class UPI_Payment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {

        PaymentGateway creditCard = new CreditCard_Payment();
        PaymentGateway upi = new UPI_Payment();

        creditCard.processPayment(1000.50);
        upi.processPayment(500.25);

    }
}