package java5.generics;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
        List<? super Object> num= new ArrayList<>();
        num.add(6);
        num.add(4.5);
        num.add("y");
        System.out.println(num);

        List<? extends  Number> list2= new ArrayList<>();
        list2.get(0);
    }

}
