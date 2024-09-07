package java8.collection.SortingAlgorithm;

import java.util.Arrays;

public class BubbleSort {
	private int[] theArray;
	static long startTime;
	static long endTime;
	private int arraySize;

	BubbleSort(int size) {
		arraySize = size;
		theArray = new int[size];
	}
	public void bubbleSort() {

		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {

				if (theArray[j] > theArray[j + 1]) {

					swapValues(j, j + 1);
				}
			}
		}
		Arrays.stream(theArray).forEach(System.out::println);
	}

	private void swapValues(int j, int i) {
		int temp= theArray[j];
		theArray[j]= theArray[i];
		theArray[i]=temp;
	}

	public static void main(String[] args) {
		BubbleSort search = new BubbleSort(10);
		search.generateRandomArray();
		startTime = System.currentTimeMillis();
		search.bubbleSort();
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took " + (endTime - startTime));
	}

	void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 1000) + 10;
		}
	}
}
