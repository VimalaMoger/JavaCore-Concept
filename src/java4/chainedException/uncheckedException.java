package java4.chainedException;

import java.util.ArrayList;
import java.util.List;

public class uncheckedException {
	 static int setAge(int age) {
	    if (age < 1 || age > 99) {
	        throw new IllegalArgumentException("Invalid age");
	    }
	  return age;
	}

	public static void main(String[] args) {
		//caller calling setAge method
		List<Integer> list = new ArrayList<>();
		list.add(setAge(0));
		System.out.println(list);

	}

}
