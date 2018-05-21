package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;

public class Setting {

    public String myFirstName;
    public String myEmail;

    //where the file should be saved
    //    private final String SETTING_FILE_PATH = "userSettings.json";
    private final String SETTING_FILE_PATH = "userSettings.txt";

    //constants for json keys
//    private final String KEY_NAME = "First Name";
//    private final String KEY_EMAIL = "Email";


    public Setting() {
        loadSettings();
    }

    //link for understanding json format
    //https://www.geeksforgeeks.org/parse-json-java/

    /**
     * load the saved json object and set first name and email by given keys in json file.
     * @param filePath
     * @author caleb & michelle
     */
    private void loadSettings() {
        File file = new File(SETTING_FILE_PATH);
        if (!file.exists()) {
            if (file.mkdir()) {
                myFirstName = "name";
                myEmail = "email@something.com";
                saveSettings(myFirstName, myEmail);
            }
        } else {
//            JSONObject jObj = Utility.loadFile(SETTING_FILE_PATH);
//            if(jObj != null) {
//                myFirstName = (String) jObj.get(KEY_NAME);
//                myEmail = (String) jObj.get(KEY_EMAIL);
//            }
            //TODO David
            //------read from the file into the variables
            //------myFirstName &
            //------myEmail
        }
    }

    /**
     * save the settings to file as a json object.
     * @param name user given first name for settings.
     * @param email user given email.
     * @author caleb
     */
    public void saveSettings(String name, String email) {
//        JSONObject obj = new JSONObject();
//        obj.put(KEY_NAME, name);
//        obj.put(KEY_EMAIL, email);
//        Utility.saveFile(obj, SETTING_FILE_PATH);
        //TODO David
        //------write the variables to the text file in a format that you will read from again
        //------myFirstName &
        //------myEmail
    }
}

