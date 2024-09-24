package java5.enumExamples;

public enum EnumConstants {
	BIOGRAPHY(12),
	HORROR(15);

	private int i;  //state

	EnumConstants(int i) {
		this.i = i;    //behaviour
	}

	public int getI() {
		return i;
	}

	public static void main(String[] args) {
		System.out.println(EnumConstants.BIOGRAPHY.getI());
		System.out.println(EnumConstants.valueOf("HORROR"));
		System.out.println(EnumConstants.BIOGRAPHY.ordinal());
		System.out.println(EnumConstants.BIOGRAPHY.getDeclaringClass());
		

	}
	
}

	


