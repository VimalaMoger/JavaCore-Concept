package java5.concurrent.threads.multiThreads;

public class Race_Condition_Demo {
    public static void main(String[] args) {
        BankAccount setBalanceTask = new BankAccount();
        setBalanceTask.setBalance(100);
        //BankAccount object is represented by two threads
        Thread john = new Thread(setBalanceTask);
        Thread lisa = new Thread(setBalanceTask);
        john.setName("John");
        lisa.setName("Lisa");
        //both threads activated at the same time
        john.start();
        lisa.start();

    }
}
class BankAccount implements Runnable{
    private int balance;
    public void setBalance(int balance){
        this.balance = balance;
    }
    @Override
    public void run() {
        makeWithdrawal(75);
        if(balance < 0)
            System.out.println("Money overdrawn!!");
    }

    private void makeWithdrawal(int amount) {
        if(balance > amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw..");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn..");
        }else
            System.out.println("Sorry, not enough balance for "+ Thread.currentThread().getName() + " to withdraw");
    }
}
