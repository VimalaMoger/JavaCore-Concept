package OOPs.designPattern.structural.bridge;

import javax.sound.midi.Soundbank;

//Implementation Hierarchy
public class SonyTV implements Device{
    @Override
    public void turnOn() {
        System.out.println("Sony is On");
    }

    @Override
    public void turnOff() {
        System.out.println("Turned Off");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Channel is now set to " + number);
    }
}
