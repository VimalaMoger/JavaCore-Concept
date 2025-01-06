package OOPs.designPattern.creational.factory;

import OOPs.designPattern.creational.factory.webFramework.ViewEngine;
import OOPs.designPattern.creational.factory.webFramework.ViewTemplate;

import javax.swing.text.View;
import java.util.Map;

public class Controller {
    public void render(String viewName, Map<String, Object> data){
        var engine = createViewEngine();
        var html = engine.render(viewName, data);
        System.out.println(html);
    }
    protected ViewEngine createViewEngine(){
        return new ViewTemplate();
    }
}
