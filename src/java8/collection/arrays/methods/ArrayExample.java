package java8.collection.arrays.methods;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		int array[] = new int[10];
		for(int i=0;i<10;i++) {
			array[i] =-3 *i;
		}
		
		System.out.print("original contents ");
		display(array);
		Arrays.sort(array);
		System.out.print("\nsorted 	");
		display(array);
		Arrays.fill(array, 2,6,-1);
		System.out.print("\nafter filled ");
		display(array);
		System.out.print("\nsorted ");
		Arrays.sort(array);
		display(array);
		//binary search for 9
		System.out.println("\nbinarySearch for 9 " +Arrays.binarySearch(array, -9));
	}

	private static void display(int[] array) {
		for(int i: array) {
			System.out.print(i+" ");
		}
		
	}

}
