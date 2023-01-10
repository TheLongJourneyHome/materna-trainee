package org.example.javadoc;

import java.util.Comparator;

/**
 * <code>ElectronicDeviceWattComparator</code> implements from the <code>Comparator Interface</code> and will be used
 * for the sorting of the <code>ArrayList</code> in <code>Ship</code>.
 *
 * @author Long
 * @see Comparator
 * @see Ship
 */
public class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {

    /**
     * The <code>compare</code> method that will be used in the <code>load</code> method for sorting inside the <code>Ship</code> class.
     * This method compares two <code>ElectronicDevice</code> objects and returns the objects number with the bigger number.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the number of the object that is bigger
     * @see Ship#load(ElectronicDevice device)
     * @see ElectronicDevice
     */
    @Override
    public int compare(ElectronicDevice o1, ElectronicDevice o2) {
//        System.out.printf("Comparing %s and %s, result is: %d %n", o1, o2, Integer.compare(o1.getWatt(), o2.getWatt()));
        return Double.compare(o1.getWatt(), o2.getWatt());
    }
}
