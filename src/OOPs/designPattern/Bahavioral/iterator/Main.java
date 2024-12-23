package OOPs.designPattern.Bahavioral.iterator;

/**
 * Iterator allows iterating over an object without having to expose the object's internal
 * structure(which may change in the future)
 * ArrayIterator, ListIterator implement Iterator interface. BrowserHistory contains all the
 * logic - manipulate/store data using diff data storage, it also can switch between iterator types
 * the iterator instance returned from createIterator method, iterates over the collection of data
 */
public class Main {

	public static void main(String[] args) {
		var history = new BrowseHistory();
		history.push("a");
		history.push("b");
		history.push("c");

		Iterator iterator = history.createIterator();
		while(iterator.hasNext()){
			String url = iterator.current();
			System.out.println(url);
			iterator.next();
		}
	}
}
