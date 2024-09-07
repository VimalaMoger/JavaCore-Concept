package java8.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//List: loop,search takes time
//index search much faster
//duplicates allowed
//not in order, use comparator to sort, or collection factory method

public class ListSort {

	public static void main(String[] args) {
		List<letter> list1 = Arrays.asList(new letter("a"), new letter("c"), new letter("b"));

		System.out.println(list1);
		long start = System.currentTimeMillis();
		Collections.sort(list1, new letter(null));
		long end = System.currentTimeMillis();

		System.out.println("it takes " +
				(end - start) + "ms");
		System.out.println(list1);
	}
}

class letter  implements Comparator<letter>{
	String word;
	public letter(String s) {
		this.word=s;
	}
	@Override
	public int compare(letter o1, letter o2) {
		return  o2.word.compareTo(o1.word);
	}
	@Override
	public String toString() {
		return "letter [word=" + word + "]";
	}
	
	
}
