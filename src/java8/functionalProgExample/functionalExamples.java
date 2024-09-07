package java8.functionalProgExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class functionalExamples {
    public static void display(List<Integer> e, List<Integer> num) {
        e.addAll(num);
        System.out.println(e);
    }

    public static void main(String[] args) {
        //consumer<T>  takes argument returns void, uses single abstract accept method

        List<String> wordList = new ArrayList(Arrays.asList("word1", "word2", "word3"));
        Consumer<String> consumer = (String s) -> {
            wordList.add(s);
        };
        consumer.accept("word4");
        System.out.println(wordList);

        List<Integer> e = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> num = new ArrayList<>(Arrays.asList(4, 5, 6));
        Consumer<List<Integer>> consumer2 = (List<Integer> f) -> {display(f,e);};
        consumer2.accept(num);

        //supplier
        Supplier<String> supplier =() -> wordList.remove(0);
        String res = supplier.get();
        System.out.println("returned value "+res);

        //Function- accepts one argument of one type, returns another type
        Function<String,Boolean> func = (s) -> wordList.contains(s);
        System.out.println(" function returns "+ func.apply("word2"));

    }
}
