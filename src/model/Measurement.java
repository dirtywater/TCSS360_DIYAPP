package model;

public class Measurement {

    
    
    
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
        
        return  myWidth + ", " + myHeight + ", " + myDepth + ", " + myWeight + "\n";
     }
    
    
}
