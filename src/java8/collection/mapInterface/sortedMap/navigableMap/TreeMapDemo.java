package java8.collection.mapInterface.sortedMap.navigableMap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		NavigableMap<Integer,String> map = new TreeMap<>(new MyComp());
		//TreeMap<Integer,String> map = new TreeMap(new myComp());
		
		System.out.println("last entry "+ map.lastEntry());
		map.put(1,"Shre");
		map.put(2,"Shreesh");
		map.put(3,"Shreesha");

		for(Map.Entry<Integer,String> entry : map.entrySet()){
			System.out.print(" .." + entry.getValue());
			if(entry.getKey()==1) {
				entry.setValue("Shrees");
			}
		}
		System.out.println("\nkeys");

		Set<Integer> keys= map.keySet();
		keys.forEach(System.out::println);

		System.out.println("values");
		Collection<String> values= map.values();
		values.forEach(System.out::println);
		
		//sortedmap interface methods
		System.out.println("last entry "+map.lastEntry());
		Map map2 = map.headMap(2,true);
		System.out.println("map2 " +map2);
		
		Map map3= map.subMap(3, 2);  //keys 3 inclusive and 2 exclusive
		System.out.println("map3 "+map3);
		
		Map map4 = map.tailMap(2); //keys > or equal to fromKey
		System.out.println("map4"+map4);
		
		//navigablemap interface methods
		System.out.println(map.containsKey(1));
		

		System.out.println("small key"+ map.ceilingEntry(1));
		System.out.println("small key"+ map.ceilingKey(1));
		NavigableSet<Integer> map10= map.descendingKeySet();
		Set<Integer> map11 = map.descendingKeySet();
		System.out.println(map10);
		System.out.println(map.lastEntry());
		System.out.println(map.lastKey());
		System.out.println(map.lowerKey(2));
		System.out.println(map.lastEntry());
		
		map.clear();
		map2=map3=map4 =map= null;
	}

}
class MyComp implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}


	
}
