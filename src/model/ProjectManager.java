package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ProjectManager implements Serializable{
    
    /**
     * Don't change unless this is no longer compatible with previous serialized files.
     */
    private static final long serialVersionUID = 1591199260729617379L;

    private static ArrayList<Project> myProjects = new ArrayList<Project>();
    
    //where the file should be saved
    //private final String PROJECT_FILE_PATH = "projects.json";
    private final static String PROJECT_FILE_PATH = "projects.ser";
    
    //constants for json keys
    //private final String KEY_PROJECTS = "Projects";

    private ProjectManager() {}
    
    /**
     * used to get a particular project, might return null if that project doesn't exist.
     * @param index
     * @return the project at index
     * @author caleb
     */
    public static Project getProject(int index) {
        return myProjects.get(index);
    }
    
    /**
     * gives the index in the list of projects of the searched project or -1 if not found.
     * @param index
     * @return the project at index
     * @author caleb
     */
    public static int getIndex(Project theProject) {
        for(int i = 0; i < myProjects.size(); i++) {
            if(myProjects.get(i).equals(theProject)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * gives total number of projects.
     * @return
     */
    public static int count() {
        return myProjects.size();
    }
    
    /**
     * save all the projects in projectManager.
     * @author caleb
     */
    public static void saveProjects() {
        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream(PROJECT_FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myProjects);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * load all projects in project manager.
     * @author caleb
     */
    public static void loadProjects() {
        // read object from file
        try {
            FileInputStream fis = new FileInputStream(PROJECT_FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myProjects = (ArrayList<Project>) ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * adds the new project to the list then saves the updated list of all projects.
     * @param theProject
     * @author caleb
     */
    public static void addProject(Project theProject) {
        myProjects.add(theProject);
        saveProjects();
    }
    
    /**
     * removes the new project to the list then saves the updated list of all projects.
     * @param theProject
     * @author caleb
     */
    public static void removeProject(Project theProject) {
        myProjects.remove(theProject);
        saveProjects();
    }
    
}
