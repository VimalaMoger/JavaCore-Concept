package java8.collection.setInterface.sortedSet.navigableSet;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>(new myComp());
		set.add("Shre");
		set.add("Shreesh");
		set.add("Shreesha");
		System.out.println(set);
	}
}

class myComp implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}