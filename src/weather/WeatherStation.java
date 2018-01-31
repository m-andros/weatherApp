/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import java.util.*;
import weather.ConverterMap.MeasureUnits; 

/**
 *
 * @author mxa3265
 */
public class WeatherStation extends Observable implements Runnable{
    
    private final KelvinTempSensor sensor;
    private final Barometer barometer;
    private final long PERIOD = 1000; 
    private int currentReadingTemp;
    private double currentReadingBar;
    EnumMap<MeasureUnits, Values> map;
    
    public WeatherStation(){
        sensor = new KelvinTempSensor();
        barometer = new Barometer();
        map = (new ConverterMap()).getMap();
    }
    
    /**
     * This an conversion method that takes in the reading from the sensor as it's parameter
     * and then uses the values stored in the specific enum and it's divisor constant
     * to calculate the correct and current temperature in celsius or in kelvin
     * @param reading is an input value from the actual sensor that is passed here for the calculation
     * @return the finalized  temperature of the given enum, celsius or kelvin
     */
    private double convertFunction(double reading, Values value){
        return (reading + value.getConversionConstant()) * value.getDivisor() + value.getReductionConstant();
    }
    
    public double getTempValue(MeasureUnits unit){
        Values v = map.get(unit);
        return convertFunction(currentReadingTemp*1.0, v);
    }
    
    public double getPressureValue(MeasureUnits unit){
        Values v = map.get(unit);
        return convertFunction(currentReadingBar*1.0, v);
    }
     
    @Override
    public void run() { 
        while(true){
            try{
                Thread.sleep(PERIOD);
            }
            catch(InterruptedException e){
            }
            currentReadingTemp = sensor.reading();
            currentReadingBar = barometer.pressure();
            
            setChanged(); 
            notifyObservers();
        }
    } 
} 

