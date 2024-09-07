package java5.generics;

//using generic methods and constructors

class maxNum{
	static <arrNum extends Number> double maxNumber(arrNum[] x) {
		double result=0.0;
		for(int i=0;i<x.length;i++) {
			if(x[i].doubleValue() > result) {
				result = x[i].doubleValue();
			}
		}
		return result;
	}
}

//using constructor
class SampleClass {
	double value;
	<N extends Number> SampleClass(N num) {
		value= num.doubleValue();
	}
	public double getValue() {
		return value;
	}
}

public class NonGenericClass {
	public static void main(String[] args) {
		
		Integer[] i = {1,6,60,2};
		Double[] d = {1.0,6.0,60.0,2.0};
		String[] s= {"v","i","m"}; 
		System.out.println(maxNum.maxNumber(i));
		System.out.println(maxNum.maxNumber(d));
		//System.out.println(maxNum.maxNumber(s)); //String is not subclass of Number
		int in = 10;
		
		SampleClass number= new SampleClass(in);
		System.out.println(number.getValue());
	}
}
