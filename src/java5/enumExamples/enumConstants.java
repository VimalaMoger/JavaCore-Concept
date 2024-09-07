package java5.enumExamples;

public enum enumConstants {
	BIOGRAPHY(12),
	HORROR(15);

	private int i;  //state

	enumConstants(int i) {
		this.i = i;    //behaviour
	}

	public int getI() {
		return i;
	}

	public static void main(String[] args) {
		System.out.println(enumConstants.BIOGRAPHY.getI());
		System.out.println(enumConstants.valueOf("HORROR"));
		System.out.println(enumConstants.BIOGRAPHY.ordinal());
		System.out.println(enumConstants.BIOGRAPHY.getDeclaringClass());
		

	}
	
}

	


