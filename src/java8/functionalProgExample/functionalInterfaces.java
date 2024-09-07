package java8.functionalProgExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import sortBookData.Book;

public class functionalInterfaces {

	public static void main(String[] args) {
		//Predicate interface
		Predicate<String> predicateFunc = t-> t.length() > 5;
		System.out.println(predicateFunc.test("Praveen"));
		
		List<String> list= new ArrayList<>();
		list.add("Gyan");
		list.add("Rochit");
		list.add("Aveen");
		List<String> filtered =list.stream().filter(t -> t.length()>5).collect(Collectors.<String>toList());
		System.out.println(filtered);

		//Function interface
		Function<String,String> func = String::trim;
		System.out.println(func.apply("             Aveen"));
		
		//Consumer interface
		Book book= new Book("Java", "",2000);
		Consumer<Book> updateBook = p-> p.setTitle("Kiten");
		updateBook.accept(book);
		System.out.println(book.getTitle());
		
		//supplier
		Supplier<Integer> sup = () -> 20;
		System.out.println(sup.get());
	}
}
