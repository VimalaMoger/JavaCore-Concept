package OOPs.designPattern.Bahavioral.visitor;

public class HeadingNode implements HtmlNode{
    @Override
    public void execute(Visitor visitor) {
        visitor.apply(this); //takes HeadingNode object to the call
        System.out.println("HeadingNode");
    }
}
