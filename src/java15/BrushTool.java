package java15;

public class BrushTool extends Tool {

    @Override
    public void mouseDown() {
        System.out.println("Brush icon");

    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");

    }

}