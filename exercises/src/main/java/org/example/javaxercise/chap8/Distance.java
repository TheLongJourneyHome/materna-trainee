package org.example.javaxercise.chap8;

// interface static methods, default methods
// 8.1.11
public interface Distance {
    static Distance ofMeter(int value) {
        return new DistanceImplementation(value);
    }

    static Distance ofKilometer(int value) {
        return new DistanceImplementation(value * 1000);
    }

    int meter(); // return the int meter; Object(int meter) { this.meter = meter} constructor

    default int kilometer() {
        return meter() / 1000;
//        return ofKilometer();
    }
}
