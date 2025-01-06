package OOPs.designPattern.creational.abstractFactory.material;

import OOPs.designPattern.creational.abstractFactory.Button;

public class MaterialButton implements Button {
    @Override
    public void render() {
        System.out.println("Material Button");
    }
}
