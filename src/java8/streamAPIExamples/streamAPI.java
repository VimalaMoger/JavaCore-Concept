
package java8.streamAPIExamples;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class streamAPI {
    public static void main(String[] args) {
        /**
         * Creating a list of integers using Arrays.asList() method, initializing with integer numbers
         * Call the stream() method on the list, to create list of its elements
         * then, call the map() method on the stream, pass lambda expression as an argument, lambda expression takes
         * each element in the stream and add 5 to it. finally call the forEach() method on the resulting stream, passing
         * in a method reference
         * */
        List<Integer> listInts = Arrays.asList(2, 5, 7, 9, 10, 11);
        listInts.stream().map(x -> x+5).forEach(System.out::println);

        /** flatMap method flattens a list of lists into a single stream.*/

        List<Integer> Number1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> Number2 = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfInts = Arrays.asList(Number1, Number2);
        System.out.println("Before: " + listOfInts);
        List<Integer> ListOfInts = listOfInts.stream().flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("After: "+ ListOfInts);

        //using stream.filter(), sorted()
        int [] arr =  {20, 14, 2, 3, 5, 6, 8, 9};
        List<Integer> ints = Arrays.stream(arr).filter(x -> x % 2==0).boxed().sorted().collect(Collectors.toList());
        System.out.println(ints);

        //Getting min, max, count the elements
        Integer maxNum = Arrays.stream(arr).boxed().max(Comparator.comparing(Integer::valueOf)).get();
        Integer minNum = Arrays.stream(arr).boxed().min(Comparator.comparing(Integer::valueOf)).get();
        long count = Arrays.stream(arr).count();
        System.out.printf("maxNum %d\nminNum %d\ncount %d\n", maxNum, minNum, count);
        //System.out.println(maxNum+"  "+minNum);
        //array stream
        int [] array = {5,6,7,3,2,5,9};
        OptionalInt i = Arrays.stream(array).max();
        System.out.println(i);
        OptionalInt ii=Arrays.stream(array).reduce(Integer::max);
        System.out.println(ii);
        //terminal operations:reduce,collect

        Integer[] arr2 = {5,6,7,3,2,5,9};
        //treemap- natural order
        TreeSet<Integer> list=Arrays.stream(arr2).collect(Collectors.toCollection(() -> new TreeSet<Integer>()));  //toSet//toList
        System.out.println("TreeSet elements " +list);

        ArrayList list2 = Arrays.stream(arr2).collect(() -> new ArrayList(),(a,t) -> a.add(t), (a1,a2) -> a1.addAll(a2));  //import static java.util.stream.Collectors.*;
        System.out.println(list2);
        //or
        ArrayList list3=Arrays.stream(arr2).collect(ArrayList::new,ArrayList::add, ArrayList::addAll);
        System.out.println(list3);
    }
}

