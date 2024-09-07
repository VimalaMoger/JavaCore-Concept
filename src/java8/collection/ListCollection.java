package java8.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListCollection {

	public static void main(String[] args) {
		ArrayList<String> list= new ArrayList();
		list.add("book");
		list.add("flower");
		list.add("book");
		list.add("flower");
		list.add("book");
		list.add("flower");
	
		//iterator
		Iterator iterator= list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
