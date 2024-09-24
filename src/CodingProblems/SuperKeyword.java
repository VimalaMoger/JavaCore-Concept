package CodingProblems;

public class SuperKeyword {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.a);
		b.display();
	}
}

class A{
	int a =10;
	void display() {
		System.out.println("parent");
	}
}

class B extends A {
	int a = 20;
	void display() {
		System.out.println("subclass of A");
		System.out.println(super.a);
		super.display();
	}
}
