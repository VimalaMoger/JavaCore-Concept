package OOPs.designPattern.structural.adapter;

import OOPs.designPattern.structural.adapter.avaFilter.Caramel;

public class CaramelAdapter extends Caramel implements Filter{
    //using Inheritance
    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
