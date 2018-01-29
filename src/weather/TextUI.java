/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mxa3265
 */
public class TextUI implements Observer{
    private final WeatherStation station;
    
    public TextUI(WeatherStation station){
        this.station = station;
        this.station.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o != station){
            return;
        }
        System.out.printf("Celsius degrees is %6.2f and Kelvin degrees is %6.2f.%n", 320.23, 354.21);
    }
    
}
