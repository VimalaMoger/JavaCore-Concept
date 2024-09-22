package java5.concurrent.threads.multiThreads;

public class Synchronized_Block_Demo {
    public static void main(String[] args) {
        BankAcct setBalanceTask = new BankAcct();
        setBalanceTask.setBalance(100);

        Thread john = new Thread(setBalanceTask);
        Thread lisa = new Thread(setBalanceTask);
        john.setName("John");
        lisa.setName("Lisa");
        john.start();
        lisa.start();

    }
}
class BankAcct implements Runnable{
    private int balance;
    public synchronized void setBalance(int balance){
        this.balance = balance;
    }
    @Override
    public void run() {
        makeWithdrawal(75);
        if(balance < 0)
            System.out.println("Money overdrawn!!");
    }

    private synchronized void makeWithdrawal(int amount) {
        if(balance > amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw..");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn..");
        }else
            System.out.println("Sorry, not enough balance for "+ Thread.currentThread().getName() + " to withdraw");
    }
}
