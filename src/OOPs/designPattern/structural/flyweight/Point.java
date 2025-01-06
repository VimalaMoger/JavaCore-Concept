package OOPs.designPattern.structural.flyweight;

public class Point {
    private int x;
    private int y;
    private PointIcon icon;

    public Point(int y, int x, PointIcon icon) {
        this.y = y;
        this.x = x;
        this.icon = icon;
    }

    public void draw(){
        System.out.printf("%s at (%d, %d)",icon.getType(), x, y);
    }
}
