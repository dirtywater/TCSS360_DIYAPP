package model;

import java.io.Serializable;

public class Material  implements Serializable{

    /**
     * generated serial.
     */
    private static final long serialVersionUID = 6919975119730472259L;
    
    private String myName;
    private Double myPrice;
    private Measurement myMeasurement;
    
    public Material(String theName, double thePrice, Measurement theMeasurment) {
        myName = theName;
        myPrice = thePrice;
        myMeasurement = theMeasurment;

    }
    
    
    public Double getPrice() {
        return myPrice;
    }
    public String getName() {
        return myName;
    }
    public Measurement getMeasurement() {
        return myMeasurement;
    }
    
    public String toString() {
        
       return  "Name: " + myName + "\nCost = $" + myPrice + "\nMeasurment = " + myMeasurement.toString() + "\n\n";
    }
}
