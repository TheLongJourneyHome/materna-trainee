package org.example.javaxercise.chap6and7;

import java.util.Objects;

// classes
// Konstruktorweiterschaltung mit this(...)
public class Radio {

    // constructors
    public Radio() {
    }

    public Radio(double frequency) {
        setFrequency(frequency);
    }

    // reuse Radio(double frequency)
    //  "this" keyword refers to the current instance of the class and is used to access members of the current object from within the body of the class.
    //  You can use the this keyword to call another constructor of the same class in a constructor with a construct called "constructor chaining".
    //  This can be done using the this keyword followed by a call to another constructor and passing the necessary arguments.
    // It's worth noting that the call to the other constructor must be the first statement in the constructor, otherwise you will get a compilation error.
    public Radio(String stationName) {
//        this.frequency = stationNameToFrequency(stationName);
        this(stationNameToFrequency(stationName)); // -> in Radio(double frequency)
    }

    // copy-constructor
    public Radio( Radio other ) {
        setFrequency( other.frequency );
        setModulation( other.getModulation() );
        if ( other.isOn() ) on(); else off();
        setVolume(other.getVolume()); // this.volume = other.volume
    }


    private static final double WALKING_THE_PLANK = 98.3;
    private boolean isOn;
    private int volume;
    private double frequency;

    private Modulation modulation = Modulation.AM; // start value, else null
    private double minFrequency;
    private double maxFrequency;


    @Override
    public String toString() {
        return "Radio{" +
                "isOn=" + isOn +
                ", volume=" + volume +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }


    public void setModulation(Modulation modulation) {
        this.modulation = Objects.requireNonNull(modulation);
        if (modulation == Modulation.AM) {
            minFrequency = 148.5; // -> kHz
            maxFrequency = 26100.0; // if 26000 % 1000 > 0 -> 26100 / 1000 -> 26.1 MHz
        } else if (modulation == Modulation.FM) {
            minFrequency = 87500.0; // 87.5 MHz
            maxFrequency = 108000.0; // 108.0 MHz
        }
    }

    public Modulation getModulation() {
        return modulation;
    }


    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }

    private void changeVolume(int value) {
        int a = Math.max(volume + value, 0); // never smaller 0
        volume = Math.min(a, 100); // never greater 100, (a <= 100) ? a : 100
    }

    public void volumeUp() {
        changeVolume(1);
//        volume = volume + 1 > 100 ? volume : volume + 1;
    }

    public void volumeDown() {
        changeVolume(-1);
//        volume = volume - 1 < 0 ? volume : volume - 1;
    }

    public int getVolume() {
        return volume;
    }


    public void on() {
        isOn = true;
        System.out.println("The radio is on");
    }

    public void off() {
        isOn = false;
        System.out.println("The radio is off");
    }

/*    public void setOn(boolean on) {
        isOn = on;
    }*/

    public boolean isOn() {
        return isOn;
    }


    public static double stationNameToFrequency(String stationName) {
        if (stationName == null) {
            return 0.0;
        }
        return switch (stationName.toLowerCase()) {
            case "walking the plank" -> WALKING_THE_PLANK;
            default -> 0.0;
        };
    }
}
