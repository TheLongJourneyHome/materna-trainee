package org.example.javaxercise.chap8;

import org.example.javadoc.ElectronicDevice;
import org.example.javadoc.ElectronicDeviceWattComparator;
import org.example.javadoc.Radio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

public class Ship {
    private final ArrayList<org.example.javadoc.ElectronicDevice> devices = new ArrayList<org.example.javadoc.ElectronicDevice>();
    private final org.example.javadoc.ElectronicDeviceWattComparator wattComparator = new ElectronicDeviceWattComparator(); //   private final static ElectronicDeviceWattComparator ELECTRONIC_DEVICE_WATT_COMPARATOR = new ElectronicDeviceWattComparator(); -> will stay constant / static!
    private final int MAXIMUM_POWER_CONSUMPTION = 3000;



    // 1.1.5 predicate?
    // solution
/*    //tag::solution2[]
    private final static int MAXIMUM_POWER_CONSUMPTION = 1000;

    public void removePowerConsumingElectronicDevices() {
        class IsPowerConsumingElectronicDevice
                implements Predicate<ElectronicDevice> {
            @Override public boolean test( ElectronicDevice electronicDevice ) {
                return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
            }
        }
        devices.removeIf( new IsPowerConsumingElectronicDevice() );
    }
    //end::solution2[]*/

    public void removePowerConsumingElectronicDevice() {
        devices.removeIf(
                new Predicate<org.example.javadoc.ElectronicDevice>() {
                    @Override
                    public boolean test(org.example.javadoc.ElectronicDevice electronicDevice) {
                        return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
                    }
                }
        );
    }

    public org.example.javadoc.ElectronicDevice findMostPowerConsumingElectronicDevice() {
        // check empty list
        if ( devices.isEmpty() ) {
            throw new IllegalStateException("Ship has no devices, there can't be a maximum in an empty collection" );
        }
        return Collections.max(this.devices, this.wattComparator);
    }


    public void loads(org.example.javadoc.ElectronicDevice... devices) {
        for (org.example.javadoc.ElectronicDevice device : devices) {
            load(device);
        }
    }

    public void load(org.example.javadoc.ElectronicDevice device) {
        Objects.requireNonNull(device);
        if(device instanceof Radio radio) {
            if (radio.getVolume() < 1) return; // fail-fast method better here
            System.out.println("Remember to pay license fee!");
        }
        this.devices.add(device);
        this.devices.sort(wattComparator); // 1.1.3 sort List
    }

    public int countDevicesSwitchedOn() {
        int countRadiosOn = 0;
        for (org.example.javadoc.ElectronicDevice device : devices) {
            countRadiosOn = device.isOn() ? countRadiosOn + 1 : countRadiosOn;
        }
        return countRadiosOn;
    }

    // 7.5.
    public void holiday() {
        for (ElectronicDevice device : devices) {
            device.off(); // will either call the overridden method of the superclass or the inherited method of the superclass, if no changes were made
            // Electronic device = new Radio() -> device.off() -> off() overridden to do nothing
        }
    }


    @Override
    public String toString() {
        return "Ship{" +
                "devices=" + devices +
                '}';
    }
}


// solution power consumption
/*
public class Ship {

    private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

    public void load( ElectronicDevice device ) {
        devices.add( device );
    }

    //tag::solution1[]
    public ElectronicDevice findMostPowerConsumingElectronicDevice() {
        if ( devices.isEmpty() )
            throw new IllegalStateException(
                    "Ship has no devices, there can't be a maximum in an empty collection" );
        return Collections.max( devices, new ElectronicDeviceWattComparator() );
    }
    //end::solution1[]

    //tag::solution2[]
    private final static int MAXIMUM_POWER_CONSUMPTION = 1000;

    public void removePowerConsumingElectronicDevices() {
        class IsPowerConsumingElectronicDevice
                implements Predicate<ElectronicDevice> {
            @Override public boolean test( ElectronicDevice electronicDevice ) {
                return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
            }
        }
        devices.removeIf( new IsPowerConsumingElectronicDevice() );
    }
    //end::solution2[]
}*/
