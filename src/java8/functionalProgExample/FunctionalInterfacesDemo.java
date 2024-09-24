package java8.functionalProgExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        //supplier<T>  takes no argument returns one type, uses single abstract get method
        List<String> wordList= new ArrayList(Arrays.asList("word1", "word2", "word3"));

        System.out.println(wordList);
        Supplier<List<String>> supplier = () -> {return  wordList;};
        List<String> l= supplier.get();
        System.out.println(l);

        Supplier<List<String>> supplier2 = () -> {return  wordList.subList(1,2);};
        List<String> l2= supplier2.get();
        System.out.println(l2);

        Supplier<Integer> supplier3 = () -> {return  wordList.indexOf("word2");};
        int l3= supplier3.get().compareTo(wordList.indexOf("word3"));
        System.out.println(l3);
        System.out.println(wordList);


    }
}
