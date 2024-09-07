package java8.collection.QInterface;

import java.util.Arrays;

public class QueueExample {
	private String[] queueArray;
	private int size;
	private int front,rear, numberOfItems=0;
	QueueExample(int size){
		this.size=size;
		queueArray =new String[size];
		Arrays.fill(queueArray, "-1");
	}
	public void insert(String s) {
		if(numberOfItems+1 <= size) {
			queueArray[rear] =s;
			rear++;
			numberOfItems++;
			System.out.println(s +" item added");
		}else {
			System.out.println("no enough room");
		}
	}

	public void remove() {
		if (numberOfItems >0) {
			System.out.println(queueArray[front] + " was removed!");
			queueArray[front] = "-1";
			front++;
			numberOfItems--;
		} else
			System.out.println("sorry empty");
		}
		public void peek() {
			System.out.println("the first element is " + queueArray[front]);
		}
		private void displayTheQueue() {
			for (int n = 0; n < 61; n++)
			System.out.print("-");
			System.out.println();
			for (int n = 0; n < size; n++) {
				System.out.format("| %2s " + " ", n);
				}
			System.out.println("|");
			for (int n = 0; n < 61; n++)
			System.out.print("-");
			System.out.println();
			for (int n = 0; n < size; n++) {
			if (queueArray[n].equals("-1"))
				System.out.print("|     ");
			else
				System.out.print(String.format("| %2s " + " ", queueArray[n]));
			}
			System.out.println("|");
			for (int n = 0; n < 61; n++)
				System.out.print("-");
			System.out.println();
}
		//priorityQueue
		public void priorityInsert(String input) {
			// This priority insert will add items in order from high to low
			int i;
			if (numberOfItems == 0) {
				insert(input);
			} else {
				for (i = numberOfItems - 1; i >= 0; i--) {
					if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
						queueArray[i + 1] = queueArray[i];
					} else
						break; // Done shifting items in queue
				}
				queueArray[i + 1] = input;
				rear++;
				numberOfItems++;
			}
		}
		
	public static void main(String[] args) {
		
		QueueExample one = new QueueExample(10);
		one.insert("10");
		one.insert("30");
		one.insert("70");
		one.displayTheQueue();
		one.remove();
		one.peek();
		one.priorityInsert("10");
		one.priorityInsert("670");
		one.priorityInsert("80");
		one.insert("70");
		
		
	}

}
