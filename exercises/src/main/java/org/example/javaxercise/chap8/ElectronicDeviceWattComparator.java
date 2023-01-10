package org.example.javaxercise.chap8;

import java.util.Comparator;

public class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {

    @Override
    public int compare(ElectronicDevice o1, ElectronicDevice o2) {
        System.out.printf("Comparing %s and %s, result is: %d %n", o1, o2, Integer.compare(o1.getWatt(), o2.getWatt()));
        return Double.compare(o1.getWatt(), o2.getWatt()); // Integer.compare(...)?
    }
}
