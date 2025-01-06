package OOPs.designPattern.creational.abstractFactory.ant;

import OOPs.designPattern.creational.abstractFactory.Button;
import OOPs.designPattern.creational.abstractFactory.TextBox;
import OOPs.designPattern.creational.abstractFactory.WidgetFactory;

public class AntWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextBox();
    }
}
