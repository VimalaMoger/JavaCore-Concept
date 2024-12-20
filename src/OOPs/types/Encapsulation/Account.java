package OOPs.types.Encapsulation;

public class Account {
    private float balance;

    //Encapsulation principle
    public float getBalance(){
        return balance;
    }

    public void deposit(float amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public void withdraw(float amount){
        if(amount > 0){
            this.balance -= amount;
        }
    }
}

