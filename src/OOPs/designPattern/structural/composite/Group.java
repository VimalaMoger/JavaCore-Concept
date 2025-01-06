package OOPs.designPattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component {
    List<Component> shapes = new ArrayList<>();

    public void addComponent(Component newShape){
        shapes.add(newShape);
    }

    @Override
    public void render() {
        for(var obj : shapes){
            obj.render();
        }
    }

    @Override
    public void draw() {
        for(var obj : shapes){
            obj.draw();
        }
    }
}
