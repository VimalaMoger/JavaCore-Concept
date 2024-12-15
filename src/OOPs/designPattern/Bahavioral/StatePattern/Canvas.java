package OOPs.designPattern.Bahavioral.StatePattern;

public class Canvas {
	private Tool currentTool;  //association
	public void mouseDown() {
		currentTool.mouseDown();
	}
	public void mouseUp() {
		currentTool.mouseUp();
		}
	public Tool getCurrentTool() {
		return currentTool;
	}
	public void setCurrentTool(Tool currentTool) {
		this.currentTool = currentTool;
	}
}
