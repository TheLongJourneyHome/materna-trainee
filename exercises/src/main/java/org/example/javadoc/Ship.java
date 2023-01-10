package org.example.javadoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * <code>Ship</code> is the class in which created objects of the other classes derived from <code>ElectronicDevice</code> can be used and modified.
 * <p>
 * Changes such as turning on devices and usage such as adding devices to an <code>ArrayList</code> and counting the number of devices turned on.
 *
 * @author Long
 */
public class Ship {
    private final ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
    private final ElectronicDeviceWattComparator wattComparator = new ElectronicDeviceWattComparator(); //   private final static ElectronicDeviceWattComparator ELECTRONIC_DEVICE_WATT_COMPARATOR = new ElectronicDeviceWattComparator(); -> will stay constant / static!
    private static final int MAXIMUM_POWER_CONSUMPTION = 3000;


    /**
     * Gets device from this <code>ArrayList devices</code> that has the biggest <code>Integer</code> in watt.
     *
     * @see #devices
     * @see ElectronicDevice#getWatt()
     */
    public ElectronicDevice findMostPowerConsumingElectronicDevice() {
        // check empty list
        if ( devices.isEmpty() ) {
            throw new IllegalStateException("Ship has no devices, there can't be a maximum in an empty collection" );
        }
        return Collections.max(this.devices, this.wattComparator);
    }

    /**
     * Removes device from this <code>ArrayList devices</code> that has a higher power consumption
     * than the specified static value <code>MAXIMUM_POWER_CONSUMPTION</code>.
     *
     * @see #devices
     * @see #MAXIMUM_POWER_CONSUMPTION
     */
    public void removePowerConsumingElectronicDevice() {
        devices.removeIf(
                new Predicate<ElectronicDevice>() {
                    @Override
                    public boolean test(ElectronicDevice electronicDevice) {
                        return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
                    }
                }
        );
    }

    /**
     * Adds one device to this <code>ArrayList devices</code> and sorts the <code>ArrayList</code>
     * with the <code>compare</code> method of <code>ElectronicDeviceWattComparator</code>.
     *
     * @param device the device to add this <code>devices</code>
     * @see #devices
     * @see ElectronicDevice
     * @see ElectronicDeviceWattComparator#compare(ElectronicDevice device1, ElectronicDevice device2)
     */
    public void load(ElectronicDevice device) {
//        Objects.requireNonNull(device);
        if(device instanceof Radio radio) {
            if (radio.getVolume() < 1) return; // fail-fast method better here
            System.out.println("Remember to pay license fee!");
        }
        this.devices.add(device);
        this.devices.sort(wattComparator);
    }

    /**
     * Adds one or more devices to this <code>devices</code> using this <code>load</code> method from before
     * calling it as many times as there are devices in the given parameter with an <code>extended for-loop</code>.
     *
     * @param devices the vararg list that contains one or more devices
     * @see #devices
     * @see #load(ElectronicDevice device)
     */
    public void loads(ElectronicDevice... devices) {
        for (ElectronicDevice device : devices) {
            load(device);
        }
    }

    /**
     * Counts the number of devices in <code>devices</code> that are on.
     *
     * @return the total number of devices that are on
     */
    public int countDevicesSwitchedOn() {
        int countRadiosOn = 0;
        for (ElectronicDevice device : devices) {
            countRadiosOn = device.isOn() ? countRadiosOn + 1 : countRadiosOn;
        }
        return countRadiosOn;
    }


    /**
     * Switches all devices in <code>devices</code> off, by calling their inherited method <code>off</code> from <code>ElectronicDevice</code>.
     * <p></p>
     * Some devices stay on, like <code>Firebox</code> that <code>overrides</code> the <code>off</code> method from <code>ElectronicDevice</code>.
     *
     * @see #devices
     * @see ElectronicDevice#off()
     * @see Firebox
     */
    public void holiday() {
        for (ElectronicDevice device : devices) {
            device.off(); // will either call the overridden method of the superclass or the inherited method of the superclass, if no changes were made
            // Electronic device = new Radio() -> device.off() -> off() overridden to do nothing
        }
    }


    /**
     * Prints a <code>String</code> with all the devices of this <code>devices</code>.
     *
     * @return a <code>String</code> with all the devices in <code>devices</code>
     * @see #devices
     */
    @Override
    public String toString() {
        return "Ship{" +
                "devices=" + devices +
                '}';
    }
}