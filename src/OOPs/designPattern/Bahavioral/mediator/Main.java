package OOPs.designPattern.Bahavioral.mediator;
/**
Mediator allows an object to encapsulate the communication between other objects
 */
public class Main {
    public static void main(String[] args) {
        var dialogBox = new ArticlesDialogBox();
        //simulate user interaction
        dialogBox.simulateUserInteraction();

    }
}
