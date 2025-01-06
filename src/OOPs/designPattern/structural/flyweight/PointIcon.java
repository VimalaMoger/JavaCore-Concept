package OOPs.designPattern.structural.flyweight;

public class PointIcon {
    private byte[] icon;
    private final PointType type;

    public PointIcon(byte[] icon, PointType type) {
        this.icon = icon;
        this.type = type;
    }

    public PointType getType() {
        return type;
    }
}
