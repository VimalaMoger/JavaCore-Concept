package OOPs.designPattern.structural.composite;
/**
Created Group(Composite) class contains a storage structure to store Shape objects,
 and implements Component Interface and overrides inherited methods to iterate over the list of
 shape objects to render and draw
 */
public class Main {
    public static void main(String[] args) {
        var group = new Group();
        group.addComponent(new Shape());
        group.addComponent(new Square());
        group.render();
        group.draw();
    }
}
