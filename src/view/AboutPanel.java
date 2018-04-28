package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Panel to display about information from the string passed in.
 * 
 * @author Caleb Wheeler
 * @version Apr 28, 2018
 */
public class AboutPanel extends JPanel {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = 7999942536513877098L;
    
    /**
     * Used to set the frame's title.
     */
    public static final String FRAME_TITLE = "About";
    
    /**
     * Takes in text to display in a panel and a minimum size the panel can be displayed in.
     * @param aboutText the text to display
     * @param width minimum width of the panel
     * @param height minimum height of the panel
     */
    public AboutPanel(String aboutText, int width, int height) {
        Dimension size = new Dimension();
        size.setSize(width, height);
        this.setMinimumSize(size);
        
        aboutText = convertToHTML(aboutText);
        JLabel about = new JLabel(aboutText, SwingConstants.CENTER);
        this.add(about);
        this.setBorder(new LineBorder(Color.BLACK));
    }

    /**
     * The jlabel can display html.
     * @param aboutText the text to show 
     * @return returns an html 
     */
    private String convertToHTML(String aboutText) {
        return "<html>" + aboutText
                        .replaceAll("<", "&lt;")
                        .replaceAll(">", "&gt;")
                        .replaceAll("\n", "<br/>")
                        + "</html>";
    }
    
}
