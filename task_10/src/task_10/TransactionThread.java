package task_10;

public class TransactionThread extends Thread {
    private Account account;
    private double amount;
    private boolean deposit;

    public TransactionThread(Account account, double amount, boolean deposit) {
        this.account = account;
        this.amount = amount;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
