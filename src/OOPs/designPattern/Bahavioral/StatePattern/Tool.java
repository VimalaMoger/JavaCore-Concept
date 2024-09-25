package OOPs.designPattern.Bahavioral.StatePattern;

/*public abstract class Tool { //use either abstact or interface to remove common code in other classes
	public abstract void mouseDown();
	public abstract void mouseUp();

}*/
public interface  Tool { //use either abstact or interface to remove common code in other classes. they allows use loosely coupled applications
	void mouseDown();
	void mouseUp();
}
