package OOPs.designPattern.creational.factory.webFramework;

import java.util.Map;

public interface ViewEngine {
    public String render(String view, Map<String, Object> data);
}
