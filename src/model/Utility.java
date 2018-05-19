package model;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {

    /**
     * load a file that contains a json object and return the json object saved in that file.
     * look at https://www.mkyong.com/java/json-simple-example-read-and-write-json/ 
     * for info on how to parse the json object.
     * @autho caleb
     */
    public static JSONObject loadFile(String theFilePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(theFilePath));
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(obj != null) {
            jsonObject = (JSONObject) obj;
        }
        
        return jsonObject;
    }

    /**
     * look at https://crunchify.com/how-to-write-json-object-to-file-in-java/
     * for how to create a json object to be saved.
     * @author caleb
     */
    public static void saveFile(JSONObject theObjectToSave, String theFilePath) {
        try(FileWriter file = new FileWriter(theFilePath)){
            file.write(theObjectToSave.toJSONString());
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
