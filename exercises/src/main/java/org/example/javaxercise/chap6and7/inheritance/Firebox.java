package org.example.javaxercise.chap6and7.inheritance;

// override
public class Firebox extends ElectronicDevice {

    public Firebox() {
        on();
    }

    @Override
    public void off() {
        // nothing happens here
    }
}
