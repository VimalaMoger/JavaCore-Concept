package OOPs.designPattern.creational.singleton;

/** The ConfigManager class has no constructor to create multiple
* instances, so only one instance created during the time when class loaded into memory, reused
*/
public class Main {
    public static void main(String[] args) {
        ConfigManager manager = ConfigManager.getInstance();
        manager.set("name", "John");
        System.out.println(manager.get("name"));

        ConfigManager other = ConfigManager.getInstance();
        manager.set("name", "Joe");
        System.out.println(other.get("name"));

    }
}
