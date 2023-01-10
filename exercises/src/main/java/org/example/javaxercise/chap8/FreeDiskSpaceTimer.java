package org.example.javaxercise.chap8;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

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
