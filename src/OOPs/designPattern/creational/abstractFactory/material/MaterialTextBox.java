package OOPs.designPattern.creational.abstractFactory.material;

import OOPs.designPattern.creational.abstractFactory.TextBox;
import java13.TextBlocksDemo;

public class MaterialTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Material TextBox");
    }
}
