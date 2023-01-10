package org.example.javadoc;

/**
 * <code>ElectronicDevice</code> serves as the base class for all electronic devices in this project to derive from.
 * <p>
 * This class can be <code>abstract</code>, but remains <code>public</code> because the exercise did not require it.
 * It provides the devices with variables and methods that each electronic device has.
 *
 * @author Long
 */
public class ElectronicDevice {
    private boolean isOn;
    private int watt;

    /**
     * Gets the watt of the electronic device that calls this method.
     *
     * @return the watt of the device
     * @see #watt
     */
    public int getWatt() {
        return watt;
    }
    /**
     * Sets the watt of the electronic device that calls this method.
     *
     * @param watt the watt that this <code>watt</code>> will take the value from
     * @see #watt
     */
    public void setWatt(int watt) {
        this.watt = watt;
    }

    /**
     * Sets this <code>isOn boolean</code> to true.
     *
     * @see #isOn
     */
    public void on() {
        isOn = true;
        System.out.println("Device is on");
    }

    /**
     * Sets this <code>isOn boolean</code> to false.
     *
     * @see #isOn
     */
    public void off() {
        isOn = false;
        System.out.println("Device is off");
    }

    /**
     * Gets the <code>isOn boolean</code> value of the electronic device that calls this method.
     *
     * @return the boolean value of the electronic device
     * @see #isOn
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Prints a <code>String</code> of device and its values.
     * <p>
     * The values that will be printed are this <code>isOn</code> and this <code>watt</code>.
     *
     * @return the <code>String</code> of the device that calls this method and with its values
     * @see #isOn
     * @see #watt
     */
    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "isOn=" + isOn +
                ", watt=" + watt +
                '}';
    }
}
