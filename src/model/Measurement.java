package model;

import java.io.Serializable;

public class Measurement  implements Serializable {

    
    
    
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
    
    //edited by caleb
    public String toString() {
        
        return  "Width: "+ myWidth + "\nHeight:" + myHeight 
                        +" Depth: "+ myDepth +"\nWeight: " + myWeight;
    }
    
    
}
