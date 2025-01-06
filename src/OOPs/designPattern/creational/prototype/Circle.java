package OOPs.designPattern.creational.prototype;

public class Circle implements Component{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void render() {
        System.out.println("Rendering a circle ");
    }

    @Override
    public Component clone() {
        Circle  newCircle = new Circle();
        Circle target = new Circle();
        target.setRadius(radius);
        return target;
    }
}
