package java10;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class varDemo {
    public static void main(String[] args) {

        //using var identifier
        var wordList = List.of("one", "two", "three");
        BiFunction<Integer, Integer, Integer>  biFunction = ( var a, var b) -> a + b;
        System.out.println("Bi function returns "+ biFunction.apply(2, 3));
    }
}
