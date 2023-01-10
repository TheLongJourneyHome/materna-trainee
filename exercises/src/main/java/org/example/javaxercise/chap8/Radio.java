package org.example.javaxercise.chap8;

import java.util.Objects;

public class Radio extends ElectronicDevice {

    // constructors
    public Radio() {
    }

    public Radio(double frequency) {
        setFrequency(frequency);
    }

    public Radio(String stationName) {
//        this.frequency = stationNameToFrequency(stationName);
        this(stationNameToFrequency(stationName));
    }

    // copy-constructor
    public Radio( Radio other ) {
        setFrequency( other.frequency );
        setModulation( other.getModulation() );
        if ( other.isOn() ) on(); else off();
        setVolume(other.getVolume()); // this.volume = other.volume
    }


    private static final double WALKING_THE_PLANK = 98.3;
    private int volume;
    private double frequency;

    private Modulation modulation = Modulation.AM; // start value, else null
    private double minFrequency;
    private double maxFrequency;





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
    }

    public void volumeDown() {
        changeVolume(-1);
    }

    public int getVolume() {
        return volume;
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

    @Override
    public String toString() {
        return "Radio{" +
                "volume=" + volume +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                ", minFrequency=" + minFrequency +
                ", maxFrequency=" + maxFrequency +
                "} " + super.toString();
    }
}
