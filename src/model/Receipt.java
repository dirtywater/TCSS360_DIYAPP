package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Everything the user purchases for a project can be made into a receipt.
 * A user can get a receipt from a Material they purchased in the shop,
 * or they can enter the information from an item purchased elsewhere.
 * 
 * @author Michelle
 */
public class Receipt {
    
    public String title;

    public double cost;
    
    public LocalDate date;
    
    public String note;
    
    /**
     * Constructor for a Material bought in the shop.
     * 
     * @param material
     */
    public Receipt(Material material) {
        title = material.myName;
        cost = material.myPrice;
        date = LocalDate.now();
        note = "measurement: " + material.myMeasurment.toString() + "\nquantity: " + material.myAmount;
    }
    
    /**
     * Constructor for user inputting a material
     * not bought in the program's store feature.
     * 
     * @param cost
     * @param note
     */
    public Receipt(String title, double cost, String date, String note) { //date in the form MM/dd/yyyy
        this.cost = cost;
        this.date = LocalDate.now().minusDays(/*days to subtract to get the actual time purchased.
        should use the string passed in to determine how long ago it was*/); //TODO figure this out
        this.note = note;
    }
    
    public String toString() {
        return "Material: title\n cost: " + cost + "\n date purchased: " + date.toString() + "\n note:\n" + note;
    }
    
}