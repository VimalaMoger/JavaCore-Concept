package OOPs.designPattern.creational.singleton;

public class SingletonUser {
	private static SingletonUser instance = new SingletonUser();

	private static String name;

	private SingletonUser() {
		name= "Shan";
	}

	public String getName() {
		return name;
	}

	public static SingletonUser getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		SingletonUser user = SingletonUser.getInstance();
		System.out.println(user.getName());

		SingletonUser other = SingletonUser.getInstance();
		System.out.println(other.getName());
		

}
}
