package task_10;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(12345, 1000.00);
        Thread t1 = new Thread(new TransactionRunnable(account, 200, true), "Runnable-Deposit-1");
        Thread t2 = new Thread(new TransactionRunnable(account, 150, false), "Runnable-Withdraw-1");
        TransactionThread t3 = new TransactionThread(account, 300, true);
        t3.setName("Thread-Deposit-1");
        TransactionThread t4 = new TransactionThread(account, 400, false);
        t4.setName("Thread-Withdraw-1");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}