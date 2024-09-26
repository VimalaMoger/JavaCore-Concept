package java11;

import java.util.stream.IntStream;

public class VarInLambdaExample {
    public static void main(String[] args) {
        IntStream.of(1, 2, 3, 5, 6, 7)
                .filter((var i) -> i % 3 == 0)
                .forEach(System.out::println);
    }
}
