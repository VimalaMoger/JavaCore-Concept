package OOPs.designPattern.structural.bridge;

/**
 * RemoteControl class is separated from the implementation hierarchy, ie SonyTV implementation
 * it allows to split the complex hierarchy into two separate ones
 */
public class Main {
    public static void main(String[] args) {
        var remoteControl = new RemoteControl(new SonyTV());
        remoteControl.turnOn();

        var advancedRemoteControl = new AdvancedRemoteControl(new SonyTV());
        advancedRemoteControl.setChannel(45);
    }
}
