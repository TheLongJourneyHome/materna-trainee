package org.example.javaxercise.chap6and7.inheritance;

public class ElectronicDevice {

    private boolean isOn;

    public void on() {
        isOn = true;
        System.out.println("Device is on");
    }

    public void off() {
        isOn = false;
        System.out.println("Device is off");
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "isOn=" + (isOn ? "on" : "off") +
                '}';
    }
}
