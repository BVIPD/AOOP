package tashk11_1;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + " | New Balance: $" + balance);
    }
    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw $" + amount + " but insufficient funds.");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
