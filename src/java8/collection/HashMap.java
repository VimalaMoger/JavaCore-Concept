package java8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMap {

	public static void main(String[] args) {

		Map<String, Map<String, Object>> userProfile1 = new java.util.HashMap<>();
		List list = new ArrayList();
		list.add(26);
		list.add("male");

		Map<String,Object> profile = new java.util.HashMap<>();
		profile.put("age", list);
		profile.put("dept", "CS");
		profile.put("city", "New York");
		userProfile1.put("John", profile);

		System.out.println("userProfile1 " + userProfile1);

		Map<String, Map<String, Object>> userProfile2 = new java.util.HashMap<>();
		profile.put("age", 25);
		profile.put("dept", "EC");
		profile.put("city", "New York");
		userProfile2.put("null", profile);
		userProfile2.putIfAbsent("Shea", profile);

		System.out.println("userProfile2 " + userProfile2);

		//keySet() on Map object
		Set<String> keySet = profile.keySet();
		for(String key : keySet) {
			System.out.println(key +" "+ (userProfile1.get("John")).get(key));
		}

		//entrySet() on map object
		Set<Entry<String, Map<String, Object>>> mappings = userProfile2.entrySet();
		for(Entry<String, Map<String, Object>> name : mappings) {
			System.out.println(name.getKey() +" and "+ name.getValue());
		}
		userProfile1 = null;
		userProfile2= null;
		profile = null;
		mappings=null;

		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(9);
		System.out.println("data in "+arrayList);

		//initializing
		int [] array = new int[2];
		List list1 = Arrays.asList(array);
		List<Integer> list2= Arrays.asList(new Integer[10]);
		List<Integer> list3= Arrays.asList(10);

		List list4 = arrayList.subList(0, 2);
		System.out.println(list4);

		arrayList.subList(0, 1).clear();
		System.out.println("values remaining "+arrayList);

		System.out.println(list3);

		try {
			list3.set(1, 99);  //IndexOutOfBounds
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}finally {
			list3.add(0, 99);//UnsupportedOperation exception?
			System.out.println(list3);
		}
	}

}
