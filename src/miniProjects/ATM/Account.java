package miniProjects.ATM;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Account {
	private int customerNumber;
	private int customerPin;
	protected double checkingBalance = 0;
	protected double savingsBalance = 0;

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	Scanner scan = new Scanner(System.in);
	//Locale locale = new Locale("en", "US");  
	//DecimalFormat moneyFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale); //new DecimalFormat("'$'###,##0.00");
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int amount) {
		this.customerNumber= amount;

	}

	public int getCustomerPin() {
		return customerPin;
	}

	public void setCustomerPin(int customerPin) {
		this.customerPin = customerPin;
	}
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance -amount);
		return checkingBalance;
	}
	public double calcSavingsWithdraw(double amount) {
		savingsBalance = (savingsBalance -amount);
		return savingsBalance;
	}
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	public double calcSavingsDeposit(double amount) {
		savingsBalance = (savingsBalance  + amount);
		return savingsBalance;
	}
	public void getCheckingWithdrawInput() {
		System.out.println("Checking account balance: "+ moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to withdraw from checking account: ");
		double amount = scan.nextDouble();
		if((checkingBalance - amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}else
			System.out.println("Balance can not be negative" +"\n");
			
		}
	public void getCheckingDepositInput() {
		System.out.println("Checking account balance: "+ moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to deposit to checking account: ");
		double amount = scan.nextDouble();
		if((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		}else
			System.out.println("Balance can not be negative" +"\n");
			
		}
	public void getSavingsWithdrawInput() {
		System.out.println("Savings account balance: "+ moneyFormat.format(savingsBalance));
		System.out.println("Amount you want to withdraw from saving account: ");
		double amount = scan.nextDouble();
		if((savingsBalance - amount) >= 0) {
			calcSavingsWithdraw(amount);
			System.out.println("New saving Account Balance: " + moneyFormat.format(savingsBalance));
		}else
			System.out.println("Balance can not be negative" +"\n");
			
		}
	public void getSavingsDepositInput() {
		System.out.println("Savings account balance: "+ moneyFormat.format(savingsBalance));
		System.out.println("Amount you want to deposit to saving account: ");
		double amount = scan.nextDouble();
		if((savingsBalance + amount) >= 0) {
			calcSavingsDeposit(amount);
			System.out.println("New saving Account Balance: " + moneyFormat.format(savingsBalance));
		}else
			System.out.println("Balance can not be negative" +"\n");
			
		}


}
