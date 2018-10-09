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
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;

/**
 *
 * @author andre
 */
public class MainClass {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Started application!");
        
        
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #3 (Pin 22 BCM) as an output pin
        final GpioPinDigitalOutput pinLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Blue-LED", PinState.LOW);

        // set input pin #00 (Pin 17 BCM)
        GpioPinDigitalInput inputPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);
        inputPin.setShutdownOptions(true);
        
        // create a gpio control trigger on the input pin ; when the input goes HIGH, also set gpio pin #03 to High and vice versa
        inputPin.addTrigger(new GpioSetStateTrigger(PinState.HIGH, pinLed, PinState.HIGH));
        inputPin.addTrigger(new GpioSetStateTrigger(PinState.LOW, pinLed, PinState.LOW));
        
        
        
        
        System.out.println("Run program for 1 more minute, then terminate!");
        Thread.sleep(60_000);
        
        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Shut down application!");
        
    }
    
}
