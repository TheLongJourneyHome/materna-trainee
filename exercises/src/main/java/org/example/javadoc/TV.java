package org.example.javadoc;

/**
 * <code>TV</code> is an electronic device that extends from <code>ElectronicDevice</code>.
 * <code>TV</code> overrides the on and off method from the superclass <code>ElectronicDevice</code>.
 *
 * @author Long
 * @see ElectronicDevice
 */
public class TV extends ElectronicDevice {
    private boolean tvIsOn;
    private final MonitorTube monitorTube = new MonitorTube( this );


    /**
     * Overrides the on method from the superclass <code>ElectronicDevice</code>.
     * It calls the method from the superclass <code>ElectronicDevice</code> and calls the on method from <code>MonitorTube</code>
     *
     * @see ElectronicDevice#on()
     * @see MonitorTube#on()
     */
    @Override
    public void on() {
        super.on();
        monitorTube.on();
    }

    /**
     * Overrides the off method from the superclass <code>ElectronicDevice</code>.
     * It calls the method from the superclass <code>ElectronicDevice</code> and calls the off method from <code>MonitorTube</code>
     *
     * @see ElectronicDevice#off()
     * @see MonitorTube#off()
     */
    @Override
    public void off() {
        super.off();
        monitorTube.off();
    }

}
