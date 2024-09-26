package java11;

import java.lang.reflect.Field;

public class NestedTestClass {
    private static int x = 5;

    public static class NestedTest {
        public static void doSomething() throws Exception {
            Field x = NestedTestClass.class.getDeclaredField("x");
            //x.setAccessible(true);   //java 11 onwards
            x.setInt(null, 10);
        }
    }

    public static void main(String[] args) throws Exception {
        NestedTest.doSomething();
        System.out.println(NestedTestClass.x);
    }
}