package view.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import model.Material;
import model.Project;
import model.ProjectManager;
import model.Receipt;
import model.ShopSim;

public class ProjectPanel extends JPanel implements ActionListener{

    /**
     * generated serial id.
     */
    private static final long serialVersionUID = 6230144897462569298L;

    private enum COMMAND {
        EDIT_PROJECT, EXISTING_PROJECT, MATERIALS, ADD_RECEIPTS, SAVE_PROJECT_EDIT, CLOSE_PANEL;

        //return the command with the same name as the actionCommand or null
        public static COMMAND getCommand(String actionCommand) {
            for(COMMAND c :COMMAND.values()) {
                if(c.name() == actionCommand) {
                    return c;
                }
            }

            System.err.println("In ProjectPanel.java\nInvalid action command:" + actionCommand);
            return null;
        }
    };

    private JPanel displayPanel;


    /**
     * base panel to hold the display panels.
     * @param panelDimensions
     * @author caleb
     */
    public ProjectPanel(Dimension panelDimensions) {
        displayPanel = new ProjectAskPanel(this);
        this.setPreferredSize(panelDimensions);
        this.setLayout(new BorderLayout());

        this.add(displayPanel, BorderLayout.CENTER);
    }

    /**
     * panel for asking the user if they want a new project or existing project
     * @author caleb
     *
     */
    private class ProjectAskPanel extends JPanel {
        /**
         * generated serial id.
         */
        private static final long serialVersionUID = 3612278017012099089L;

        /**
         * panel to ask user if they want to use an existing or create a new project.
         * @param projectPanel
         * @author caleb
         */
        private ProjectAskPanel(ProjectPanel projectPanel) {
            //create new project button
            JButton btnNewProject = new JButton("New Project");
            btnNewProject.setActionCommand(COMMAND.EDIT_PROJECT.name());
            btnNewProject.addActionListener(projectPanel);

            //create existing project button
            JButton btnExistingProject = new JButton("Existing Project");
            btnExistingProject.setActionCommand(COMMAND.EXISTING_PROJECT.name());
            btnExistingProject.addActionListener(projectPanel);

            //add buttons
            this.add(btnNewProject,BorderLayout.WEST);
            this.add(btnExistingProject, BorderLayout.EAST);
        }
    }

    /**
     * this panel allows viewing all materials for a project and removing materials from the project.
     * @author caleb
     *
     */
    private class ProjectMaterialsPanel extends JPanel {
        /**
         * generated serial id.
         */
        private static final long serialVersionUID = -2980969761153265743L;

        private ProjectMaterialsPanel(ProjectPanel projectPanel, Project theProject) {

            JPanel panel = new JPanel(new GridLayout(0,1));
            
            JPanel materialsScrollPanel = new JPanel();
            materialsScrollPanel.setBorder(BorderFactory.createBevelBorder(0));
            JPanel materialsDisplayPanel = new JPanel(new GridLayout(0,1));
            JScrollPane materialScrollPane = new JScrollPane(materialsScrollPanel,
                                                             JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                             JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //if this is an existing project display all of its materials
            if(theProject != null) {
                List<Material> mats = theProject.getMaterials();
                for(Material mat : mats) {
                    String matText = mat.getName() +" $" + mat.getPrice();
                    
                    JButton btnRemove = new JButton("Remove");
                    btnRemove.addActionListener(projectPanel);
                    btnRemove.setActionCommand("_R" + mat.toString());
                    
                    JLabel matLabel = new JLabel(matText);
                    JPanel materialPanel = new JPanel(new GridLayout(1,0));
                    materialPanel.add(matLabel);
                    materialPanel.add(btnRemove);
                    materialsDisplayPanel.add(materialPanel);
                }
            }
            materialsScrollPanel.add(materialsDisplayPanel);
            
            panel.add(materialScrollPane);
            this.add(panel);
        }
    }

    /**
     * panel for editing an existing project or creating a new project.
     * @author caleb
     *
     */
    private class ProjectEditPanel extends JPanel {

        /**
         * generated serial id.
         */
        private static final long serialVersionUID = -8006320246280583297L;

        private Project myOldProject;

        private JTextField myTxtTitle = new JTextField(10);
        private ArrayList<Material> myMaterials = new ArrayList<Material>();
        private ArrayList<Receipt> myReceipts = new ArrayList<Receipt>();

        /**
         * panel for editing a new project.
         * @author caleb
         */
        private ProjectEditPanel(ProjectPanel projectPanel) {
            this(projectPanel, null);
        }

        /**
         * panel for editing a project.
         * @param projectPanel
         * @param theProject existing project or null if this is for a new project
         * @author caleb
         */
        private ProjectEditPanel(ProjectPanel projectPanel, Project theProject) {
            myOldProject = theProject;
            if(theProject != null) {
                myReceipts = theProject.getReceipts();
                myMaterials = theProject.getMaterials();
            }

            this.setBorder(BorderFactory.createBevelBorder(0));
            //components

            JLabel lblTitle = new JLabel("Title: ");
            JLabel lblPanelHeader;
            if(theProject == null) {
                lblPanelHeader = new JLabel("New Project");
            } else {
                String title = theProject.getTitle();
                lblPanelHeader = new JLabel(title);
                myTxtTitle.setText(title);
            }

            JButton btnAddMaterials = new JButton("Materials");
            btnAddMaterials.setActionCommand(COMMAND.MATERIALS.name());
            btnAddMaterials.addActionListener(projectPanel);

            JButton btnAddReceipts = new JButton("Add Receipts");
            btnAddReceipts.setActionCommand(COMMAND.ADD_RECEIPTS.name());
            btnAddReceipts.addActionListener(projectPanel);

            JButton btnCancelProjectEdit = new JButton("Cancel");
            btnCancelProjectEdit.setActionCommand(COMMAND.CLOSE_PANEL.name());
            btnCancelProjectEdit.addActionListener(projectPanel);

            JButton btnSaveProjectEdit = new JButton("Save");
            btnSaveProjectEdit.setActionCommand(COMMAND.SAVE_PROJECT_EDIT.name());
            btnSaveProjectEdit.addActionListener(projectPanel);

            JPanel headerPanel = new JPanel(new BorderLayout());
            headerPanel.add(lblPanelHeader, BorderLayout.CENTER);

            JPanel infoPanel = new JPanel(new BorderLayout());
            infoPanel.add(lblTitle, BorderLayout.WEST);
            infoPanel.add(myTxtTitle, BorderLayout.EAST);

            JPanel materialsPanel = new JPanel(new BorderLayout());
            materialsPanel.add(btnAddMaterials, BorderLayout.NORTH);

            JPanel receiptsPanel = new JPanel(new BorderLayout());
            receiptsPanel.add(btnAddReceipts, BorderLayout.NORTH);

            JPanel costsPanel = new JPanel();
            costsPanel.setLayout(new GridLayout(0,2));
            costsPanel.add(materialsPanel);
            costsPanel.add(receiptsPanel);

            JPanel closingPanel = new JPanel(new BorderLayout());
            closingPanel.add(btnCancelProjectEdit, BorderLayout.WEST);
            closingPanel.add(btnSaveProjectEdit, BorderLayout.EAST);

            JPanel centerPanel = new JPanel(new BorderLayout());
            centerPanel.add(infoPanel, BorderLayout.NORTH);
            centerPanel.add(costsPanel, BorderLayout.SOUTH);

            GridLayout layout = new GridLayout(0,1);
            layout.setVgap(20);
            JPanel mainPanel = new JPanel(layout);
            mainPanel.add(headerPanel);
            mainPanel.add(centerPanel);
            mainPanel.add(closingPanel);
            this.add(mainPanel);
        }

        /**
         * if the project being edited was an existing project or not and save the changes.
         * @author caleb
         */
        private void updateProject() {
            String title = myTxtTitle.getText();
            if(myOldProject != null) {
                ProjectManager.updateProject(myOldProject, title, myMaterials, myReceipts);
            } else {
                Project p = new Project(title, myMaterials, myReceipts);
                ProjectManager.addProject(p);
            }

        }

    }    

    /**
     * panel for selecting an existing project.
     * @author caleb
     *
     */
    private class ProjectExistingPanel extends JPanel {
        /**
         * generated serial id.
         */
        private static final long serialVersionUID = 2933859283811046218L;

        private ProjectExistingPanel(ProjectPanel projectPanel) {
            this.setLayout(new GridLayout(0,1));

            JPanel projectsScrollPanel = new JPanel();
            JPanel projectsPanel = new JPanel(new GridLayout(0,1));
            JScrollPane scrollPane = new JScrollPane(projectsScrollPanel,
                                                     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                     JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            List<Project> projects = ProjectManager.getProjects();
            for(Project proj : projects) {
                int maxCharsInTitleLabel = 15;

                JPanel panel = new JPanel(new GridLayout(1,0));
                String cost = "";
                DecimalFormat df = new DecimalFormat("0.00");
                cost = df.format(proj.estimateTotal());
                JLabel displayText = new JLabel(proj.getTitle().substring
                                                (0, Integer.min(maxCharsInTitleLabel, proj.getTitle().length())) +
                                                "   Created: " + proj.getDateCreated() +
                                                "   Modified: "+ proj.getDateLastModified() +
                                                "   Cost: $" + cost + "   ");
                int projIndex = ProjectManager.getIndex(proj);
                
                JButton btnEdit = new JButton("Edit");
                btnEdit.setActionCommand("_P" + projIndex);
                btnEdit.addActionListener(projectPanel);

                JButton btnSelect = new JButton("Select");
                btnSelect.setActionCommand("_S" + projIndex);
                btnSelect.addActionListener(projectPanel);

                JButton btnDelete = new JButton("Delete");
                btnDelete.setActionCommand("_D" + projIndex);
                btnDelete.addActionListener(projectPanel);
                
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(btnEdit);
                buttonPanel.add(btnSelect);
                buttonPanel.add(btnDelete);

                panel.add(displayText);
                panel.add(buttonPanel);
                panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
                projectsPanel.add(panel);
            }
            projectsScrollPanel.add(projectsPanel);
            this.add(scrollPane);
        }
    }

    /**
     * what to do when buttons are used.
     * for static buttons the COMMAND enum is used, for dynamic buttons prefixes are used and 
     * the related identifier is appended to the end of the action command.
     * _P prefix is for getting the project to be edited from the existing project panel to the edit project panel
     * _S prefix is for the select button in existing projects panel, to set the selected project.
     * _R prefix is used for removing a material from a project, giving the materials toString as the identifier.
     * _D prefix is used for deleting a project from the existing projects panel.
     * maybe these prefixes could be in an enum instead and then appended.
     * @author caleb
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String strActionCommand = e.getActionCommand();
        if(strActionCommand.startsWith("_P")) {//used with editing an existing project
            int index = Integer.parseInt(strActionCommand.substring(2, strActionCommand.length()));
            Project proj = ProjectManager.getProject(index);
            this.remove(displayPanel);
            displayPanel = new ProjectEditPanel(this, proj);
            this.add(displayPanel, BorderLayout.CENTER);
            this.repaint();
            this.validate();

        } else if(strActionCommand.startsWith("_S")) {//used with selecting a project from existing projects panel
            ProjectManager.setCurrentProjectIndex(Integer.parseInt(strActionCommand.substring(2)));
            this.remove(displayPanel);
            this.repaint();
        } else if(strActionCommand.startsWith("_R")){//used for removing a material from a project
            String matToString = strActionCommand.substring(2);
            Project p = ProjectManager.getProject(ProjectManager.getCurrentProjectIndex());
            for(Material mat : p.getMaterials()) {
                if(mat.toString().equals(matToString)) {//remove one of these materials
                    p.removeMaterial(mat);
                    ProjectManager.updateProject(ProjectManager.getCurrentProjectIndex(), p);
                    break;//only delete one 
                }
            }
            this.remove(displayPanel);
            displayPanel = new ProjectMaterialsPanel(this, p);
            this.add(displayPanel, BorderLayout.CENTER);
            this.repaint();
            this.validate();
        } else if(strActionCommand.startsWith("_D")) {//used with deleting a project from list of existing projects panel
            Project p = ProjectManager.getProject(Integer.parseInt(strActionCommand.substring(2)));
            ProjectManager.removeProject(p);
            this.remove(displayPanel);
            displayPanel = new ProjectExistingPanel(this);
            this.add(displayPanel, BorderLayout.CENTER);
            this.repaint();
            this.validate();
        } else {
            COMMAND actionComm = COMMAND.getCommand(e.getActionCommand());
            switch(actionComm) {
                case EDIT_PROJECT: //edit brand new or existing project
                    this.remove(displayPanel);
                    displayPanel = new ProjectEditPanel(this);
                    this.add(displayPanel, BorderLayout.CENTER);
                    this.repaint();
                    this.validate();//used because panel components changed
                    break;
                case EXISTING_PROJECT:
                    this.remove(displayPanel);
                    displayPanel = new ProjectExistingPanel(this);
                    this.add(displayPanel);
                    this.repaint();
                    this.validate();
                    break;
                case MATERIALS:
                    ProjectEditPanel panel = (ProjectEditPanel) displayPanel;
                    panel.updateProject();
                    this.remove(displayPanel);
                    displayPanel = new ProjectMaterialsPanel(this, 
                                                             ProjectManager.getProject(ProjectManager.getCurrentProjectIndex()));
                    this.add(displayPanel);
                    this.repaint();
                    this.validate();
                    break;
                case ADD_RECEIPTS:
                    break;
                case CLOSE_PANEL:
                    this.remove(displayPanel);
                    this.repaint();
                    break;
                case SAVE_PROJECT_EDIT:
                    ProjectEditPanel pan = (ProjectEditPanel) displayPanel;
                    pan.updateProject();
                    this.remove(displayPanel);
                    this.repaint();
                    break;
                default: 
                    System.out.println("action with action command:" + actionComm); 
                    break;
            }

        }

    }



}
