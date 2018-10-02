/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift.goblin.pi4jtestapplication;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author andre
 */
public class MainClass {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Started application!");
        
        
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #24 (Pin 19 BCM) as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "Blue-LED", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("lights for 5s on!");
        pin.high();

        Thread.sleep(5000);

        System.out.println("lights off!");
        pin.low();
        
        // flash the led 10 times for 1/4 second
        System.out.println("disco disco!");
        for (int i = 0; i < 10; i++) {
            pin.pulse(250, true); // set second argument to 'true' use a blocking call
            Thread.sleep(100);
        }

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Shut down application!");
        
    }
    
}
