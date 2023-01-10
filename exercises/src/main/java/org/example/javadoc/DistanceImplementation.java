package org.example.javadoc;


/**
 * <code>DistanceImplementation</code> is a class that implements from <code>Distance</code>.
 * This class will accept values and calls its implemented methods to return the value, that is either meters or kilometers
 * to meters and kilometers.
 *
 * @see Distance
 */
public class DistanceImplementation implements Distance {
    int distance; // can be private final


    public DistanceImplementation(int distance) {
        this.distance = distance;
    }

    @Override
    public int meter() {
        return distance;
    }
}
