package java5.varargs.innerStatic;

//varargs//outer inner class
public class VarargTest {
	class nonStatic {
		int a =30;
		void display() {
			System.out.println("a "+ a);
		}
	}
	static class staticClass{
		static int sum=0;
		static String count(String s, int ... a) {
			for(int i:a) {
				 sum += i;
			}
			return s +sum;
		}
	}
	public static void main(String[] args) {
		VarargTest v = new VarargTest();
		VarargTest.nonStatic nonstatic = v.new nonStatic();
		nonstatic.display();
		//accessing static class thro by creating object of it
		staticClass scl= new staticClass();
		
		String n =scl.count("Hello " ,10,11,12);
		System.out.println(n);
	}

}
