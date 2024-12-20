package OOPs.designPattern.creational.singlton;



public class singletonUser {
	private static singletonUser instance = new singletonUser();
	private static String name;

	private singletonUser() {
		name= "Shanaya";
	}

	public static singletonUser getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(singletonUser.getInstance().name);
		

}
}
