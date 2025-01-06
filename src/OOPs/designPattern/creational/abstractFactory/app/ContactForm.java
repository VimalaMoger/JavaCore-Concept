package OOPs.designPattern.creational.abstractFactory.app;
import OOPs.designPattern.creational.abstractFactory.WidgetFactory;

public class ContactForm {
    public void render(WidgetFactory widgetFactory) {
        widgetFactory.createTextBox().render();
        widgetFactory.createButton().render();
    }
}
