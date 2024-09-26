package java11.java.lang;

import java.lang.reflect.Field;
import java.util.Arrays;

public class OuterClass {
    private static int x = 5;

    public static class NestedTest {
        public static void doSomething() throws Exception {
            Field x = java11.NestedTestClass.class.getDeclaredField("x");
            //x.setAccessible(true);   //java 11 onwards
            x.setInt(null, 10);
        }
    }

    public static void main(String[] args) {
        findNests(OuterClass.class);
        findNests(NestedTest.class);
        testNestMates(NestedTest.class, OuterClass.class);
        testNestMates(OuterClass.class, NestedTest.class);
        testNestMates(OuterClass.class, OuterClass.class);
    }

    private static void findNests(Class<?> aClass) {
        System.out.printf("\n-- finding Nests for class=%s --%n", aClass.getSimpleName());
        System.out.println("\nnested members:");
        Class<?>[] nestMembers = aClass.getNestMembers();
        Arrays.stream(nestMembers)
                .map(Class::getSimpleName)
                .forEach(System.out::println);

        System.out.println("\nnested host:");
        Class<?> nestHost = aClass.getNestHost();
        System.out.println(nestHost.getSimpleName());
    }

    private static void testNestMates(Class<?> nestedTestClass, Class<?> outerClassClass) {

        boolean b = nestedTestClass.isNestmateOf(outerClassClass);
        System.out.printf("\n%s isNestmateOf %s = %s%n", nestedTestClass.getSimpleName(), outerClassClass.getSimpleName(), b);
    }
}



