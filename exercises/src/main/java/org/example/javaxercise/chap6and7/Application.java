package org.example.javaxercise.chap6and7;

public class Application {
    public static void main(String[] args) {
        // 1.1.2
/*        Radio grandmasOldRadio = new Radio();
        System.out.println( grandmasOldRadio.isOn() );     // false
        grandmasOldRadio.on();
        System.out.println( grandmasOldRadio.isOn() );     // true
        System.out.println( grandmasOldRadio.volume );     // 0
        grandmasOldRadio.volumeUp();
        grandmasOldRadio.volumeUp();
        grandmasOldRadio.volumeDown();
        grandmasOldRadio.volumeUp();
        System.out.println( grandmasOldRadio.volume );     // 2
        grandmasOldRadio.volumeDown();
        grandmasOldRadio.volumeDown();
        grandmasOldRadio.volumeDown(); // -1 -> 0
        System.out.println( grandmasOldRadio.volume );
        System.out.println( grandmasOldRadio.toString() ); // Radio[volume=2, is on]
        System.out.println( grandmasOldRadio );            // Radio[volume=2, is on]
        grandmasOldRadio.off();
        System.out.println( grandmasOldRadio );*/
        // 1.2.1
/*        System.out.println( Radio.stationNameToFrequency( "Walking the Plank" ) ); // 98.3
        System.out.println( Radio.stationNameToFrequency( "Walking the Planks" ) ); // 0.0
        System.out.println( Radio.stationNameToFrequency( null ) ); // 0.0*/
        // 1.2.2
/*        Tracer.on();
        Tracer.trace( "Start" );
        int i = 2;
        Tracer.off();
        Tracer.trace( "i = " + i );
//  Tracer.trace( "i = %d", i );
        Tracer.on();
        Tracer.trace( "End" );
        // optional format testing
        Tracer.trace("Hello I'm %d years old and my name is %s", 26, "Long");*/
        // 1.4.1
/*        Radio r1 = new Radio();
        Radio r2 = new Radio( 102. );
        Radio r3 = new Radio( "BFBS" );
        Radio r4 = new Radio(r2);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);*/
        // 1.5.1
/*        TV tv1 = new TV();
        tv1.on();
        tv1.off();*/
        // 1.5.2 ArrayList
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Radio r1 = new Radio(77.7);
        Radio r2 = new Radio("walking the plank");
        Radio r3 = new Radio("walking the dead");
        Radio r4 = new Radio();
        Radio r5 = new Radio(r1); // "The radio is off"

        r1.on();
        r5.on();
        r2.on();
        r3.on();
        r3.off();
        ship1.load(r1);
        ship1.load(r3);
        ship1.load(r4);
        ship2.loads(r2, r5);

        System.out.println(ship1);
        System.out.println(ship1.countDevicesSwitchedOn());
        System.out.println(ship2);
        System.out.println(ship2.countDevicesSwitchedOn());
    }
}
