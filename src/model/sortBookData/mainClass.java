package model.sortBookData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mainClass {
    public static void main(String[] args) {
        Book book1 = new Book("Effective Java-1", "Jashua", 2001);
        Book book2 = new Book("Effective Java-2", "Jashua", 2009);
        Book book3 = new Book("Design patterns", "Eric Freeman", 2004);
        List<Book> book = Arrays.asList(book1,book2,book3) ;     // using Arrays.asList()
        System.out.println(book);
        Collections.sort(book, Book.TITLE_COMPARATOR);
        System.out.println(book);

        Book newBook = new Book();
        //descending order : year then title
        Collections.sort(book, newBook.new PubDateCompartors().new PubDateDescComparator());
        System.out.println(book);

        //ascending order : year them title
        Collections.sort(book, newBook.new PubDateCompartors().new PubDateAscComparator());
        System.out.println(book);
    }
}
