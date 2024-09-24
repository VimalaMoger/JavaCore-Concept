package java4.chainedException;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException {
	static void createFile(String path,String text) throws IOException{
		FileWriter wr= new FileWriter(path,true);
		wr.write(text);
		wr.close();
	}

	public static void main(String[] args) {
		//caller code
		String filePath= "hello.txt"; //just hello.txt will store under project folder
		String text="Hello World";
		try {
			createFile(filePath,text);
			
		}catch(IOException ex) {
			System.out.println("Error creating file: "+ ex);
		}

	}

}
