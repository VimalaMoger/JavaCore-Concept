package OOPs.designPattern.structural.adapter.avaFilter;

import OOPs.designPattern.structural.adapter.Image;

public class Caramel {
    public void init(){
        System.out.println("Caramel init called");
    }

    public void render(Image image){
        System.out.println("Applying Caramel filter");
    }
}
