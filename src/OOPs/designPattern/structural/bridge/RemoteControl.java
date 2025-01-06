package OOPs.designPattern.structural.bridge;

public class RemoteControl {
    public Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn(){
        device.turnOn();
    }
    public  void turnOff(){
        device.turnOff();
    }
}
