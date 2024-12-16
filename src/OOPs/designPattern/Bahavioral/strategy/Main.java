package OOPs.designPattern.Bahavioral.strategy;

public class Main {
    public static void main(String[] args) {
        //Compressor compressor = new JpegCompressor();
       // Filter filter = new BlackAndWhileFilter();
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("JPEG", new JpegCompressor(), new BlackAndWhileFilter());
        imageStorage.store("JPEG", new PngCompressor(), new BlackAndWhileFilter());
    }
}
