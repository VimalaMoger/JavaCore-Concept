package java5.generics;

public class GenericsExample {

	public static void main(String[] args) {
		SelectTypeExample<String> obj = new SelectTypeExample<String>("Shirt");
		obj.setNum("34");
		System.out.println(obj.num);
		
		Cat c = new Cat(23);
		Cat c2 = new Cat("black cat");
		int j=  (Integer)c.getCat(); //it cant unbox because it does not know what object type. so by casting would help to identify
		System.out.println(j);
		String s = (String)c2.getCat();
		System.out.println(s);
		
		Dog<String, Integer> dogs= new Dog<String,Integer>("red colored", 12);
		System.out.println(dogs.smallDogs);
		System.out.println(dogs.bigDogs);
		
		Integer[] nums= {1,2,3,4};
		Double[] d= {2.3,6.7};
		String[] ss= {"cat","dog"};

		//string does not work,string is not bounded parameter so gets error
		BoundedType<Integer> l = new BoundedType<Integer>(nums);
		System.out.println(l.avgNum());
		BoundedType<Double> l2 = new BoundedType<Double>(d);
		System.out.println(l2.avgNum());
	}
}

class SelectTypeExample<E>{
	E num;
	public void setNum(E nuM) {
		this.num=nuM;
	}

	public SelectTypeExample(E var) {
		this.num= var;
	}
	public E getNum(E nuM) {
		return num;
	}
}

//don't use this type object type in your progg,  use generics
class Cat{
	Object obj;
	public Cat(Object obj1) {
		this.obj=obj1;
}
	public Object getCat() {
		return obj;
	}
}

//generics multiple types
class Dog<D1,D2>{
	D1 smallDogs;
	D2 bigDogs;
	public Dog(D1 a, D2 b) {
		this.smallDogs=a;
		this.bigDogs=b;
	}
}

//bounded type parameters
class BoundedType<A extends Number>{   //this is called upper bound- extends
	A[] num;
	public BoundedType(A[] a) {
		this.num= a;
		
	}
	double avgNum() {
		double sum=0;
		for(int i=0;i<num.length;i++) {
			sum = sum+ num[i].doubleValue();
		}
		return sum/num.length;
	}
}
