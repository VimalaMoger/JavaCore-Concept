package OOPs.designPattern.Bahavioral.iterator;

public class BrowseHistory {
    private Iterator iterator;

    //replace the List with fixed sized array
    public int index = 0;
    private String[] urls = new String[3];

    public void  push(String url) {
        urls[index++] = url;
    }
    public String  pop(){
        index--;
        return urls[index];
    }

    //returns one of the types of Iterator
    public Iterator createIterator() {
        return new ArrayIterator(this);
    }

    public String[] getUrls() {
        return urls;
    }
}
