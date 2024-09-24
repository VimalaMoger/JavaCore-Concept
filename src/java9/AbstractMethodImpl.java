package java9;

public class AbstractMethodImpl implements PrivateMethodImpl {
        @Override
        public void abstractMethodExample() {
            System.out.println
                    ("Inside the implementation of an abstract method");
        }
        public static void main(String[] args) {
            PrivateMethodImpl test = new AbstractMethodImpl();
            test.defaultMethodExample();
            test.abstractMethodExample();
        }
}

