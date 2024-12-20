package OOPs.designPattern.Bahavioral.visitor;

public class AnchorNode implements HtmlNode{
    @Override
    public void execute(Visitor visitor) {
        visitor.apply(this); //this references to AnchorNode
        System.out.println("AnchorNode");
    }
}
