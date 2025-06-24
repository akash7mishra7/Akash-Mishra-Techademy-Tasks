class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.deposit(1);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.deposit(1);
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final balance: " + account.getBalance()); // 2000
    }
}
