package model;

import java.io.Serializable;

/**
 * Class that holds information about a material a user may choose to add
 * to their project from the shop.
 * 
 * @author David Guerrero
 * @author Michelle Brown
 * 
 * @version May 25, 2018
 */
public class Material implements Serializable{

    /**
     * generated serial id.
     */
    private static final long serialVersionUID = -8314551894492343040L;

    private String myName;

    private Double myPrice;

    private Measurement myMeasurement;

    private int myAmount;

    /**
     * Constructor that creates a new Material of amount 1
     * 
     * @param theName
     * @param thePrice
     * @param measurement
     */
    public Material(String theName, double thePrice, Measurement measurement) {
        this(theName, thePrice, measurement, 1);
    }
    
    /**
     * Constructor that creates a new Material with specified amount
     * 
     * @param theName
     * @param thePrice
     * @param theMeasurement
     * @param theAmount
     */
    public Material(String theName, double thePrice, Measurement theMeasurement,
                    int theAmount) {
        myName = theName;
        myPrice = thePrice;
        myMeasurement = theMeasurement;
        myAmount = theAmount;
    }

    public String toString() {
        return  myName + "\nCost = $" + myPrice + "\nMeasurment = " +
                        myMeasurement.toString() + "\n\n";
    }

    public String getMeasurements() {
        return myMeasurement.toString();
    }
    
    /**
     * Returns the price of the material.
     * 
     * @return The price of the material.
     * @author Jim
     */
    public double getPrice() {
        return myPrice;
    }
    
    /**
     * Returns the amount of materials there are.
     * 
     * @return The amount of materials.
     * @author Jim
     */
    public int getAmount() {
        return myAmount;
    }
    
    /**
     * Set the amount of materials to the object.
     * 
     * @param amount The amount.
     * @author Jim
     */
    public void setAmount(int amount) {
        myAmount = amount;
    }
    
    public double totalCost() {
        return myPrice * myAmount;
    }
    
    public String getName() {
        return myName;
    }
}
