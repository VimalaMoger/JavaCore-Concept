package java5.annotations;

public class BuiltInAnnotations {

    private String sayToSomeone= "Hello ";

    @Deprecated
    public void display(){
        System.out.println("say " + sayToSomeone);
    }
    public static void main(String[] args) {

        BuiltInAnnotations annotations = new Hello();  //Base class reference and child object
        annotations.display();   //runs the method in child class

    }

}
class Hello extends BuiltInAnnotations{

    @SuppressWarnings({"deprecation"})
    public void go(){
        display();
    }

    @SuppressWarnings({"deprecation"})
    @Override
    public void display() {
        System.out.println(" Overridden method from base class");
    }
}
