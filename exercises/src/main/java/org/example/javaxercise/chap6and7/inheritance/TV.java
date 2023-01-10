package org.example.javaxercise.chap6and7.inheritance;

// uni & bi-directional relation
// 1.6.8
// super -> call superclass method + customize it as well (7.4.2)
public class TV extends ElectronicDevice {

    private boolean tvIsOn;
//    private final MonitorTube monitorTube = new MonitorTube( ); // uni
    private final MonitorTube monitorTube = new MonitorTube( this ); // bi-directional, need constructor and pass this TV context

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
