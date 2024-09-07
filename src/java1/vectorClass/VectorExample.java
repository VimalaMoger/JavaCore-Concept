package java1.vectorClass;

import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>(2);
		v.add("x");
		v.add("y");
		v.addElement("z");
		System.out.println(v);
		System.out.println(v.elementAt(1));
		
		System.out.println(v.capacity());
		v.removeAllElements();
		System.out.println(v);
	}
}
