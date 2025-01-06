package OOPs.designPattern.structural.adapter;
import OOPs.designPattern.structural.adapter.avaFilter.Caramel;


public class CaramelFilter  implements  Filter{
    private Caramel caramel; //used Composition

    public CaramelFilter(Caramel caramel){
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }
}
