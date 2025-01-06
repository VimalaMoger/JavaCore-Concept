package OOPs.designPattern.structural.adapter;

import OOPs.designPattern.structural.adapter.avaFilter.Caramel;

/**
 * Conversion of interface of a class into another interface
 * In the apply method inside ImageView class, takes CaramelFilter object
 * that initializes Caramel object, to run init(), render() tasks
 */
public class Main {
    public static void main(String[] args) {
        var imageView = new ImageView(new Image());
        imageView.apply((new CaramelFilter(new Caramel())));
    }
}
