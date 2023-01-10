package org.example.javaxercise.chap6and7;

// uni & bi-directional relation
public class MonitorTube {

    private final TV tv;
    // constructor + return -> for bi-directional relation
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
