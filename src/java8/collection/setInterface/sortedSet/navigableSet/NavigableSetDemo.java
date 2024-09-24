package java8.collection.setInterface.sortedSet.navigableSet;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetDemo {

	public static void main(String[] args) {
	
		Set set= new TreeSet(Arrays.asList(1,2,4,5));
		set.add(4);
		System.out.println(set.contains(4));
		Integer l =(Integer) ((TreeSet) set).ceiling(4);
		
		System.out.println(l);
		
		System.out.println(((TreeSet) set).floor(3));
		
	}

}
