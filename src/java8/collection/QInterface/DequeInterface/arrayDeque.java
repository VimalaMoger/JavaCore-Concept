package java8.collection.QInterface.DequeInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class arrayDeque {

	public static void main(String[] args) {
		Deque<String> arrayDeque = new ArrayDeque<>(17);
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
