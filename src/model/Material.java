package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Class that holds information about a material a user may choose to add
 * to their project from the shop.
 * 
 * @author David
 * @author Michelle
 */
public class Material {

    public String myName;

    public Double myPrice;

    public Measurement myMeasurment;

    public int myAmount;

    public Material(String theName, double thePrice, Measurement theMeasurment, int theAmount) {
        myName = theName;
        myPrice = thePrice;
        myMeasurment = theMeasurment;
        myAmount = theAmount;
    }

    public String toString() {
        return  myName + "\nCost = " + myPrice + "\nMeasurment = " + myMeasurment.toString() + "\n\n";
    }

    public double totalCost() {
        return myPrice * myAmount;
    }
    
    
    
    /**
     * Inner class that defines the way a Material can be measured.
     * 
     * @author Michelle
     */
    class Measurement {

        boolean imperial; //defaults to true

        MeasurementType measurementType;

        double width;

        double height;

        double depth;

        double weight;

        private Measurement(MeasurementType measurementType, double width,
                            double height, double depth, double weight) {
            setMeasurements(measurementType, width, height, depth, weight);
            imperial = true;
        }

        /**
         * Will set the measurement values based on the type of measurement being used.
         * This is to make sure that no values get set that shouldn't be set.
         * 
         * @param measurementType2
         * @param width2
         * @param height2
         * @param depth2
         * @param weight2
         */
        public void setMeasurements(MeasurementType measurementType, double width,
                                     double height, double depth, double weight) {
            if (measurementType == MeasurementType.weight) {
                width = 0;
                height = 0;
                depth = 0;
                this.weight = weight;
            } else {
                this.width = width;
                this.height = height;
                if (measurementType == MeasurementType.w_h_d) {
                    this.depth = depth;
                } else
                    this.depth = 0;
            }
        }

        /**
         * Will convert the measurement values to a different standard.
         * If the standard being used is imperial, it will be converted to metric
         * and visa versa.
         */
        private void convertStandards() {
            if (measurementType == MeasurementType.weight) { //assumes we are using either lbs or grams
                weight = convert(weight, false);
            } else {
                width = convert(width, true);
                height = convert(height, true);;
                if (measurementType == MeasurementType.w_h_d) {
                    depth = convert(depth, true);
                }
            }
        }
        
        /**
         * Will help change the standard being used and return the new value;
         * 
         * @param num
         * @param typeLength
         * @return
         */
        private double convert(double num, boolean typeLength) { //1 = length, 0 = weight
            double toMetric;
            double toImperial;
            if (typeLength) {
                toMetric = 2.54;
            } else {
                toMetric = 28.3495;
            }
            toImperial = 1/toMetric;
            if (imperial) {
                imperial = false;
                return num*toMetric;
            } else {
                imperial = true;
                return num*toImperial;
            }
        }
        
    }

}
