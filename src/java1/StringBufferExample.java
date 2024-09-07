package java1;

public class StringBufferExample {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello ").append('b').append(" to EveryOne ");
		System.out.println(sb);

		int capacity =sb.capacity();
		System.out.println("capacity"+capacity);

		System.out.println("sb.codePointAt(1) "+sb.codePointAt(1));
		System.out.println("sb.chars().findAny() "+sb.chars().findAny());

		String name ="Hello";
		int n = name.compareTo("hello");
		System.out.println("n "+n);
		System.out.println("name.compareTo(\"hello\") "+(name.compareTo("hello")>0));

		sb.delete(1, 15);
		System.out.println("sb "+sb);

		sb.insert(0,"M");
		System.out.println("sb "+sb);

		sb.replace(1, 2, "");
		System.out.println("sb "+sb);

		sb.reverse();
		String s=sb.substring(3);
		System.out.println("s "+s);
	}
}
