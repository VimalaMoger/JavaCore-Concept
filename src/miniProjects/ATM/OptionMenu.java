package miniProjects.ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner scan = new Scanner(System.in);
	//Locale locale = new Locale("en", "US");  
	//DecimalFormat moneyFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<>();

	public void getLogin() throws IOException{
		int x =1;
		do {
			try {
				data.put(952141, 191904);
				data.put(952142, 191905);
				System.out.println("Welcome to the ATM Project!");
				System.out.println("Enter your customer number");
				setCustomerNumber(scan.nextInt());
				System.out.println("Enter your pin number");
				setCustomerPin(scan.nextInt());
			}catch(Exception e) {
				System.out.println("\n" + "Invalid entry,Enter your Customer number" +"\n");
				x=2;
			}
			int custNum = getCustomerNumber();
			int custPin = getCustomerPin();
			if(data.containsKey(custNum) && data.get(custNum)== custPin) {
				getAccountType();
			}else {
				
				System.out.println("\n" + "Invalid entry" +"\n");
			}
		}while(x ==1);
	}

	private void getAccountType() {
		System.out.println("Select the Account you want to Access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			getChecking();
			break;
			
		case 2:
			getSavings();
			break;
		
		case 3:
			System.out.println("Thank you for using ATM, bye. \n");
			break;
		}
	}

	private void getSavings() {
		System.out.println("Savings Account:  ");
		System.out.println("Type-1 - View Balance ");
		System.out.println("Type-2 - Withdraw Funds  ");
		System.out.println("Type-3 - Deposit Funds ");
		System.out.println("Type-4 - Exit ");
		System.out.println("What is your Choice: ");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Savings Account Balance:  " + moneyFormat.format(getSavingsBalance()));
			getAccountType();
			break;
		case 2:
			getSavingsWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingsDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using ATM, bye. \n");
			break;
		default:
			System.out.println("\n" + "Invalid choice ,Enter your choice" +"\n");
			getChecking();
			}
		
		
	}



	private void getChecking() {
		System.out.println("Checking Account:  ");
		System.out.println("Type-1 - View Balance ");
		System.out.println("Type-2 - Withdraw Funds  ");
		System.out.println("Type-3 - Deposit Funds ");
		System.out.println("Type-4 - Exit ");
		System.out.println("What is your Choice: ");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance:  " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using ATM, bye. \n");
			break;
		default:
			System.out.println("\n" + "Invalid choice ,Enter your choice" +"\n");
			getChecking();
			}
	}


		
}


