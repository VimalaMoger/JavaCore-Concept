package java5.scanner;

import java.util.Scanner;

public class scannerData {
	public static void main(String[] args) {
		//input from keyboard
		Scanner data = new Scanner(System.in);
		int count=0;
		double sum=0.0;
		double s=0.0;
		while(data.hasNext()) {
			if(data.hasNextDouble()) {
				s= data.nextDouble();
				sum += s;
				System.out.println(++count);
			}else {
				break;
			}
		}
		System.out.println("Average is "+ sum/count);
		data.close();	
	}
}