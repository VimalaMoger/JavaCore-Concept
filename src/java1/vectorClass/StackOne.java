package java1.vectorClass;

import java.util.Arrays;
//stack extends vector
public class StackOne {
	private String[] stackArray;
	private int size; // sizeof array
	private int topOfStack = -1;// empty

	StackOne(int size) {
		this.size = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}

	public void push(String input) {
		if (topOfStack + 1 < size) {
			topOfStack++;
			stackArray[topOfStack] = input;
			System.out.println(input + " item added!");
		} else {
			System.out.println("no enough room");
			displayTheStack();
		}
	}

	public String pop() {
		if (topOfStack >= 0) {
			displayTheStack();
			System.out.println(stackArray[topOfStack] + " was removed!");
			stackArray[topOfStack] = "-1";
			return stackArray[topOfStack--];
		} else
			displayTheStack();
		System.out.println("sorry empty");
		return "-1";
	}

	public String peek() {
		displayTheStack();
		System.out.println(stackArray[topOfStack] + " top item");
		return stackArray[topOfStack];
	}

	private void displayTheStack() {
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
		if (stackArray[n].equals("-1"))
			System.out.print("|     ");
		else
			System.out.print(String.format("| %2s " + " ", stackArray[n]));
		}
		System.out.println("|");
		for (int n = 0; n < 61; n++)
			System.out.print("-");
		System.out.println();
	}
	public void pushmanyItems(String datas) {
		String[] temp = datas.split(" ");
		for(int i=0;i<temp.length;i++) {
			push(temp[i]);
		}
	}

	public static void main(String[] args) {
		StackOne one = new StackOne(10);
		one.push("10");
		one.push("300");
		one.push("200");
		one.peek();
		one.pop();
		one.pushmanyItems("12 34 56 78 89");
		one.displayTheStack();
		one.pop();
	}
}
