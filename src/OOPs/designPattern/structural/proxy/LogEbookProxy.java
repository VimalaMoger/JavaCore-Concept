package OOPs.designPattern.structural.proxy;

public class LogEbookProxy implements Ebook{
    private String fileName;
    private RealEbook realEbook;

    public LogEbookProxy(String filename) {
        this.fileName = filename;
    }

    @Override
    public void show() {
        if(realEbook == null){
            realEbook = new RealEbook(fileName); //performing lazy initialization
        }
        realEbook.show();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
