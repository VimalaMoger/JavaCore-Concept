package model.sortBookData;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		int i = Integer.compare(o2.getYear(),o1.getYear());
		if(i != 0)
			return i;
		return ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
	}
}
