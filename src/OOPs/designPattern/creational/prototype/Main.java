package OOPs.designPattern.creational.prototype;

/**
 * ContextMenu class communicates only to Component interface, we can extend our application by
 * introducing new classes like Circle that implements Component
 * Used Open-Closed principle
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(12);
        var menu = new ContextMenu();
        Component component = menu.duplicate(circle);
        component.render();
    }
}
