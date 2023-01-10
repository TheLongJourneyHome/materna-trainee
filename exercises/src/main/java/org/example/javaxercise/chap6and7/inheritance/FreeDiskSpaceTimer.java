package org.example.javaxercise.chap6and7.inheritance;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

// abstract class and methods
public class FreeDiskSpaceTimer extends TimerTask {
//    private static final long MINIMUM_SPACE = 1_000_000_000L; // Bytes -> 1000 MB
    private static final long MINIMUM_SPACE = 1_000_000_000_000_000L; // Bytes -> 1000 TB for testing and displaying in the tray
    private static final long TIMER_DELAY = 2_000L; // Milliseconds -> 2 seconds
    private static boolean iconDisplayedOnce = false;

    @Override
    public void run() {
        long freeDiskSpace = java.io.File.listRoots()[0].getFreeSpace();

        if (freeDiskSpace < MINIMUM_SPACE) {

            if (!iconDisplayedOnce) { // flag so it doesn't spam the tray -> can set it to false again after some time, if we want to display it at some point again
                try {
                    String url =
                            "https://cdn4.iconfinder.com/data/icons/common-toolbar/36/Save-16.png";
                    ImageIcon icon = new ImageIcon( new URL( url ) );
                    TrayIcon trayIcon = new TrayIcon( icon.getImage() );
                    SystemTray.getSystemTray().add( trayIcon );

                    trayIcon.displayMessage( "Achtung", "Platte voll", TrayIcon.MessageType.INFO );

                    iconDisplayedOnce = true;
                }
                catch ( Exception e ) { e.printStackTrace(); }
            }

            System.out.printf("There is not enough free space in your disk. Free space left: %s %n", freeDiskSpace);

        } else {
            System.out.println("Enough space left.");
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        FreeDiskSpaceTimer freeDiskSpaceTimer = new FreeDiskSpaceTimer();
        timer.schedule(freeDiskSpaceTimer, 0, TIMER_DELAY);

    }
}


// solution
/*
//tag::solution[]
public class FreeDiskSpaceTimer {
    public static void main( String[] args ) {
        final int REPETITION_PERIOD = 2000 */
/* ms *//*
;
        new Timer().schedule( new FreeDiskSpaceTimerTask(), 0, REPETITION_PERIOD );
    }
}

class FreeDiskSpaceTimerTask extends TimerTask {
    private static final long MIN_CAPACITY = 100_000_000_000L;
    private final File root = File.listRoots()[ 0 ];

    @Override public void run() {
        long freeDiskSpace = root.getFreeSpace();
        if ( freeDiskSpace < MIN_CAPACITY )
            System.out.printf(
                    "Device %s has less than %,d byte available, currently %,d byte%n",
                    root, MIN_CAPACITY, freeDiskSpace );
    }
}
//end::solution[]*/
