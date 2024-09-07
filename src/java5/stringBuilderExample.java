package java5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class stringBuilderExample {

	public static void main(String[] args) throws IOException {
		
		//system.in is one of io stream, to read from keyboard
		InputStreamReader in =new InputStreamReader(System.in);
		FileReader fr = new FileReader("C:\\Users\\..\\Desktop\\xyz.txt");
		BufferedReader br = new BufferedReader(fr);
		String str;
		while((str= br.readLine()) != null) {
			System.out.println(str);
		}
		String [] letters= {"A","A","M"};

		//StringBuilder concat1= Arrays.stream(str).reduce(new StringBuilder(), (sb,s) -> sb.append(s), (sb1,sb2) -> sb1.append(sb2));
		StringBuilder concat = Arrays.stream(letters)
				.map(s -> new StringBuilder(s))
				.reduce(new StringBuilder(), (sb1, sb2) -> sb1.append(sb2));
		//....................OR........................................................
		StringBuilder concat1= Arrays.stream(letters)
				.map(b -> new StringBuilder().append(b))  //StringBuilder::new
				.reduce(new StringBuilder(), (sb,s) -> sb.append(s));//StringBuilder::append//StringBuilder::append
		System.out.println(concat1);
		
	}
}
