package OOPs.designPattern.Bahavioral.strategy;

public class BlackAndWhileFilter implements Filter{
    @Override
    public void apply(String filename) {
        System.out.println("Applying B&W filter");

    }
}
