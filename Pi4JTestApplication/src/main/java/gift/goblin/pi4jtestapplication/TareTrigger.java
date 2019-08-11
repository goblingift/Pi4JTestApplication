/*
 * Copyright (C) 2019 Andre Kessler (https://github.com/goblingift)
 * All rights reserved
 */
package gift.goblin.pi4jtestapplication;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import java.util.concurrent.Callable;

/**
 * Trigger for setting the tare of the load-cells.
 * @author andre
 */
public class TareTrigger extends AbstractTrigger implements Callable<Void> {


    public TareTrigger(GpioPinDigitalInput pinButtonTare) {
        super(pinButtonTare);
        
    }

    @Override
    public Void call() throws Exception {

        System.out.println("Tare button pressed");
        
        boolean longPressed = buttonWasPressed(3_000);

        if (longPressed) {
            System.out.println("longer than 3s");
        } else {
            System.out.println("shorter than 3s");
        }
        
        System.out.println("Tare button released");
        return null;
    }

}
