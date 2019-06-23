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
import com.pi4j.wiringpi.GpioUtil;

/**
 *
 * @author andre
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Started application!");

        new MainClass().doWork();

        System.out.println("Shut down application!");
    }

    public void doWork() {

        final GpioPinDigitalInput pinHXDAT;
        final GpioPinDigitalOutput pinHXCLK;
        final HX711 hx;

        GpioUtil.enableNonPrivilegedAccess();

        GpioController gpio = GpioFactory.getInstance();
        pinHXDAT = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15, "HX_DAT", PinPullResistance.OFF);
        pinHXCLK = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "HX_CLK", PinState.LOW);

        hx = new HX711(pinHXDAT, pinHXCLK, 128);

        hx.read();
        System.out.println(hx.value);
        System.out.println(hx.weight);

    }

}
