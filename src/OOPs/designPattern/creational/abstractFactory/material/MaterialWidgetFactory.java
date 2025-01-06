package OOPs.designPattern.creational.abstractFactory.material;

import OOPs.designPattern.creational.abstractFactory.Button;
import OOPs.designPattern.creational.abstractFactory.TextBox;
import OOPs.designPattern.creational.abstractFactory.WidgetFactory;

public class MaterialWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextBox();
    }
}
