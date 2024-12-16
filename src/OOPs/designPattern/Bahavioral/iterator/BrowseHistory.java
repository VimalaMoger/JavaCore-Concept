package OOPs.designPattern.Bahavioral.iterator;

import java.util.ArrayList;
import java.util.List;

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


/*    private List<String> urls = new ArrayList<>();

    public void  push(String url){
        urls.add(url);
    }

    public String  pop(){
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);
        return lastUrl;
    }*/

    public Iterator createIterator() {
        return new ArrayIterator(this);
    }

    public String[] getUrls() {
        return urls;
    }
}
