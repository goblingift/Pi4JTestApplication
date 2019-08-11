/*
 * Copyright (C) 2019 Andre Kessler (https://github.com/goblingift)
 * All rights reserved
 */
package gift.goblin.pi4jtestapplication;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import java.util.concurrent.Callable;

/**
 *
 * @author andre
 */
public class MaintenanceTrigger extends AbstractTrigger implements Callable<Void> {

    public MaintenanceTrigger(GpioPinDigitalInput pinButtonMaintenance) {
        super(pinButtonMaintenance);
        
    }

    @Override
    public Void call() throws Exception {

        System.out.println("Maintenance button pressed");
        
        boolean longPressed = buttonWasPressed(3_000);
        
        if (longPressed) {
            System.out.println("longer than 3s");
        } else {
            System.out.println("shorter than 3s");
        }
        
        System.out.println("Maintenance button released");
        return null;
    }

}
