package org.example.javaxercise.chap6and7.inheritance;

public class Application {
    public static void main(String[] args) {
        // 1.5.2 ArrayList
/*        Ship ship1 = new Ship();
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
        System.out.println(ship2.countDevicesSwitchedOn());*/
        // 1.6.2. Inheritance
/*        Radio radio = new Radio();
        radio.on();
        System.out.println( radio );
        IceMachine ice_o_matic = new IceMachine();
        ice_o_matic.on();*/
        // 1.6.6
/*        Firebox fb = new Firebox();
//        fb.on(); // inside parameterless constructor code block
        System.out.println( fb.isOn() );  // true
        fb.off();
        System.out.println( fb.isOn() );  // true*/
        // 1.6.7
/*        Radio r1 = new Radio("walking the plank");
        r1.on();
        for (int i = 0; i < 52; i++) {
            r1.volumeUp();
        }
        r1.setModulation(Modulation.FM);
        System.out.println(r1);*/

        // 1.7.1
        Radio bedroomRadio = new Radio();
        bedroomRadio.volumeUp(); // add
        Radio cabooseRadio = new Radio();
        cabooseRadio.volumeUp(); // add
        TV mainTv = new TV(); // add -> tube off as well when turned off
        Radio crRadio = new Radio(); // not added because volume = 0
        Firebox alarm = new Firebox(); // add, but can't be turned off, already assigned on when created
        Ship ship = new Ship();
        ship.load( bedroomRadio );
        ship.load( cabooseRadio );
        ship.load( mainTv );
        ship.load( crRadio );
        ship.load( alarm );
        ship.holiday();
//        Device is on -> Firebox on and loaded
//        Remember to pay license fee! -> bedroomRadio loaded
//        Remember to pay license fee! -> cabooseRadio loaded
//        Device is off -> bedroomRadio off
//        Device is off -> cabooseRadio off
//        Device is off -> TV off
//        Tube is off -> Tube also off when TV is off
    }
}
