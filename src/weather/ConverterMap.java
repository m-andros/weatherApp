package weather;

import java.util.EnumMap; 

class Values{ 
    private final double divisor; // constant value for the common divisor
    private final int conversionConstant; // value for the addition constant
     
    /**
     * Values constructor with parameter
     * @param conversion is a value for the conversion constant that depends of the degree type, celsius or kelvin
     */
    Values(int conversion, double divisor) {
        this.conversionConstant = conversion;
        this.divisor = divisor;
    }
    
    public double getDivisor() {
        return divisor;
    }

    public int getConversionConstant() {
        return conversionConstant;
    }
}
/**
 * Temperature class is an enum class that holds all the important components for the 
 * conversion calculation and does the actual conversion by calling the getTemperature on the appropriate enum
 * @author mxa3265
 */
public class ConverterMap {   
    
    private final EnumMap<MeasureUnits, Values> map;

    public ConverterMap() {
        map = new EnumMap<MeasureUnits, Values>(MeasureUnits.class);
        // Creating Books    
        Values v1=new Values(-27315, 0.01);
        Values v2=new Values(0, 0.01);
        Values v3=new Values(0, 1.0);
        Values v4=new Values(0, 33.864);
        // Adding Books to Map   
        map.put(MeasureUnits.CELZIUS, v1);
        map.put(MeasureUnits.KELVIN, v2);
        map.put(MeasureUnits.MERCURYINCH, v3);
        map.put(MeasureUnits.MBAR, v4);
    }
    
    public EnumMap<MeasureUnits, Values> getMap() {
        return map;
    }
    // Creating enum  
    enum MeasureUnits {
        CELZIUS(), // celsius enum that holds the values for conversion constant and shared divisor
        KELVIN(), // kelvin enum that holds the values for conversion constant and shared divisor
        MERCURYINCH(),
        MBAR();
    }  
} 