package java8.collection.mapInterface.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		Hashtable<String,String> map = new Hashtable<>();
		map.put("name", "Shally");
		map.put("age", "100");
		map.put("location", "CA");
		System.out.println(map.get("age"));
		//iterating through map
		Enumeration<String> keys= map.keys();
		while(keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
		map=null;
	}
}
