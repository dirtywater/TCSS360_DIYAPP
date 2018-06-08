
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Material;
import model.Measurement;

/**
 * JUnit test for Material class.
 * 
 * @author David Guerrero
 * @version 6/7/2018
 */
public class MaterialTest {

    
    
    
    @Before
    public void setUp() throws Exception {

    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testgetMeasurements() {

        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test that returned material string is correct
        assertTrue(testMaterial.getMeasurements().equals("0.0, 0.0, 0.0, 0.0"));
        
        testMaterial = new Material("test",5.00, new Measurement(1,5,6,10));
        
        // Test that returned material string is correct
        System.out.println(testMaterial.getMeasurements());
        assertTrue(testMaterial.getMeasurements().equals("1.0, 5.0, 6.0, 10.0"));
        
        
        testMaterial = new Material("test",5.00, null);
        
        // Test that returned material string is correct for null material
        assertTrue(testMaterial.getMeasurements().equals(""));
    }
        
    /**
     * @author David Guerrero
     */
    @Test
    public void testgetPrice() {
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test that price is correct
        assertTrue(5.00 == testMaterial.getPrice());
    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testgetAmount() {
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test that amount of product is correct and updates when changed
        assertTrue(1 == testMaterial.getAmount());
        testMaterial.setAmount(3);
        assertTrue(3 == testMaterial.getAmount());
    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testsetAmount() {
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        testMaterial.setAmount(3);
        // check that set amount is working
        assertTrue(3 == testMaterial.getAmount());
    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testtotalCost() {
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test that total cost is correct before and after you change to amount to product
        assertTrue(5.00 == testMaterial.totalCost());
        testMaterial.setAmount(3);
        assertTrue(15.00 == testMaterial.totalCost());
    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testgetName() {
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test that total cost is correct before and after you change to amount to product
        assertTrue("test".equals(testMaterial.getName()));
        
    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testclone() {
        
        Material testMaterial = new Material("test",5.00, new Measurement(0,0,0,0));
        Material clone = testMaterial.clone();
        
        // Test to make sure that the new clone is a copy and not the same material
        assertTrue(testMaterial != clone);
        
        

    }
    
    /**
     * @author David Guerrero
     */
    @Test
    public void testcompareTo() {
        
        Material testMaterial1 = new Material("test",5.00, new Measurement(0,0,0,0));
        Material testMaterial2= new Material("test",5.00, new Measurement(0,0,0,0));
        
        Material testMaterial3 = new Material("aest",5.00, new Measurement(0,0,0,0));
        Material testMaterial4= new Material("cest",5.00, new Measurement(0,0,0,0));
        
        Material testMaterial5 = new Material("test",6.00, new Measurement(0,0,0,0));
        Material testMaterial6= new Material("test",5.00, new Measurement(0,0,0,0));
        
        // Test to make sure that we get a zero when like materials are compared
        assertTrue(Material.compareTo(testMaterial1, testMaterial2) == 0);
        // Test name comparing
        assertTrue(Material.compareTo(testMaterial1, testMaterial2) == 0);
        // Test price comparing
        assertTrue(Material.compareTo(testMaterial1, testMaterial2) == 0);
    }
}
