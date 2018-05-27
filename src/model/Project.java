package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Project implements Serializable{
    
    /**
     * should not change unless incompatible with previous serializeable files.
     */
    private static final long serialVersionUID = 3274616962318959161L;
    
    private String myTitle;
    private Date myDateLastModified;
    private Date myDateCreated;
    private ArrayList<Material> myMaterials = new ArrayList<Material>();
    private ArrayList<Receipt> myReceipts = new ArrayList<Receipt>();
  //graph and price estimate can be obtained with buildGraph() and estimateTotal()

    //key values used with json
    /*private final String KEY_TITLE = "Project Title";
    private final String KEY_PROJECT = "Project";
    private final String KEY_DATE_MODIFIED = "Date Modified";
    private final String KEY_DATE_CREATED = "Date Created";
    private final String KEY_MATERIALS = "Materials";
    private final String KEY_RECEIPTS = "Receipts";*/
    
    
    /**
     * create a project with a specified title and no materials.
     * @param projectTitle
     * @author Caleb Wheeler
     */
    public Project(String projectTitle){
        this(projectTitle, new ArrayList<Material>(), new ArrayList<Receipt>());
    }
    
    /**
     * create a project with this title and these materials.
     * The project will have a start Date for the current date.
     * @param projectTitle
     * @param projectMaterials
     * @author Caleb Wheeler
     */
    public Project(String projectTitle, ArrayList<Material> projectMaterials) {
        this(projectTitle, projectMaterials, new ArrayList<Receipt>());
    }
    
    /**
     * create a project with this title and these materials and receipts.
     * The project will have a start Date for the current date.
     * @param projectTitle
     * @param projectMaterials
     * @author Caleb Wheeler
     */
    public Project(String projectTitle, ArrayList<Material> projectMaterials, ArrayList<Receipt> projectReceipts) {
        myTitle = projectTitle;
        myDateCreated = new Date();
        myDateLastModified = new Date();
        myMaterials = projectMaterials;
        myReceipts = projectReceipts;
    }
    
    public String getTitle() {
        return myTitle;
    }
    
    public Date getDateLastModified() {
        return myDateLastModified;
    }
    
    public Date getDateCreated() {
        return myDateCreated;
    }
    
    public  ArrayList<Material> getMaterials() {
        return myMaterials;
    }
    
    public ArrayList<Receipt> getReceipts() {
        return myReceipts;
    }
    
    /**
     * updates project title and updates date last modified.
     * @param theProjectTitle
     * @author caleb
     */
    public void changeProjectTitle(String theProjectTitle) {
        myTitle = theProjectTitle;
        myDateLastModified = new Date();
    }
    
    /**
     * remove the material from the list and update date last modified.
     * @return returns true if the material was removed and false if the material wasn't found.
     * @param theMaterial
     * @author caleb
     */
    public boolean removeMaterial(Material theMaterial) {
        boolean removed = myMaterials.remove(theMaterial);
        if(removed) {
            //project was changed so update project.
            myDateLastModified = new Date();
        }
        return removed;
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

    /**
     * Will return how long it will take (in years) for a project to pay for itself.
     * returns -1.0 if it never will.
     * TODO figure out how this works
     * 
     * @return
     */
    public Double getCostOverTime() {
        //maybe date that the project pays off in heating efficiency?
        return null;
    }

    //auto generated code
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((myDateCreated == null) ? 0 : myDateCreated.hashCode());
        result = prime * result
                 + ((myDateLastModified == null) ? 0 : myDateLastModified.hashCode());
        result = prime * result + ((myMaterials == null) ? 0 : myMaterials.hashCode());
        result = prime * result + ((myReceipts == null) ? 0 : myReceipts.hashCode());
        result = prime * result + ((myTitle == null) ? 0 : myTitle.hashCode());
        return result;
    }

    //auto generated code
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (myDateCreated == null) {
            if (other.myDateCreated != null)
                return false;
        }
        else if (!myDateCreated.equals(other.myDateCreated))
            return false;
        if (myDateLastModified == null) {
            if (other.myDateLastModified != null)
                return false;
        }
        else if (!myDateLastModified.equals(other.myDateLastModified))
            return false;
        if (myMaterials == null) {
            if (other.myMaterials != null)
                return false;
        }
        else if (!myMaterials.equals(other.myMaterials))
            return false;
        if (myReceipts == null) {
            if (other.myReceipts != null)
                return false;
        }
        else if (!myReceipts.equals(other.myReceipts))
            return false;
        if (myTitle == null) {
            if (other.myTitle != null)
                return false;
        }
        else if (!myTitle.equals(other.myTitle))
            return false;
        return true;
    }
    
}