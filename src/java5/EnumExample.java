package java5;

public class EnumExample {
	static String s = "hello";

	public enum Operators {
		AND("&"),
		OR("|");
		Operators(String l) {
			this.l = l;
		}
		private final String l;
		public String get() {
			return l;
		}
	}

	public static void main(String[] args) {

		EnumExample.s="Hello";
		System.out.println(EnumExample.s);
		int x= 1;
		int y = 2;
		for(Operators ops: Operators.values()) {
			if (ops.get().equals("&")) {
				System.out.println("x + y " + (x + y));
			} else
				System.out.println("x or y "+ (x | y));
		}
	}

}
