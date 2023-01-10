package org.example.javadoc;

// interface static methods, default methods
// 8.1.11

/**
 * <code>Distance</code> is an interface giving abstract methods that need to be implemented later by the implementing classes and static methods.
 */
public interface Distance {
    static Distance ofMeter(int value) {
        return new DistanceImplementation(value);
    }

    static Distance ofKilometer(int value) {
        return new DistanceImplementation(value * 1000);
    }

    int meter();

    default int kilometer() {
        return meter() / 1000;
    }
}
