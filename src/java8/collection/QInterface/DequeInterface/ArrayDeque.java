package java8.collection.QInterface.DequeInterface;

import java.util.Deque;

public class ArrayDeque {

	public static void main(String[] args) {
		Deque<String> arrayDeque = new java.util.ArrayDeque<>(17);
		arrayDeque.push("A");
		arrayDeque.offer("B");
		arrayDeque.offer("C");
		arrayDeque.offer("D");
		arrayDeque.push("E");
		System.out.println(arrayDeque);
		while(!arrayDeque.isEmpty()) {
			System.out.println(arrayDeque.removeLast());
		}
	}
}
