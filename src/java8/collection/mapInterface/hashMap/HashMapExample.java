package java8.collection.mapInterface.hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		System.out.println("size "+ map.size());
		map.put(1,"Shree");
		map.put(1,"Dev");
		System.out.println("size "+ map.size());
		
		for(Map.Entry<Integer,String> entry :map.entrySet()){
			System.out.println(entry.getValue());
		}
		Set<Integer> keys= map.keySet();
		keys.forEach(System.out::println);
		Collection<String> values = map.values();
		values.forEach(System.out::println);
	}
}
