package OOPs.designPattern.Bahavioral.strategy;

//This class will maintain reference to compressor and filter objects
//Polymorphism principle used
public class ImageStorage {
    private Compressor compressor;
    private  Filter filter;

    //pass the task objects to this method
    public void store(String fileName, Compressor compressor, Filter filter){
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}
