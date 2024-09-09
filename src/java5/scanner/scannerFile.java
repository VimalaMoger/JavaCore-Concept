package java5.scanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class scannerFile {
	//data into file, read from file
	public static void main(String[] args) throws IOException {
		int count=0;
		double sum=0;
		 FileWriter wr= new FileWriter("C:\\Users\\..\\Desktop\\model.test.txt");//create new file in desktop folder
		 wr.write("2 3.4 5 6 7.4 9.1 10.5 done");
		 
		 wr.close();
		 FileReader rd = new FileReader("C:\\Users\\..\\Desktop\\model.test.txt"); //reopens the file name again
		 Scanner scan = new Scanner(rd);
		 while(scan.hasNext()) {
			 if(scan.hasNextDouble()) {
				 sum += scan.nextDouble();
				 count++;
				 
			 }else {
				 String str = scan.next();
				 if(str.equals("done")) {
					 break;
				 }else {
					 System.out.println("file format error");
					 return;
				 }
			 }
		 }
		 scan.close();
		 System.out.println("average is " + sum/count);
	}
}
