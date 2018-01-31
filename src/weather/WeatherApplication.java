package weather;

/**
 * WeatherApplication is a class that contains the main method.
 * This is an starting point of our application.
 * @author mxa3265
 */
public class WeatherApplication { 
    
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation(); // creates the WeatherStation object that is going to manage this application
        TextUI ui = new TextUI(ws); // Starts the Textual GUI
        SwingUI sui = new SwingUI(ws); // Starts the SwingGUI
        Thread thread = new Thread(ws); 
        thread.start();
    }
}
