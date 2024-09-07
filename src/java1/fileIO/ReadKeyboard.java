package java1.fileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadKeyboard {
	public static void main(String [] args) {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(ir);
		String str="";
		try {
			while(str != "stop") {
				str=  r.readLine();
				System.out.println(str);
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
