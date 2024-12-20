package OOPs.designPattern.Bahavioral.state;

/**
 * State allows an object to behave differently depending on the state it is in
 */
public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		canvas.setCurrentTool(new SelectionTool());  //polymorphism:
		canvas.mouseDown();
		canvas.mouseUp();
	}
}
