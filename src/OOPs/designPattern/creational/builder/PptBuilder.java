package OOPs.designPattern.creational.builder;

public class PptBuilder implements PresentationBuilder{

    private PptDocument pptDocument = new PptDocument();

    @Override
    public void addSlide(Slide slide) {
        pptDocument.addImage(slide.getText());
    }
}
