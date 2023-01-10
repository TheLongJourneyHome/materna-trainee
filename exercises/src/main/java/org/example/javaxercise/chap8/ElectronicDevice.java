package org.example.javaxercise.chap8;

public class ElectronicDevice {

    private boolean isOn;
    private int watt;

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        this.watt = watt;
    }

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
                "isOn=" + isOn +
                ", watt=" + watt +
                '}';
    }
}
