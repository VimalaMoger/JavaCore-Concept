package java5.threads.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class runnableCallable {

    public static String display(List<String> e) {
        String s =e.remove(0);
        //System.out.println(s);
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
            throw new Exception("The contailner is null");
        }finally {
            System.out.println(wordList);
        }
    }
}