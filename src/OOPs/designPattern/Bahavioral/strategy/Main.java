package OOPs.designPattern.Bahavioral.strategy;

/**
 * Strategy allows passing different algorithms(behaviors) to an object and allows defining a
 * skeleton for an operation and specific steps will then be implemented in subclasses
 * ImageStorage contains store method where we pass in the task objects(filter, compressor)
 * perform compress and apply operations
 * Polymorphism used
 */
public class Main {
    public static void main(String[] args) {
        // Implemented with Polymorphism principle, we can substitute a different type
        //Compressor compressor = new JpegCompressor();
       // Filter filter = new BlackAndWhileFilter();
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("JPEG", new JpegCompressor(), new BlackAndWhileFilter());
        imageStorage.store("JPEG", new PngCompressor(), new BlackAndWhileFilter());
    }
}
