package model;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    private String myTitle;
    private Date myDateLastModified;
    private Date myDateCreated;
    private ArrayList<Material> myMaterials;
    private ArrayList<Receipt> myReceipts;
    //graph and price estimate can be obtained with buildGraph() and estimateTotal()
   
    
    /**
     * create a project with a specified title and no materials.
     * @param projectTitle
     * @author Caleb Wheeler
     */
    public Project(String projectTitle){
        new Project(projectTitle, new ArrayList<Material>());
    }
    
    /**
     * create a project with this title and these materials.
     * The project will have a start Date for the current date.
     * @param projectTitle
     * @param projectMaterials
     * @author Caleb Wheeler
     */
    public Project(String projectTitle, ArrayList<Material> projectMaterials) {
        myTitle = projectTitle;
        myDateCreated = new Date();
        myDateLastModified = new Date();
        myMaterials = projectMaterials;
    }
    
    /**
     * Add a single material to the list of this projects materials.
     * @param theMaterial
     * @author caleb
     */
    public void addMaterial(Material theMaterial) {
        myMaterials.add(theMaterial);
    }
    
    /**
     * Add a single receipt to the list of this projects receipts.
     * @param theReceipt
     * @author caleb
     */
    public void addReceipt(Receipt theReceipt) {
        myReceipts.add(theReceipt);
    }
    
    /**
     * Builds and returns a graph based on the receipts for this project.
     * @return a graph for this project.
     * @author caleb
     */
    public Graph buildGraph() {
        /*
         * after Graph class is implemented do  VV
         * 
         * newGraph = new Graph(Receipts) 
         *  or newGraph = new Graph(Receipts.values)?
         *  
         *  return newGraph
         */
        return null;
    }
    
    /**
     * gets the estimated total for the materials.
     * @return the material total for the materials.
     * @author caleb
     */
    public Double estimateTotal() {
        Double total = 0.0;
        for(int i = 0; i < myMaterials.size(); i++) {
            //after material is implmented
            //total += myMaterials.get(i).cost;
        }
        return total;
    }
    
    public Double getCostOverTime() {
        //maybe date that the project pays off in heating efficiency?
        return null;
    }
    
}
