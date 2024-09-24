package java8.collection.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListExample {
        public static void main(String[] args) {
            LinkedList<Integer> list= new LinkedList<>();
            list.add(-8);
            list.add(20);
            list.add(-20);
            list.add(8);

            //user reverse order comparator
            Comparator<Integer> comp = Collections.reverseOrder();
            Collections.sort(list,comp);
            System.out.println(list);
            Collections.rotate(list, 1);
            System.out.println("right "+ list);
            Collections.rotate(list, -1);
            System.out.println("left "+ list);
            Collections.shuffle(list);
            System.out.println(list);

            System.out.println(Collections.min(list));
            System.out.println(Collections.max(list));
            System.out.println(Collections.binarySearch(list, 22));

            System.out.println(Collections.binarySearch(list, -20, new MyComp()));
            Collections.sort(list, new MyComp());
            System.out.println(list);
        }
    }
    class MyComp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {

            return o2.compareTo(o1);
        }
    }

