package org.example.javaxercise.chap6and7.inheritance;

import java.util.ArrayList;
import java.util.Objects;

// ArrayList -> Array of Objects
// 1:n association
// instanceof
public class Ship {
    private final ArrayList<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();


    public void loads(ElectronicDevice... devices) {
        // this.radios.addAll(Arrays.asList(radios));
        for (ElectronicDevice device : devices) {
            load(device);
        }
    }

    public void load(ElectronicDevice device) {
        Objects.requireNonNull(device);
/*        if(device instanceof Radio radio) {
            if (radio.getVolume() > 0) {
                System.out.println("Remember to pay license fee!");
            } else {
                return; // radio with volume = 0 won't be loaded
            }
        }*/
        if(device instanceof Radio radio) {
            if (radio.getVolume() < 1) return; // fail-fast method better here
            System.out.println("Remember to pay license fee!");
        }
        this.devices.add(device);
    }

    public int countDevicesSwitchedOn() {
        int countRadiosOn = 0;
        for (ElectronicDevice device : devices) {
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
