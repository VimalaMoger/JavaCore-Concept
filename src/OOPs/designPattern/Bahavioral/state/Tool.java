package OOPs.designPattern.Bahavioral.state;

/*public abstract class Tool {
	//using either abstract or interface to remove common code in other classes
	public abstract void mouseDown();
	public abstract void mouseUp();

}*/
public interface  Tool { //use either abstract or interface to remove common code in other classes. they allows use loosely coupled applications
	void mouseDown();
	void mouseUp();
}
