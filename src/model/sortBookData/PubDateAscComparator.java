package model.sortBookData;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {int i = Integer.compare(((Book)o1).getYear(),((Book)o2).getYear());
		if(i != 0)
			return i;
		return ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
	}
}


