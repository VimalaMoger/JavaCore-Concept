package problemsActivities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class RotationArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lengthAndRotation= br.readLine();
		String [] s= lengthAndRotation.split(" ");
		int length = Integer.valueOf(s[0]);
		int rotation = Integer.valueOf(s[1]);
		System.out.println(length +" " + rotation);
		
		String query = br.readLine();
	
		String[] array = query.split(" ");
	
		int[] arrayInt =Stream.of(array)
                .mapToInt(Integer::parseInt).toArray();
	
		int index  = 0, temp = 0;

		//int n = arrayInt.length;
		int[] arrSavedElements = new int[length];
		int[] tmp = new int[length];

		tmp = Arrays.copyOf(arrayInt, length);
		for (int i = 0; i < arrayInt.length-rotation; i++) {
			if (i < rotation) {
				temp= arrayInt[i];
				arrayInt[i] = tmp[length - 1];

				System.out.println("arrayInt last values " +tmp[length-1]); //debug
				System.out.println("arrayInt values " +arrayInt[i]);
				
				arrSavedElements[i] = arrayInt[i+rotation];
				
				System.out.println("saved "+arrSavedElements[i]);
				arrayInt[i + rotation] = temp;
			
				System.out.println("after two rotation "+arrayInt[i+rotation]);
				length--;
			}else {
				arrSavedElements[i]=arrayInt[i + rotation];
				System.out.println("increment "+ arrSavedElements[index]);
				arrayInt[i+rotation]=arrSavedElements[index];
				index++;
			}
		}
		for(Integer ii : arrSavedElements) {
			System.out.print(" " +ii);
		}

		for(Integer ii : arrayInt) {
			System.out.print(" " +ii);
		}
	}
}
