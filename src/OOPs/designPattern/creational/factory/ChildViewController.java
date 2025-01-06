package OOPs.designPattern.creational.factory;

import OOPs.designPattern.creational.factory.webFramework.ChildViewTemplate;
import OOPs.designPattern.creational.factory.webFramework.ViewEngine;

public class ChildViewController extends Controller {
    @Override
    protected ViewEngine createViewEngine() {
        return new ChildViewTemplate();
    }
}
