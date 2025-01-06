package OOPs.designPattern.creational.factory;

import java.util.HashMap;
import java.util.Map;

public class ProductController extends ChildViewController {

    public void listProducts(){
        Map<String,Object> context =  new HashMap<>();
        render("products.html" , context);
    }
}
