package weather;

import java.util.Observable;
import java.util.Observer;

/**
 * TextUI class is used as a default GUI which is textually based and which prints
 * out the results in the editors console.
 * It implements and Observer class, so it has update method that is Overridden 
 * from the Observer class as well as it's own constructor.
 * @author mxa3265
 */
public class TextUI implements Observer{
    
    private final WeatherStation station; // constant for the WeatherStation object 
    
    /**
     * Constructor with parameters that initialises the WeatherStation object by 
     * assigning it to the passed parameter and adds created object TextUI to the list of Observers
     * @param station is a value of a WeatherStation object assigned to the station variable inside the TextUI
     */
    @SuppressWarnings("LeakingThisInConstructor")// this is added to ignore the warninf in the line 31 about the "leaking 'this' in the constructor"
    public TextUI(WeatherStation station){
        this.station = station;
        this.station.addObserver(this); // adding this object to the observer list
    }
    
    /**
     * update is a overridden method from the Observer interface
     * @param o used to checks if the Observable object is the one that this class was added to
     * @param arg is the TemperatureReadingsHolder object that is passed containing the values for Celsius and Kelvin temperatures
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o != station){
            return;
        }  
    }
    
}
