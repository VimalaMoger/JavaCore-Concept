package java1.fileIO;

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteToFile {

	public static void main(String[] args) {
		String fileName= "C:\\Users\\..\\Desktop\\eng.txt";
		
		//read a file
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(ir);

		int fileRead = 0;
		try {
				FileOutputStream file= new FileOutputStream(fileName);
				//OutputStreamWriter sr =new OutputStreamWriter(file);
				//BufferedWriter r = new BufferedWriter(sr);
			
				while(fileRead  != 'q') {
					fileRead= r.read();
			
					file.write(fileRead);;
					System.out.print(fileRead + ' ');
			
				}	file.close();
				}catch(IOException e) {
					System.out.println(e);
				}
		}
}
