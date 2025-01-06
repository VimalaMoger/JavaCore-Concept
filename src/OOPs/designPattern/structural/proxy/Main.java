package OOPs.designPattern.structural.proxy;

/**
 *The LogEbookProxy object delegates the request to the target object, also contains some additional behaviors
 * Library object stores all the ebooks into a map, openEbook function forward the request to
 * LogEbookProxy object then to realEbook object to execute load() and show()
 */
public class Main {
    public static void main(String[] args) {
        var library = new Library();
        String[] fileNames = {"file1","file2","file3"};
        for(var fileName : fileNames){
           // library.add(new EbookProxy(fileName));
            library.add(new LogEbookProxy(fileName));
        }
        library.openEbook("file1");
        library.openEbook("file2");
        library.openEbook("file3");
    }
}
