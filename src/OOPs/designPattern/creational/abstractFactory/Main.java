package OOPs.designPattern.creational.abstractFactory;

import OOPs.designPattern.creational.abstractFactory.ant.AntWidgetFactory;
import OOPs.designPattern.creational.abstractFactory.app.ContactForm;
import OOPs.designPattern.creational.abstractFactory.material.MaterialWidgetFactory;

/** AbstractFactory provides an abstraction for creating families of related objects
 *  AbstractFactory package consists of two widget categories, ant and material
 * and in ContactForm class: widget category is selected and rendered
 */
public class Main {
    public static void main(String[] args) {
        new ContactForm().render(new MaterialWidgetFactory());
        new ContactForm().render(new AntWidgetFactory());
    }
}
