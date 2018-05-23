package view.panel;

import javax.swing.JPanel;

public class ProjectPanel extends JPanel {

    /**
     * generated serial id.
     */
    private static final long serialVersionUID = 6230144897462569298L;

    //panel 1
    //title label
    //button [new project]
    //button [existing [project]
    
    //new project panel
    //button [save Project]
    //button [cancel]
    //to save the project you can call 
    //ProjectManager.addProject(new Project(title, ArrayList of materials, ArrayList of receipts)); //materials and receipts are not required
    //ProjectManager automatically saves when new projects are added also
    
    //existing project panel
    //call ProjectManager.count to get the total # of projects saved
    //for each project add a row and button to select that project
    //ProjectManager.get(i) for i<- 0 to count
    //when the button is clicked for that project call
    //ProjectManager.get(theProject)   if this is difficult we could make project titles need to be unique then search on that instead
    //then the project info can be shown
    
    //also materials and receipts eventually
    
    
}
