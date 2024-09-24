package java5.scanner;

import java.io.IOException;
import java.util.Scanner;

public class FindInLineWithScanner {

	public static void main(String[] args) throws IOException {
		String r = "name : tom age: 28 ID :99";
		 Scanner scan = new Scanner(r);
		//finds the next occurrence
		 scan.findInLine("age:");
		
			 if(scan.hasNext()) {
				System.out.println(scan.next());
			 }else {
				 System.out.println("error");
			 }
		 scan.close();
	}
}
