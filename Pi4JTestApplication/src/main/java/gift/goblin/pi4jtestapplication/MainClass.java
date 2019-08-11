/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift.goblin.pi4jtestapplication;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.wiringpi.GpioUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class MainClass {

    private static final int PIN_NO_BUTTON_MAINTENANCE = 1;
    private static final int PIN_NO_BUTTON_TARE = 2;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Started application!");

        new MainClass().doWork();

        System.out.println("Shut down application!");
    }

    public void doWork() throws InterruptedException {

        final GpioPinDigitalInput pinHXDAT;
        final GpioPinDigitalOutput pinHXCLK;
        final HX711 hx;

        GpioUtil.enableNonPrivilegedAccess();

        GpioController gpio = GpioFactory.getInstance();

        GpioPinDigitalInput pinMaintenance = gpio.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_BUTTON_MAINTENANCE),
                "Button maintenance", PinPullResistance.PULL_DOWN);
        
        GpioPinDigitalInput pinTare = gpio.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_BUTTON_TARE),
                "Button tare", PinPullResistance.PULL_DOWN);
        
        
        pinMaintenance.addTrigger(new GpioCallbackTrigger(PinState.HIGH,
                new MaintenanceTrigger(pinMaintenance)));
        
        pinTare.addTrigger(new GpioCallbackTrigger(PinState.HIGH,
                new MaintenanceTrigger(pinTare)));
        
//        pinMaintenance.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                // display pin state on console
//                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
//
//                // If button is pressed, start measuring how long
//                if (event.getState() == PinState.HIGH) {
//
//                    long duration;
//                    for (duration = 0; duration < 3000; duration += 50) {
//                        if (event.getState() == PinState.LOW) {
//                            break;
//                        } else {
//                            try {
//                                Thread.sleep(50);
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(MainClass.class.getName()).log(Level.WARNING, null, ex);
//                            }
//                        }
//                    }
//
//                    if (duration >= 3000) {
//                        System.out.println("Button was pressed at least 3s");
//                    } else {
//                        System.out.println("Button was pressed only mS: " + duration);
//                    }
//
//                }
//
//            }
//
//        }
//        );

        while (true) {
            Thread.sleep(50);
        }
    }

}
