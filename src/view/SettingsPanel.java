package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Setting;
import model.Utility;

/**
 * Panel to display the current user settings. Gives an option to change them
 * and export to file to sync to other devices at a later point.
 * 
 * @author Michelle
 */
public class SettingsPanel extends JPanel {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = 7580098800162278826L;

    /**
     * Used to set the frame's title.
     */
    public static final String FRAME_TITLE = "Settings";

    /**
     * The user's settings recovered from a local json file
     */
    Setting userSettings;

    /**
     * The user's saved name
     */
    private String name;
    
    /**
     * The user's saved email
     */
    private String email;
    
    
    //where the file should be saved
    private final String SETTING_FILE_PATH = "userSettings.json";

    /**
     * The constructor that creates the panel where the user can
     * see all of their custom user settings
     * 
     * @param size
     */
    public SettingsPanel (Dimension size) {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.setSize(size);
        userSettings = new Setting();
        name = userSettings.myFirstName; //not working
//        name = "name";
        email = userSettings.myEmail; //not working
//        email = "email@something.com";

        String text = "Current Settings:\nName: ";
        StringBuilder sb = new StringBuilder(text);
        sb.append(name);
        sb.append("\nEmail: ");
        sb.append(email);
        Utility utility = new Utility();
        text = utility.convertToHTML(text);
        JLabel savedSettings = new JLabel(text);
        this.add(savedSettings);

        JLabel newSettings = new JLabel(utility.convertToHTML("\n\nChange Settings:\n"));
        //say Name:
        JTextField nameField = new JTextField(name, 10);
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
            }
        });
        newSettings.add(nameField);
        //say Email:
        JTextField emailField = new JTextField(userSettings.myEmail, 10);
        emailField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailField.getText();
            }
        });
        newSettings.add(emailField);
        this.add(newSettings);

        JButton saveButton = new JButton("save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.saveSettings(name, email);
            }
        });
        this.add(saveButton);

        this.setBorder(new LineBorder(Color.BLACK));
    }

}
