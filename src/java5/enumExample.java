package java5;

public class enumExample {
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

		enumExample.s="Hello";
		System.out.println(enumExample.s);
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
