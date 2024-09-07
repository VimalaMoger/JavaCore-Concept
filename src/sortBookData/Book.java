package sortBookData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
		private String title;
		private String author;
		private int year;

		@Override
		public String toString() {
			return "entities.Book [title=" + title + ", author=" + author + ", year=" + year + "]";
		}	

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
			Book other = (Book) obj;
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

		public static final Comparator<Book> TITLE_COMPARATOR = new Comparator<Book>(){
			@Override
			public int compare(Book o1,Book o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		    
		};

		public class PubDateCompartors{
			public  class PubDateAscComparator implements Comparator<Book> {
				@Override
				public int compare(Book o1, Book o2) {
					int i = Integer.compare(((Book) o1).getYear(), ((Book) o2).getYear());
					if (i != 0)
						return i;
					return ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
				}
			}

			public class PubDateDescComparator implements Comparator<Book> {

				@Override
				public int compare(Book o1, Book o2) {
					int i = Integer.compare(o2.getYear(),o1.getYear());
					if(i != 0)
						return i;
					return ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
				}
			}
		}
		
}




