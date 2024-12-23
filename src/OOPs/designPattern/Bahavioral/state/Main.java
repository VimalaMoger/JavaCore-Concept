package OOPs.designPattern.Bahavioral.state;

/**
 * State allows an object to behave differently depending on the state it is in
 * So, in Canvas class current Tool is chosen, depends on the current tool,
 * the canvas class behaves differently
 *
 */
public class Main {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		canvas.setCurrentTool(new SelectionTool());  //polymorphism:
		canvas.mouseDown();
		canvas.mouseUp();
	}
}
