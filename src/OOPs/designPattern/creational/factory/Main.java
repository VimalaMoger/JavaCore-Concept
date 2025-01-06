package OOPs.designPattern.creational.factory;

/** Defer the creation of an object to subclasses
* Used Inheritance and Polymorphism
* Created classes of different view types, ProductController extends the type of view and renders
*/
public class Main {
    public static void main(String[] args) {
        new ProductController().listProducts();
    }
}
