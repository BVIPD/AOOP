package task_10;

public class Account {
    private int accountNumber;
    private double balance;
    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " 
                               + amount + ", new balance: " + balance);
        }
    }
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " 
                               + amount + ", new balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw " 
                               + amount + " due to insufficient funds.");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
