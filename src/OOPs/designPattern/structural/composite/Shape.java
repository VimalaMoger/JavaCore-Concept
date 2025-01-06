package OOPs.designPattern.structural.composite;

public class Shape implements Component{

    @Override
    public void render() {
        System.out.println("Render Shape");
    }

    @Override
    public void draw() {
        System.out.println("Move Shape");
    }
}
