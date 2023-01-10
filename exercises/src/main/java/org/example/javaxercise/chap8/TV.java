package org.example.javaxercise.chap8;

public class TV extends ElectronicDevice {

    private boolean tvIsOn;

    private final MonitorTube monitorTube = new MonitorTube( this );

    @Override
    public void on() {
        super.on();
        monitorTube.on();
    }

    @Override
    public void off() {
        super.off();
        monitorTube.off();
    }

}
