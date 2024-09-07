package java8.collection.setInterface.abstractSet;

import java.util.ArrayList;
import java.util.EnumSet;

public class enumSet {

	public static void main(String[] args) {
		EnumSet set1= EnumSet.allOf(Color.class);
		
		System.out.println(EnumSet.range(Color.BLUE, Color.VOILET));
		ArrayList<Color> list = new ArrayList<>();
		list.add(Color.BLUE);
		list.add(Color.GREEN);
		EnumSet<Color> enumcopy= EnumSet.copyOf(list);
		enumcopy.contains(Color.RED);
		list.forEach(System.out::println);
		System.out.println(list.remove(Color.BLUE));
		
		
		//desplay all elements
		System.out.println("set1 "+set1);
	
		EnumSet set2 = EnumSet.complementOf(set1);
		System.out.println(set2);
		
		
	}

}

enum Color {
	RED, GREEN, BLUE, YELLOW, VOILET, ORANGE
}