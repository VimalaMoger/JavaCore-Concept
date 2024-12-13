package java15.instanceofDemo;

public class UsingInstanceOf {
    public static void main(String[] args) {
        Tool tool = new BrushTool(); // refers to child object
        if(tool instanceof Tool){
            tool.mouseDown();
            tool.mouseUp();
        }
    }
}


