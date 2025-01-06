package OOPs.designPattern.structural.flyweight;

/**
 * PointIcon acts as Flyweight, instead of calling point multiple times into memory, using
 * PointIconFactory that allows sharing the common state between multiple objects
 */
public class Main {
    public static void main(String[] args) {
        var service = new PointService(new PointIconFactory());
        for(var point : service.getPoints()){
            point.draw();
        }

    }
}
