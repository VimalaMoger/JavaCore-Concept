package java1.fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {

	public static void main(String[] args) {
		
		String fileName= "C:\\Users\\..\\Desktop\\eng.txt";
		String line = "";
		try {
				FileInputStream file= new FileInputStream(fileName);
				InputStreamReader sr =new InputStreamReader(file);
				BufferedReader r = new BufferedReader(sr);
			
				 while((line = r.readLine()) != null) {
					System.out.println(line);
			}
			file.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
