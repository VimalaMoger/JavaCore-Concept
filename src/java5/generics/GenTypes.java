package java5.generics;

import java.util.ArrayList;
import java.util.List;

public class GenTypes<T> {
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 0; i <= 10; i++) {
	        list.add(i);
	        System.out.print(list.get(i)+" ");
	    }
	}
	private T a;
	public GenTypes(T a){
		this.a= a;
		T b;
	}

	GenTypes(){};

	void go(List<Double> list) {
		list.add(25.5);
	}

	public static void main(String[] args) {
		//method implementation
		new GenTypes<Integer>() {
			public void go() {
				System.out.println("annonymous ");
			}
		}.go();

		Box<Integer> stu = new Box();
		stu.set(1234);

		List<Object> list = new ArrayList<>();
		list.add(stu.get());
		addNumbers(list);

		Object someObject = new Object();

		Integer someInteger = 10;
		someObject = someInteger;   // OK	Box<Number> box = new Box<Number>();
		System.out.println("\n");
		someMethod(10);   // OK
		someMethod(10.1);   // OK

		List list1 = new ArrayList<String>();
		list1.add("hello");
		String s =  (String) list1.get(0);

		List<? super Number> nums = new ArrayList<>();
		nums.add(9.0);
		nums.add(9);
		nums.add(10);
		nums.forEach(e -> System.out.println("e value in list2: "+e));
	
		new GenTypes().go(nums);
		int element = (int) nums.get(2);
		System.out.println(element);

		List<? super Object> numbers = new ArrayList<>();
		numbers.add(9.0);
		numbers.add(9);
		numbers.add(-12);
		numbers.add("dd");
		numbers.clear();
		System.out.println(numbers.contains(9));

		Box<Integer> b = new Box<>();
		b.set(34);
		Integer i = b.get();
		System.out.println("i is: " +i);
	}
	public static void someMethod(Number n) { System.out.println("n is " +n);
	}
}

class Sample<T extends Number>{
	//T can be of bound/subtype of Number, like float, double , integer
}

class Box<T>{
	private T obj;
	public void set(T obj) {this.obj = obj;}
	public T get() {return obj;}
	
}


