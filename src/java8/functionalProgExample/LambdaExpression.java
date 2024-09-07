package java8.functionalProgExample;


//lambda   () ->  is a method
interface FunctionalInterface{
	//implicity abstract, return type
	double giveResult(double d, double b);   //using method parameters
}

interface Strings{
	String giveString(String s);
}

interface Numbers{
	int newArray(int[] arr);
}
interface Fact<A>{
	A getFact(A a) ;
}

//use lambda as method parameter
interface NumbersOfApples{
	int getApples(int num);
}

//lambda with exceptions
interface Oranges {
	int getOranges(int [] arr) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
	EmptyArrayException(){
		super("Array is empty");
	}
}

//effectively final
interface Nature{
	String Nature(String s) ;
}

public class LambdaExpression {
		static int randomMethod(NumbersOfApples apples,int m) {
			return apples.getApples(m);
		}
	
		public static void main(String[] args) throws EmptyArrayException {
			
			String value ="Plants"; //in lambda function , this variable effectively captured, final, can not set, in or outside main
			Nature n = (String str) -> {
				String ss ;
				ss = value;
				//value ="something";  //gives error
				return value;
			};
	
			Oranges o = (int[] arr) -> {
				if(arr.length == 0) {
					throw new EmptyArrayException();
				}else {
				int max = 0;
				for(int i = 0;i < arr.length; i++) {
					if(arr[i] > max) {
						max = arr[i];
					}
				}
				return max;
			}
			};
			int[] array = {}; //{1,2,3,4};
			 System.out.println(o.getOranges(array));
		
			NumbersOfApples apples = (int i) -> i;

			System.out.println(randomMethod(apples,3));
			
			Fact<Integer> f = (number) ->{
				int result =1;
				for(int i = 1;i <= number; i++) {
					result = i * result;
				}
				return result;
				
			};
			System.out.println("fact is " + f.getFact(3));

			FunctionalInterface one= (d, b) ->d + b;  //infer type from method, you can get rid of types in parameter
			System.out.println(one.giveResult(1.1,2.2));

			Strings s= (String a) -> {
				String reverseS="";
				for(int i=a.length()-1; i>=0;i--) {
					reverseS +=  a.charAt(i);
				}
				return reverseS;
			};  //block of code, you need to specify return here, semicolon

			System.out.println(s.giveString("animals"));
		}
	
		int [] arr= {1,2,3,4,5};
		Numbers nums = (int[] a)-> {
			int sum=0;
			for(int i=0;i<a.length;i++) {
				sum +=  a[i];
			}
			return sum;
		};
}
