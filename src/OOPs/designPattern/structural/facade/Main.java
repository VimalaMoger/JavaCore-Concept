package OOPs.designPattern.structural.facade;

/**
 * Hides the complexity in NotificationService that acts as facade
 * Client interacts to facade rather than individual classes
 */
public class Main {
    public static void main(String[] args) {
        var notificationService = new NotificationService();
        notificationService.send("Hello World", "target" );
    }
}
