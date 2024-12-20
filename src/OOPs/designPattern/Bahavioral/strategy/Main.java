package OOPs.designPattern.Bahavioral.strategy;

/**
 * Strategy allows passing different algorithms(behaviors) to an object and allows defining a template
 * (skeleton) for an operation and specific steps will then be implemented in subclasses
 */
public class Main {
    public static void main(String[] args) {

        /**
        Implemented with Polymorphism principle, we can substitute a different type in later
         period of time
         */
        //Compressor compressor = new JpegCompressor();
       // Filter filter = new BlackAndWhileFilter();
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("JPEG", new JpegCompressor(), new BlackAndWhileFilter());
        imageStorage.store("JPEG", new PngCompressor(), new BlackAndWhileFilter());
    }
}
