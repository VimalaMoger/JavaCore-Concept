package java1.fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileToFileTransferData {

	public static void main(String[] args) {
		String file1=  "C:\\Users\\HP\\Desktop\\eng.txt";
		String file2=  "C:\\Users\\HP\\Desktop\\eng2.txt";
		
		//using try with resources
		try(FileOutputStream newFile= new FileOutputStream(file2);FileInputStream oldFile= new FileInputStream(file1)) {
		
			int input = 0;
			
			while(input != -1) {
				input= oldFile.read();
				newFile.write(input);
			}

			System.out.println("would you like to add more data ? yes or no");
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader r = new BufferedReader(ir);
			String yesOrNo =r.readLine();
			if(yesOrNo.equalsIgnoreCase("yes")) {
				while(input != 'q') {
					input= r.read();
					newFile.write(input);
				}
			}
			//newFile.close();
			//oldFile.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
