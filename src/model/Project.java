package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    /**
     * create a project with a specified title and no materials.
     * @param projectTitle
     * @author Caleb Wheeler
     */
    public Project(String projectTitle){
        this(projectTitle, new ArrayList<Material>(), new ArrayList<Receipt>());
    }
    
    @Override
    public String toString() {
        String project = "Title: " + myTitle;
        for(int i  = 0; i < myMaterials.size(); i++) {
            project += " Material: " + myMaterials.get(i);
        }
        for(int i = 0; i < myReceipts.size(); i++) {
            project += " Receipt: " + myReceipts.get(i);
        }
        return project;
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
    
    public String getDateLastModified() {
        SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy");
        String date = dt.format(myDateLastModified);
        return date;
    }
    
    public String
    getDateCreated() {
        SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy");
        String date = dt.format(myDateCreated);
        return date;
    }
    
    /**
     * replace all of the projects materials with these.
     * @return
     * @author caleb
     */
    public void replaceMaterials(List<Material> theMaterials) {
        myMaterials = new ArrayList<Material>();
        for(int i = 0; i < theMaterials.size(); i++) {
            myMaterials.add(theMaterials.get(i));
        }
        myDateLastModified = new Date();
    }
    
    /**
     * replace all of the project receipts with these.
     * @param theReceipts
     * @author caleb
     */
    public void replaceReceipts(List<Receipt> theReceipts) {
        myReceipts = new ArrayList<Receipt>();
        for(int i = 0; i < theReceipts.size(); i++) {
            myReceipts.add(theReceipts.get(i));
        }
        myDateLastModified = new Date();
    }
    
    /**
     * return a deep clone of the materials
     * @return
     * @author caleb
     */
    public  ArrayList<Material> getMaterials() {
        ArrayList<Material> copyOfMaterials = new ArrayList<Material>();
        for(int i = 0; i < myMaterials.size(); i++) {
            copyOfMaterials.add(myMaterials.get(i));
        }
        return copyOfMaterials;
    }
    
    /**
     * return a deep clone of the receipts.
     * @return
     * @author caleb
     */
    public ArrayList<Receipt> getReceipts() {
        ArrayList<Receipt> copyOfReceipts = new ArrayList<Receipt>();
        for(int i = 0; i < myReceipts.size(); i++) {
            copyOfReceipts.add(myReceipts.get(i));
        }
        return copyOfReceipts;
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
        myDateLastModified = new Date();
        myMaterials.add(theMaterial);
        ProjectManager.saveProjects();
    }
    
    /**
     * Add a single receipt to the list of this projects receipts.
     * @param theReceipt
     * @author caleb
     */
    public void addReceipt(Receipt theReceipt) {
        myDateLastModified = new Date();
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
            total += myMaterials.get(i).getPrice();
        }
        return total;
    }
    
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