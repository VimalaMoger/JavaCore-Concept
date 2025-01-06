package OOPs.designPattern.creational.factory.webFramework;

import java.util.Map;

public class ViewTemplate  implements ViewEngine{

    @Override
    public String render(String view, Map<String, Object> data) {
        return "View rendered by ViewTemplate";
    }
}
