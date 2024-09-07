package java8.collection.SearchAlgorithm;

public class LinearSearching {
	private int[] theArray;
	static long startTime;
	static long endTime;
	private int arraySize;
	boolean valueInArray = false;
	LinearSearching(int size){
		arraySize = size;
		theArray = new int[size];
	}
	
	public void linearSearchForValue(int value) {
		String indexsWithValue = "";
		startTime = System.currentTimeMillis();
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == value) {
				valueInArray = true;
				indexsWithValue += i + " ";
			}
		}

		System.out.println("Value Found: " + valueInArray);

		endTime = System.currentTimeMillis();

		System.out.println("Linear Search Took " + (endTime - startTime));
	}

	public static void main(String[] args) {
		LinearSearching search = new LinearSearching(50);
		search.generateRandomArray();
		search.linearSearchForValue(20);
		LinearSearching search2 = new LinearSearching(20);
		search2.generateRandomArray();
		search2.linearSearchForValue(50);
	}

	private void generateRandomArray() {
		  for (int i = 0; i < arraySize; i++) {
		  theArray[i] = (int) (Math.random() * 100) + 10;
			  System.out.println(theArray[i]);
		}
	}
}
