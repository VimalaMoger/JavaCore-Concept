package OOPs.designPattern.Bahavioral.strategy;

public class ImageStorage {
    //Polymorpism principle used

    private Compressor compressor;
    private  Filter filter;

  /*  public ImageStorage(Compressor compressor, Filter filter){
        this.compressor = compressor;
        this.filter = filter;
    }*/
    //pass the task objects to this method
    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
