/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import java.util.Observable;

/**
 *
 * @author mxa3265
 */
public class WeatherStation extends Observable implements Runnable{
    
    private final KelvinTempSensor sensor;
    private final long PERIOD = 1000;
    final int KTOC = -27315;
    
    private int currentReading;
    
    public enum Temperature {
        CELZIUS, KELVIN
    }
    
    public WeatherStation(){
        sensor = new KelvinTempSensor();
    }
     
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(PERIOD);
            }
            catch(InterruptedException e){
            }
            currentReading = sensor.reading();
            setChanged();
            this.getTemperature(Temperature.CELZIUS, currentReading );
            notifyObservers();
        }
    }
    
    public synchronized double getTemperature(Temperature type, int reading){
        double tempVal = 0;
        switch(type){
            case CELZIUS:
                
                break;
            case KELVIN:
                
                break;
        }
        return tempVal;
    }
    
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        TextUI ui = new TextUI(ws);
        Thread thread = new Thread(ws);
        thread.start();
    }
    
} 

