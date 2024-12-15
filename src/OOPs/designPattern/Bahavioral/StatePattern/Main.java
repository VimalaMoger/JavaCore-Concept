package OOPs.designPattern.Bahavioral.StatePattern;

public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		canvas.setCurrentTool(new SelectionTool());  //polymorphism:
		canvas.mouseDown();
		canvas.mouseUp();
	}
}
