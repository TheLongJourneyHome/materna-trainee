package org.example.javaxercise.chap6and7;

import java.util.ArrayList;
import java.util.Objects;

// ArrayList
// 1:n association
public class Ship {
    private final ArrayList<Radio> radios = new ArrayList<Radio>();
//    private final ArrayList<> electroDevices = new ArrayList<>(); // varargs -> loads(Objects... args)


    public void loads(Radio... radios) {
        // this.radios.addAll(Arrays.asList(radios));
        for (Radio radio : radios) {
            load(radio);
        }
    }

    public void load(Radio radio) {
        Objects.requireNonNull(radio);
        this.radios.add(radio);
    }

    public int countDevicesSwitchedOn() {
        int countRadiosOn = 0;
        for (Radio radio : this.radios) {
            countRadiosOn = radio.isOn() ? countRadiosOn + 1 : countRadiosOn;
        }
        return countRadiosOn;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "radios=" + radios +
                '}';
    }
}
