package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Material {


    private String myName;
    private Double myPrice;
    private Measurement myMeasurment;
    
    public Material(String theName, double thePrice, Measurement theMeasurment) {
        myName = theName;
        myPrice = thePrice;
        myMeasurment = theMeasurment;

    }
    
    public String toString() {
        
       return  myName + ", " + myPrice + ", " + myMeasurment.toString();
    }
}
