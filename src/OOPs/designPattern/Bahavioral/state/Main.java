package OOPs.designPattern.Bahavioral.state;

public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		canvas.setCurrentTool(new SelectionTool());  //polymorphism:
		canvas.mouseDown();
		canvas.mouseUp();
	}
}
