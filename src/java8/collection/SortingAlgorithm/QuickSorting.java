package java8.collection.SortingAlgorithm;

import java.util.Arrays;

public class QuickSorting {
	static long startTime;
	static long endTime;

	public static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partitionArray(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	public static int partitionArray(int[] arr, int low, int high)
	{
		// Choosing the pivot
		int pivot = arr[high];

		// Index of smaller element and indicates
		// the right position of pivot found so far
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller than the pivot
			if (arr[j] < pivot) {

				// Increment index of smaller element
				i++;
				swapValues(arr,i, j);
			}
		}
		swapValues(arr, i + 1, high);
		return (i + 1);
	}

	private static void swapValues(int []arr,int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// To print sorted array
	void display(int [] arr){
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) {
		QuickSorting search =new QuickSorting();
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int N = arr.length;
		startTime = System.currentTimeMillis();
		// Function call
		quickSort(arr,0, N - 1);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort Took " + (endTime - startTime));
		System.out.println("Sorted array:");
		search.display(arr);


	}

}
