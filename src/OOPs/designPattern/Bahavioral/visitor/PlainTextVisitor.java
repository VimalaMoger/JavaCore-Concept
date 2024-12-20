package OOPs.designPattern.Bahavioral.visitor;

public class PlainTextVisitor implements Visitor{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("text-heading");
    }

    @Override
    public void apply(AnchorNode heading) {
        System.out.println("text-anchor");
    }
}
