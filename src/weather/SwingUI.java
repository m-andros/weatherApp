package weather;

/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */
 
import java.awt.Font;
import java.awt.GridLayout; 
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import java.text.DecimalFormat ;

public class SwingUI extends JFrame implements Observer{
    private final WeatherStation station; // constant for the WeatherStation object  
    private ArrayList<JLabel> labelListing; // ArrayList that holds reference to all the JLabel objects
    JLabel newLabel; //Label object that is going to be added in to the ArrayList

    // A Font object contains information on the font to be used to render text.
    private static final Font LABELFONT =
        new Font(Font.SERIF, Font.PLAIN, 72) ;

    /**
     * Constructor that calls the super constructor and assigns the name of Weather Station.
     * Calls method SetupDisplay that sets up all the panels and labels needed for the program
     * Finally assigns the station object to our local variable and adds this object to the list of observers
     * @param station is a value of a WeatherStation object assigned to the station variable inside the SwingUI
     */
    @SuppressWarnings("LeakingThisInConstructor")// this is added to ignore the warninf in the line 31 about the "leaking 'this' in the constructor"
    public SwingUI(WeatherStation station) {
        super("Weather Station"); 
        this.SetupDisplay(this); // All the GUI creation separeted to eliminate warning of calling this in the Overridable methods 
        this.station = station;
        this.station.addObserver(this);
        labelListing = new ArrayList<JLabel>();
    }
    
    /**
    * SetupDisplay is used to set up all the GUI components outside the constructor to avoid having issues with 
    * calling overriddable methods inside the constructor
    * @param frame is the SwingUI class itself passed to setup all the GUI components
    */
    public final void SetupDisplay(JFrame frame){
        /*
        * WeatherStation frame is a grid of 1 row by an indefinite
        * number of columns.
        */
        frame.setLayout(new GridLayout(1,0)) ;
        frame.setLocation(300, 400);
        /*
        * Calling PanelCreation for the setup of the up temperature and pressure display.
        */
        this.PanelCreation(" Kelvin ", frame); 
        this.PanelCreation(" Celsius ", frame);
        this.PanelCreation(" Mercury ", frame);
        this.PanelCreation(" mBar ", frame);
        /*
        * Set up the frame's default close operation pack its elements,
        * and make the frame visible.
        */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.pack() ;
        frame.setVisible(true) ;
    } 
    
    /**
     *  Create a Label with the initial value <title>, place it in
     * the specified <panel>, and return a reference to the Label
     * in case the caller wants to remember it.
     * @param title is the title of the Label as in kelvin, celsius
     * @param panel is the JPanel to which we want to add the created label
     * @return created JLabel object to keep a reference for it inside other methods
     */
    private JLabel createLabel(String title, JPanel panel) {
        JLabel label = new JLabel(title) ;

        label.setHorizontalAlignment(JLabel.CENTER) ;
        label.setVerticalAlignment(JLabel.TOP) ;
        label.setFont(LABELFONT) ;
        panel.add(label);
        return label ;
    } 
     
    /**
     * There are two panels, one each for Kelvin and Celsius, added to the
     * frame. Each Panel is a 2 row by 1 column grid, with the temperature
     * name in the first row and the temperature itself in the second row.
     * @param name name to be placed inside the JLabel object as its name
     * @param frame is the JFrame in which we will add the created panel
     * @return JLabel object that is used to be assigned to kelvinField or celsiusField variable
     */
    public void PanelCreation(String name, JFrame frame){
        JPanel panel = new JPanel(new GridLayout(2,1)) ;
        frame.add(panel) ;
        createLabel(name, panel) ;
        newLabel = createLabel("", panel);
        labelListing.add(newLabel);
    } 
    
    /**
     * update is a overridden method from the Observer interface and is used to update
     * values of celsius and kelvin temperatures using the update() method when
     * it gets a notification to do so.
     * @param o used to checks if the Observable object is the one that this class was added to
     * @param arg is the TemperatureReadingsHolder object that is passed containing the values for Celsius and Kelvin temperatures
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o != station){
            return;
        }
         
        /*
            Setting the values of Kelvin and Celsius degrees calculations to their appropriate holders
        */ 
        
    }

}
