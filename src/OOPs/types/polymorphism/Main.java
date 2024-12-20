package OOPs.types.polymorphism;

public class Main {
    public static void main(String[] args) {
        drawUIControl(new CheckBox()); //object takes on many different forms

    }
    public static void drawUIControl(UIControl uiControl){
        uiControl.draw();
    }
}
