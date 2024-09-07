package java8.collection.SearchAlgorithm;

public class BinarySearching {
	static long startTime;
	static long endTime;
	static int binarySearch(int arr[], int low, int high, int x) {
		while (low <= high) {
			int mid = low + (high - low) / 2;

			// Check if x is present at mid
			if (arr[mid] == x)
				return mid;

			// If x greater, ignore left half
			if (arr[mid] < x)
				low = mid + 1;

				// If x is smaller, ignore right half
			else
				high = mid - 1;
		}

		// If we reach here, then element was not present
		return -1;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		int x = 10;
		startTime = System.currentTimeMillis();
		int result = binarySearch(arr, 0, arr.length - 1, x);
		endTime = System.currentTimeMillis();
		System.out.println("Buble Sort Took " + (endTime - startTime));
		if (result == -1) System.out.println("Element is not present in array");
		else System.out.println("Element is present at index " + result);

	}
}
