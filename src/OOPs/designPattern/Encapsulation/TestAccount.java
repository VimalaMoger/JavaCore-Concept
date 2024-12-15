package OOPs.designPattern.Encapsulation;

public class TestAccount{
    public static void main(String[] args) {
        var account = new Account();
        //account.balance = 1000; private member
       // account.setBalance(1000);

        account.deposit(1000);
        account.withdraw(100);
        System.out.println(account.getBalance());
    }
}