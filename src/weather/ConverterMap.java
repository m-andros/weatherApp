package weather;

import java.util.EnumMap; 

class Values{ 
    private final double divisor; // constant value for the common divisor
    private final int conversionConstant; // value for the addition constant
    private final double reductionConstant;
     
    /**
     * Values constructor with parameter
     * @param conversion is a value for the conversion constant that depends of the degree type, celsius or kelvin
     */
    Values(int conversion, double divisor, double reduction) {
        this.conversionConstant = conversion;
        this.divisor = divisor;
        this.reductionConstant = reduction;
    }

    public double getReductionConstant() {
        return reductionConstant;
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
          
        Values v1=new Values(-27315, 0.01, 0);
        map.put(MeasureUnits.CELZIUS, v1);
        
        Values v2=new Values(0, 0.01, 0);
        map.put(MeasureUnits.KELVIN, v2);
        
        Values v3=new Values(0, 0.018, -459.67);
        map.put(MeasureUnits.FAHRENHEIT, v3);
        
        Values v4=new Values(0, 1.0, 0);
        map.put(MeasureUnits.MERCURYINCH, v4);
        
        Values v5=new Values(0, 33.864, 0);
        map.put(MeasureUnits.MBAR, v5);
    }
    
    public EnumMap<MeasureUnits, Values> getMap() {
        return map;
    }
    // Creating enum  
    enum MeasureUnits {
        CELZIUS(), // celsius enum that holds the values for conversion constant and shared divisor
        KELVIN(), // kelvin enum that holds the values for conversion constant and shared divisor
        FAHRENHEIT(),
        MERCURYINCH(),
        MBAR();
    }  
} 