package OOPs.designPattern.Bahavioral.command.fx;

public class ResizeCommand implements  Command{
    @Override
    public void execute() {
        System.out.println("Resized");
    }
}
