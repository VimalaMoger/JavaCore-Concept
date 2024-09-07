
package java8.streamAPIExamples;

import model.BookClass;
import java.util.Arrays;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamOperators {

	public static void main(String[] args) {

		BookClass book1 = new BookClass("Effective Java-1", "Joshua Bloch", 2001,4.5, 67.0);
		BookClass book2 = new BookClass("Effective Java-2", "Joshua Bloch", 2009, 4.8, 120.0);
		BookClass book3 = new BookClass("Design patterns", "Eric Freeman", 2004, 4.3, 85.5);
		List<BookClass>  book =Arrays.asList(book1,book2,book3) ;     // using Arrays.asList()
		System.out.println(book);

		Map<Integer, BookClass> map = book.stream()
				.collect(Collectors.toMap(b -> b.getYear(), b -> b));
		System.out.println(map.keySet());

		Map<String, BookClass> mapNew = book.stream()
				.collect(Collectors.toMap(b -> b.getAuthor(), b -> b, (b4,b5) -> b4.getYear() <= b5.getYear() ? b4 : b5));

		for(Map.Entry<String, BookClass> entry : mapNew.entrySet()){
			System.out.println(entry.getKey() +" " + entry.getValue());
		}//returns hasmap

		Map<String, BookClass> treemap = book.stream()
				.collect(Collectors.toMap(BookClass::getAuthor, b -> b, (b4, b5) -> b4.getYear() <= b5.getYear() ? b4 : b5, () -> new TreeMap<>()));

		for(Map.Entry<String, BookClass> entry : treemap.entrySet()){
			System.out.println(entry.getKey() +" treemap values" + entry.getValue());
		}
		System.out.println(treemap instanceof TreeMap);

		Map<Integer, Object> arrList= treemap.values().stream()
			.collect(Collectors.toMap( BookClass::getYear, b-> Collections.singletonList(b),(l1, l2) -> {ArrayList<BookClass> l = new ArrayList<>();l.add((BookClass) l2);return l;}));

		for(Map.Entry<Integer, Object> entry : arrList.entrySet()){
			System.out.println(entry.getKey() +" published books " + entry.getValue());
			}

	  	Map<String,List<BookClass>> year = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor));
		for(Map.Entry<String, List<BookClass>> entry : year.entrySet()){
			System.out.println(entry.getKey() +" : Author lists : " + entry.getValue());
		} 

		//overloaded version of groupby
		Map<String,Set<BookClass>> byAuthor = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, toSet()));
		for(Map.Entry<String, Set<BookClass>> entry : byAuthor.entrySet()){
			System.out.println(entry.getKey() +" : author books(set): " + entry.getValue());
		}

		Map<String,Long> byAuthorCount = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, Collectors.counting()));
		System.out.println("\nbyAuthorCount " + byAuthorCount);
		System.out.println("\n" +map.values().stream().collect(Collectors.counting()));

		//average of ratings: groupedby author
		Map<String,Double> byRatingAvg = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, Collectors.averagingDouble(BookClass::getRating)));
		System.out.println("byRatingAvg" +byRatingAvg);

		//minimum rating of all books
		Map<String,Optional<BookClass>> byminRatingInGroup = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, Collectors.minBy(Comparator.comparingDouble(BookClass::getRating))));
		System.out.println("byminRatingInGroup" + byminRatingInGroup);

		Map<String, DoubleSummaryStatistics> summerizeByPriceInGroup = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, Collectors.summarizingDouble(BookClass::getPrice)));
		System.out.println("\nbyminRatingInGroup" + summerizeByPriceInGroup);

		//partitioningBy
		//group with title into list
		Map<String, List<String>> authorTitleMap =  map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor,Collectors.mapping(BookClass::getTitle, toList())));
		System.out.println("\n\nauthorTitleMap" +authorTitleMap);

		//multigroup
		Map<String, Map<Double, List<BookClass>>> multigroups = map.values().stream().collect(Collectors.groupingBy(BookClass::getAuthor, Collectors.groupingBy(BookClass::getRating,toList())));
		System.out.println("\nmultigroups" +multigroups );
	}
}

