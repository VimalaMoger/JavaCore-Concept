package java2;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class ClassAbstract {
    public static void main(String[] args) {
        // Create an empty collection
        AbstractCollection<Object> abs = new ArrayList<>();
        abs.add("Arrays");
        abs.add("Strings");
        System.out.println("AbstractCollection: "
                + abs);
    }
}
