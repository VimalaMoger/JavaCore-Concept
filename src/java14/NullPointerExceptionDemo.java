package java14;

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name.firstName);
    }
}

class Person{
    Name name;
}
class Name{
    String firstName;
}