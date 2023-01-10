package org.example.javadoc;

/**
 * <code>Firebox</code> is an electronic device that extends from <code>ElectronicDevice</code>.
 * This electronic device has a constructor that sets this <code>Firebox</code> object to on.
 * <code>Firebox</code> overrides the off method from the base class <code>ElectronicDevice</code>.
 *
 * @author Long
 * @see ElectronicDevice
 */
public class Firebox extends ElectronicDevice {
    /**
     * The <code>constructor</code> that takes no arguments to build the object.
     * It will automatically call the on method from the superclass <code>ElectronicDevice</code>,
     * so it will be on, when creating the object.
     *
     * @see ElectronicDevice#on()
     */
    public Firebox() {
        on();
    }


    /**
     * Doesn't set the boolean value of <code>isOn</code> inside the superclass in <code>ElectronicDevice</code>.
     * This method inherited from the superclass got overridden to do nothing when called.
     * The <code>Firebox</code> object stays on permanently.
     *
     * @see ElectronicDevice#off()
     * @see ElectronicDevice#isOn()
     */
    @Override
    public void off() {
        // nothing happens here
    }
}
