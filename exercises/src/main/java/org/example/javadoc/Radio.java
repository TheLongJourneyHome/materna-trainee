package org.example.javadoc;

import java.util.Objects;

/**
 * <code>Radio</code> is an electronic device that extends from <code>ElectronicDevice</code>.
 * This electronic device has more variables and methods to offer than the base class <code>ElectronicDevice</code>.
 *
 * @author Long
 * @see ElectronicDevice
 */
public class Radio extends ElectronicDevice {

    /**
     * The empty <code>constructor</code> that takes no arguments to build a <code>Radio</code> object.
     */
    public Radio() {
    }
    /**
     * The <code>constructor</code> that takes a <code>double</code> argument to build a <code>Radio</code> object.
     * This <code>frequency</code> parameter will set this <code>frequency</code> variable inside this class
     *
     * @param frequency the double value that this <code>frequency</code> will take the value from with <code>setFrequency</code>
     * @see Double
     * @see #frequency
     * @see #setFrequency(double frequency)
     */
    public Radio(double frequency) {
        setFrequency(frequency);
    }
    /**
     * The <code>constructor</code> that takes a <code>String</code> argument to build a <code>Radio</code> object.
     * This <code>stationName</code> parameter that is a <code>String</code> will set this <code>frequency</code> variable inside this class,
     * by calling the <code>stationNameToFrequency</code> method inside this class.
     *
     * @param stationName the String value that this <code>frequency</code> will take the value from with <code>stationNameToFrequency</code>
     * @see String
     * @see #frequency
     * @see #stationNameToFrequency(String stationName)
     */
    public Radio(String stationName) {
//        this.frequency = stationNameToFrequency(stationName);
        this(stationNameToFrequency(stationName));
    }

    /**
     * The <code>constructor</code> that copies another <code>Radio</code> object to create this <code>Radio</code> object.
     * This will copy all the values from the other <code>Radio</code> object inside here, by calling several methods to set the values.
     *
     * @param other the Radio object that will be copied
     * @see Radio
     * @see #setFrequency(double frequency)
     * @see #setModulation(Modulation modulation)
     * @see ElectronicDevice#isOn()
     * @see #setVolume(int volume)
     */
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


    /**
     * Sets this <code>modulation</code> value inside the class with the given argument <code>modulation</code>.
     * <p>
     * Depending on the modulation set, this <code>minFrequency</code> and this <code>maxFrequency</code> will vary.
     *
     * @param modulation the Modulation value that will be set in this <code>modulation</code>
     * @see Modulation
     * @see #modulation
     * @see #minFrequency
     * @see #maxFrequency
     */
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

    // simple doesn't need javadoc, javadoc is optional here
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

    /**
     * Changes this <code>volume</code> by the value inside the parameter.
     *
     * @param value the Integer value by that this <code>volume</code> will be added or substracted with
     * @see #volume
     * @see Integer
     */
    private void changeVolume(int value) {
        int a = Math.max(volume + value, 0); // never smaller 0
        volume = Math.min(a, 100); // never greater 100, (a <= 100) ? a : 100
    }


    /**
     * Calls this <code>changeVolume</code> method with +1.
     *
     * @see #changeVolume(int value)
     */
    public void volumeUp() {
        changeVolume(1);
    }
    /**
     * Calls this <code>changeVolume</code> method with -1.
     *
     * @see #changeVolume(int value)
     */
    public void volumeDown() {
        changeVolume(-1);
    }

    public int getVolume() {
        return volume;
    }

    /**
     * Converts the given <code>String</code> to <code>double</code>.
     *
     * @param stationName the <code>String</code> parameter that will be used to get a <code>double</code> value
     * @return the <code>double</code> value depending on the given <code>String</code>
     */
    public static double stationNameToFrequency(String stationName) {
        if (stationName == null) {
            return 0.0;
        }
        return switch (stationName.toLowerCase()) {
            case "walking the plank" -> WALKING_THE_PLANK;
            default -> 0.0;
        };
    }

    /**
     * Prints a <code>String</code> of this radio and its values.
     * <p>
     * The values that will be printed are this <code>volume</code>, this <code>frequency</code>, this <code>modulation</code>,
     * this <code>minFrequency</code> and this <code>maxFrequency</code>.
     * It will also call the <code>toString</code> method from the superclass and prints its <code>String</code>.
     *
     * @return the <code>String</code> of the radio device that calls this method and with its values
     * @see #volume
     * @see #frequency
     * @see #modulation
     * @see #minFrequency
     * @see #maxFrequency
     * @see ElectronicDevice#toString()
     */
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
