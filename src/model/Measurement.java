package model;

import java.io.Serializable;

/**
 * Measurement specifications.
 * 
 * @author TODO fill in_________
 * 
 * @version TODO fill in_________
 */
public class Measurement implements Serializable {
    
    /**
     * generated serial id.
     */
    private static final long serialVersionUID = 5002827379414578857L;
    
    double myWidth;
    double myHeight;
    double myDepth;
    double myWeight;
    
    public Measurement(double theWidth, double theHeight, double theDepth, double theWeight) {
        myWidth = theWidth;
        myHeight = theHeight;
        myDepth = theDepth;
        myWeight = theWeight;
    }
    
    public String toString() {
        return  myWidth + ", " + myHeight + ", " + myDepth + ", " + myWeight;
    }
    
}
