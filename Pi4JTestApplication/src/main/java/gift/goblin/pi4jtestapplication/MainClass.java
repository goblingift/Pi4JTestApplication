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
import gift.goblin.hx711.GainFactor;
import gift.goblin.hx711.Hx711;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class MainClass {

    private static final int PIN_NO_LOAD_CELL_1_DAT = 15;
    private static final int PIN_NO_LOAD_CELL_1_SCK = 16;
    private static final int PIN_NO_LOAD_CELL_2_DAT = 4;
    private static final int PIN_NO_LOAD_CELL_2_SCK = 5;
    private static final int PIN_NO_LOAD_CELL_3_DAT = 6;
    private static final int PIN_NO_LOAD_CELL_3_SCK = 10;
    private static final int PIN_NO_LOAD_CELL_4_DAT = 11;
    private static final int PIN_NO_LOAD_CELL_4_SCK = 31;
    
    // Pins for the load cells
    private GpioPinDigitalInput pinLoadCell1Dat;
    private GpioPinDigitalOutput pinLoadCell1Sck;
    private GpioPinDigitalInput pinLoadCell2Dat;
    private GpioPinDigitalOutput pinLoadCell2Sck;
    private GpioPinDigitalInput pinLoadCell3Dat;
    private GpioPinDigitalOutput pinLoadCell3Sck;
    private GpioPinDigitalInput pinLoadCell4Dat;
    private GpioPinDigitalOutput pinLoadCell4Sck;
    
    private Hx711 hx711LoadCell1;
    private Hx711 hx711LoadCell2;
    private Hx711 hx711LoadCell3;
    private Hx711 hx711LoadCell4;
    
    GpioController gpioController = GpioFactory.getInstance();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Started application!");

        new MainClass().doWork();

        System.out.println("Shut down application!");
    }
    
    private void initializeSensors() {
        pinLoadCell1Dat = gpioController.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_1_DAT),
                "Load-cell 1 DAT", PinPullResistance.OFF);
        pinLoadCell1Sck = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_1_SCK),
                "Load-cell 1 SCK", PinState.LOW);
        hx711LoadCell1 = new Hx711(pinLoadCell1Dat, pinLoadCell1Sck, 500, 2.0, GainFactor.GAIN_128);

        pinLoadCell2Dat = gpioController.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_2_DAT),
                "Load-cell 2 DAT", PinPullResistance.OFF);
        pinLoadCell2Sck = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_2_SCK),
                "Load-cell 2 SCK", PinState.LOW);
        hx711LoadCell2 = new Hx711(pinLoadCell2Dat, pinLoadCell2Sck, 500, 2.0, GainFactor.GAIN_128);

        pinLoadCell3Dat = gpioController.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_3_DAT),
                "Load-cell 3 DAT", PinPullResistance.OFF);
        pinLoadCell3Sck = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_3_SCK),
                "Load-cell 3 SCK", PinState.LOW);
        hx711LoadCell3 = new Hx711(pinLoadCell3Dat, pinLoadCell3Sck, 500, 2.0, GainFactor.GAIN_128);

        pinLoadCell4Dat = gpioController.provisionDigitalInputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_4_DAT),
                "Load-cell 4 DAT", PinPullResistance.OFF);
        pinLoadCell4Sck = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(PIN_NO_LOAD_CELL_4_SCK),
                "Load-cell 4 SCK", PinState.LOW);
        hx711LoadCell4 = new Hx711(pinLoadCell4Dat, pinLoadCell4Sck, 500, 2.0, GainFactor.GAIN_128);
    }

    // endless worker
    public void doWork() throws InterruptedException {
        while (true) {
            
            
            
            
            
            
            
            
            
            
            
            
            
            // sleep 1 minute
            Thread.sleep(1000 * 60);
        }
    }

}
