package OOPs.designPattern.Bahavioral.visitor;

public class HighlightVisitor implements Visitor{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("highlight heading");
    }

    @Override
    public void apply(AnchorNode heading) {
        System.out.println("highlight anchor");
    }
}
