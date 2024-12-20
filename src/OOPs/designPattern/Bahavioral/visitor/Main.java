package OOPs.designPattern.Bahavioral.visitor;
/**
 * Visitor allows adding new operations to an object structure without modifying it
*/
 public class Main {
    public static void main(String[] args) {
        var document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());
        //document.execute(new HighlightVisitor());//open closed responsibility principle
        document.execute(new PlainTextVisitor());
    }
}
