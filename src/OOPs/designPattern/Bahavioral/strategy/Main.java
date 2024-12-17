package OOPs.designPattern.Bahavioral.strategy;

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
