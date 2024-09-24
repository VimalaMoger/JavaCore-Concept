package java9;

public interface PrivateMethodImpl {

    public abstract void abstractMethodExample();

    public
    default void defaultMethodExample() {
        privateMethodExample();
        privateStaticMethodExample();
        System.out.println("Inside a default method");
    }

    private void privateMethodExample() {
        System.out.println("Inside a private non-static method");
    }

    private static void privateStaticMethodExample() {
        System.out.println("Inside a private static method");
    }

}



