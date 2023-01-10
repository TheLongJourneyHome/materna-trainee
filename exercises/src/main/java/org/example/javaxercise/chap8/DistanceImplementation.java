package org.example.javaxercise.chap8;

// interface
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
