package org.example.javadoc;

/**
 * <code>MonitorTube</code> is a class that will be only called, when there is a <code>TV</code> object.
 * It will only call its methods whenever its assigned <code>TV</code> will be turned on or off as well.
 *
 * @author Long
 * @see TV
 */
public class MonitorTube {
    private final TV tv;
    public MonitorTube(TV tv) { // constructor
        this.tv = tv;
    }
    public TV getTV() {
        return tv;
    }


    /**
     * Called when its <code>TV</code> object is turned on.
     *
     * @see TV#on()
     */
    public void on() {
        System.out.println("Tube is on");
    }
    /**
     * Called when its <code>TV</code> object is turned off.
     *
     * @see TV#off()
     */
    public void off() {
        System.out.println("Tube is off");
    }
}
