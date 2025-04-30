package tashk11_1;
public class BankSimulation {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000); 
        Thread t1 = new Thread(new Transaction(sharedAccount, true, 500), "User-1");
        Thread t2 = new Thread(new Transaction(sharedAccount, false, 200), "User-2");
        Thread t3 = new Thread(new Transaction(sharedAccount, true, 300), "User-3");
        Thread t4 = new Thread(new Transaction(sharedAccount, false, 700), "User-4");
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
        System.out.println("Final Account Balance: $" + sharedAccount.getBalance());
    }
}
