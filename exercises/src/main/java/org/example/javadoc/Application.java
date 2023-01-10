package org.example.javadoc;

/**
 * <code>Application</code> class is used to test and run the different exercises here.
 *
 * @see <a href="http://tutego.de/javabuch/aufgaben/">exercises</a>
 */
public class Application {
    public static void main(String[] args) {
        // 1.1.1 (chapter 8)
/*        ElectronicDevice ea1 = new Radio(); ea1.setWatt( 200 );
        ElectronicDevice ea2 = new Radio(); ea2.setWatt( 20 );
        Comparator<ElectronicDevice> c = new ElectronicDeviceWattComparator();
        System.out.println( c.compare(ea1, ea2) );
        System.out.println( c.compare(ea2, ea1) );*/
        // 1.1.2
/*        Radio grannysRadio = new Radio();
        grannysRadio.volumeUp();
        grannysRadio.setWatt( 12_000 );

        TV grandpasTv = new TV();
        grandpasTv.setWatt( 1000 );

        Ship ship = new Ship();
        ship.load( grannysRadio );
        ship.load( grandpasTv );
        System.out.println( ship.findMostPowerConsumingElectronicDevice().getWatt() );*/
        // 1.1.4
        Distance oneKm = Distance.ofKilometer( 1 );
        System.out.printf( "1 km = %d km, %d m%n", oneKm.kilometer(), oneKm.meter() );

        Distance moreMeter = Distance.ofMeter( 12345 );
        System.out.printf( "12345 m = %d km, %d m", moreMeter.kilometer(), moreMeter.meter() );
    }
}
