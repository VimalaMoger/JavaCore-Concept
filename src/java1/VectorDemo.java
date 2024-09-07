package java1;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		Vector<String> list =  new Vector();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
