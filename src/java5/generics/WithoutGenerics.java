package java5.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class withoutGenerics {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String s=(String) it.next();  //explicit cast required
		}
		

	}

}
