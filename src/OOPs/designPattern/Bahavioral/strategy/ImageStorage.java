package OOPs.designPattern.Bahavioral.strategy;

public class ImageStorage {
    private Compressor compressor;
    private  Filter filter;

  /*  public ImageStorage(Compressor compressor, Filter filter){
        this.compressor = compressor;
        this.filter = filter;
    }*/

    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
