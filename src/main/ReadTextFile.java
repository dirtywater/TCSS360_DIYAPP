package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The main method that runs the program.
 *
 * @author Jim Phan & David Guerrero phanjim2@hotmail.com, dirtywater365@gmail.com
 * @version Apr 26, 2018
 */
public class ReadTextFile {
    
    public String myText = "";
    


    public ReadTextFile(String FileName) {
        FileReader inputStream = null;
        try {
            inputStream = new FileReader(FileName);
            BufferedReader bufferedStream = new BufferedReader(inputStream);
            String line;
            int count = 0;
            while ((line = bufferedStream.readLine()) != null) {
                myText += line + "\n";
            }
                bufferedStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       
    }
    
    
}
