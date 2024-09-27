package java5.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedTypeDemo {

	public static void main(String[] args) {
		SelectTypeExample<String, Integer> obj = new SelectTypeExample<>("Shirt");
		obj.setItemSize(34);
		System.out.println(obj.getItem());
		
		Cat c = new Cat(23);
		Cat c2 = new Cat("black cat");
		int j =  (Integer)c.getCat(); //it cant unbox because it does not know what object type. so by casting would help to identify
		System.out.println(j);
		String s = (String)c2.getCat();
		System.out.println(s);
		
		Dog<String, Integer> dogs= new Dog<String,Integer>("Siberian Husky", 12);
		System.out.println(dogs.mediumDogs);
		System.out.println(dogs.age);
		
		Integer[] nums = {1, 2, 3, 4};
		Double[] d = {2.3, 6.7};
		String[] ss = {"cat","dog"};

		//string does not work,string is not bounded parameter so gets error
		//BoundedType<String> c =  new BoundedType<>(); // is not within its bound
		BoundedType<Integer> intValues = new BoundedType<>(nums);
		BoundedType<Double> doubleValues = new BoundedType<>(d);

		List<Number> lists = new ArrayList<>();
		lists.add(intValues.avgNum());
		lists.add(doubleValues.avgNum());
		System.out.println("average lists "+ lists);

		//Similarly
		BoundedTypeDemo example = new BoundedTypeDemo();
		List<BoundedTypeDemo> list2 = new ArrayList<>();
		list2.add(new Cat());
		list2.add(new Dog());
		//list2.add(new SelectTypeExample<>());  //error- Required type : GenericsExample

	}
}

class SelectTypeExample<E,N>{
	private E item;
	private N size;

	public SelectTypeExample(){}
	public void setItemSize(N size) {
		this.size = size;
	}

	public SelectTypeExample(E item) {
		this.item = item;
	}
	public E getItem() {
		return item;
	}
}

//don't use this type object type in your progg,  use generics
class Cat extends BoundedTypeDemo {

	Object obj;
	public Cat(){}
	public Cat(Object obj1) {
		this.obj=obj1;
}
	public Object getCat() {
		return obj;
	}
}

//generics multiple types
class Dog<D1,D2> extends BoundedTypeDemo {

	D1 mediumDogs;
	D2 age;
	public Dog(){}
	public Dog(D1 a, D2 b) {
		this.mediumDogs = a;
		this.age = b;
	}
}

//bounded type parameters
class BoundedType<A extends Number>{   //this is called upper bound- extends
	A[] num;

	public BoundedType(A[] a) {
		this.num = a;
	}
	//calculates average of n numbers in A[]
	double avgNum() {
		double sum=0;
		for(int i=0; i<num.length; i++) {
			sum = sum + num[i].doubleValue();
		}
		return sum/num.length;
	}
}
