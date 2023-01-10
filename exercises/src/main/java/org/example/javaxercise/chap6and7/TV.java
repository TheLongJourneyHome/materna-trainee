package org.example.javaxercise.chap6and7;

// uni & bi-directional relation 7.1.2
public class TV {

    private boolean tvIsOn;
//    private final MonitorTube monitorTube = new MonitorTube( ); // uni
    private final MonitorTube monitorTube = new MonitorTube( this ); // bi-directional, need constructor and pass this TV context

    public void on() {
        tvIsOn = true;
        System.out.println("TV is on");
        monitorTube.on();
    }

    public void off() {
        tvIsOn = false;
        System.out.println("TV is off");
        monitorTube.off();
    }
}
