package org.example.javaxercise.chap8;

public class MonitorTube {

    private final TV tv;
    public MonitorTube(TV tv) { // constructor
        this.tv = tv;
    }

    public TV getTV() {
        return tv;
    }


    public void on() {
        System.out.println("Tube is on");
    }

    public void off() {
        System.out.println("Tube is off");
    }
}
