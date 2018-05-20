package view;

import org.json.simple.JSONObject;

import model.Utility;

public class Setting {

    public String myFirstName;
    public String myEmail;
    
    //where the file should be saved
    private final String SETTING_FILE_PATH = "userSettings.json";
    
    //constants for json keys
    private final String KEY_NAME = "First Name";
    private final String KEY_EMAIL = "Email";
    
    
    public Setting() {
        loadSettings();
    }
    
    //link for understanding json format
    //https://www.geeksforgeeks.org/parse-json-java/
    
    /**
     * load the saved json object and set first name and email by given keys in json file.
     * @param filePath
     * @author caleb
     */
    private void loadSettings() {
        JSONObject jObj = Utility.loadFile(SETTING_FILE_PATH);
        if(jObj != null) {
             myFirstName = (String) jObj.get(KEY_NAME);
             myEmail = (String) jObj.get(KEY_EMAIL);
        } 

    }
    
    /**
     * save the settings to file as a json object.
     * @param name user given first name for settings.
     * @param email user given email.
     * @author caleb
     */
    public void saveSettings(String name, String email) {
        JSONObject obj = new JSONObject();
        obj.put(KEY_NAME, name);
        obj.put(KEY_EMAIL, email);
        
        Utility.saveFile(obj, SETTING_FILE_PATH);
    }
}




