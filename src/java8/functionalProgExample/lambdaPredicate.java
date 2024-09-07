package java8.functionalProgExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambdaPredicate {

    public static void main(String[] args) {
        //Predicate<T>  takes argument returns boolean, uses single abstract test method

        List<String> wordList= new ArrayList(Arrays.asList("word1", "word2", "word3"));
        //returns boolean use only test method
        Predicate<List<String>> predicate1= (List<String> list) -> list.isEmpty();
        Predicate<List<String>> predicate2= (List<String> list) -> list.add("word4");
        Predicate<List<String>> predicate3= (List<String> list) -> list.remove("word1");
        boolean b = predicate1.test(wordList);
        System.out.println(b);
        boolean c = predicate2.test(wordList);
        System.out.println(c);
       // System.out.println(wordList);
        boolean d = predicate3.test(wordList);
        System.out.println(d);
        System.out.println(wordList);
    }
}
