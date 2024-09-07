package java8.collection.mapInterface.hashMap;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class linkedHashmapExample {

	public static void main(String[] args) {
		Map<Integer,String> map = new LinkedHashMap<>();
	
		System.out.println("size "+map.size());
		map.put(1,"Shre");
		map.put(2,"Shree");
		map.put(3,"Shrees");
		System.out.println("size "+map.size());
		
		for(Map.Entry<Integer,String> entry :map.entrySet()){
			System.out.println(entry.getValue());
		}
		
		Set<Integer> keys= map.keySet();
		keys.forEach(System.out::println);
		Collection<String> values= map.values();
		values.forEach(System.out::println);
	}
}


