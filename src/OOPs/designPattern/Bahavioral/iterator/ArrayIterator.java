package OOPs.designPattern.Bahavioral.iterator;

public class ArrayIterator implements Iterator{
    BrowseHistory history;
    private  int index;

    public  ArrayIterator(BrowseHistory history){
        this.history = history;
    }

    @Override
    public boolean hasNext() {
        //return (index < history.getUrls().size());
        return (index < history.index);
    }

    @Override
    public String current() {
        return history.getUrls()[index];
    }

    @Override
    public void next() {
        index++;
    }
}
