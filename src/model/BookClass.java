package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookClass {
		private String title;
		private String author;
		private int year;
		private double rating;
		private double price;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + year;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BookClass other = (BookClass) obj;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (year != other.year)
				return false;
			return true;
		}
		// strategy

		public static final Comparator<BookClass> TITLE_COMPARATOR = new Comparator<BookClass>(){
			@Override
			public int compare(BookClass o1, BookClass o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		    
		};
		public static class PubDateCompartors{
			public static class PubDateAscOrderComparator implements Comparator<BookClass> {

				@Override
				public int compare(BookClass o1, BookClass o2) {
					int i = Integer.compare(((BookClass)o1).getYear(),((BookClass)o2).getYear());
					if(i != 0)
						return i;
					return ((BookClass)o1).getTitle().compareTo(((BookClass)o2).getTitle());
				}
			}

			public class PubDateDescOrderComparator implements Comparator<BookClass> {

				@Override
				public int compare(BookClass o1, BookClass o2) {
					int i = Integer.compare(o2.getYear(),o1.getYear());
					if(i != 0)
						return i;
					
					return ((BookClass)o1).getTitle().compareTo(((BookClass)o2).getTitle());
				}
			}
		}
	}




