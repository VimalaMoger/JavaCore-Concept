package java5.concurrent.threads.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class RunnableCallable {

    public static String display(List<String> str) {
        String s = str.remove(0);
        return  s;
    }

    public static void main(String[] args) throws Exception {

        List<String> wordList = new ArrayList(Arrays.asList("One", "Two", "Three"));
        Runnable runnable = () -> { display(wordList);};
        runnable.run();

        System.out.println("\n");
        List<String> wordListNew = null;
        Callable<String> callable = () -> {return display(wordListNew);};

        String result ="";
        try {
            result = callable.call();
        }catch (Exception e){
            throw new Exception("The container is null");
        }finally {
            System.out.println(wordList);
        }
    }
}