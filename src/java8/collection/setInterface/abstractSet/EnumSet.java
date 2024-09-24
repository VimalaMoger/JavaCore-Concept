package java8.collection.setInterface.abstractSet;

import java.util.ArrayList;

public class EnumSet {

	public static void main(String[] args) {
		java.util.EnumSet set1= java.util.EnumSet.allOf(Color.class);
		
		System.out.println(java.util.EnumSet.range(Color.BLUE, Color.VOILET));
		ArrayList<Color> list = new ArrayList<>();
		list.add(Color.BLUE);
		list.add(Color.GREEN);
		java.util.EnumSet<Color> enumcopy= java.util.EnumSet.copyOf(list);
		enumcopy.contains(Color.RED);
		list.forEach(System.out::println);
		System.out.println(list.remove(Color.BLUE));
		
		
		//desplay all elements
		System.out.println("set1 "+set1);
	
		java.util.EnumSet set2 = java.util.EnumSet.complementOf(set1);
		System.out.println(set2);
		
		
	}

}

enum Color {
	RED, GREEN, BLUE, YELLOW, VOILET, ORANGE
}