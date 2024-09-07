package java9;

public class abstractMethodImpl implements privateMethodImpl {
        @Override
        public void abstractMethodExample() {
            System.out.println
                    ("Inside the implementation of an abstract method");
        }
        public static void main(String[] args) {
            privateMethodImpl test = new abstractMethodImpl();
            test.defaultMethodExample();
            test.abstractMethodExample();
        }
}

