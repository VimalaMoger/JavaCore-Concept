package OOPs.designPattern.creational.builder;

/** Presentation class contains the explore method that takes the PdfDocumentBuilder object as argument,
* PdfDocumentBuilder interacts with PdfDocument, to execute the required task
*/
 public class Main {
    public static void main(String[] args) {
        var presentation = new Presentation();
        presentation.addSlide(new Slide("Slide 1"));
        presentation.addSlide(new Slide("Slide 2"));
        presentation.export(new PdfDocumentBuilder());//passing a PdfBuilder object
        //passing PowerpointBuilder
        presentation.export(new PptBuilder());
    }
}
