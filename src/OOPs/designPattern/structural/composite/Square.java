package OOPs.designPattern.structural.composite;

public class Square extends Shape{

    @Override
    public void render() {
        System.out.println("Square Shape");
    }
    @Override
    public void draw() {
        System.out.println("Draw a square");
    }
}
