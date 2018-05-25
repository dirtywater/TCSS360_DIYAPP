package view.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Material;
import model.ShopSim;
import model.Utility;

/**
 * Panel to display about information from the string passed in.
 * 
 * @author Caleb Wheeler
 * @version Apr 28, 2018
 */
public class ShopPanel extends JPanel {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = 7999942536513877098L;
    
    /**
     * Used to set the frame's title.
     */
    public static final String FRAME_TITLE = "About";
    
    
    GridLayout thisLayout = new GridLayout(0,3);
    
    /**
     * Takes in text to display in a panel and a minimum size the panel can be displayed in.
     * @param aboutText the text to display
     * @param width minimum width of the panel
     * @param height minimum height of the panel
     */
    public ShopPanel(ShopSim testStore) {
        
        String aboutText;
        
        for (Material mat: testStore.getMyMaterials()) {
            aboutText = Utility.convertToHTML(mat.toString());
            JButton about = new JButton(aboutText);
            this.add(about);
        }
        this.setLayout(thisLayout);
        this.setAutoscrolls(true);
        this.setBorder(new LineBorder(Color.BLACK));
        
    }
    
}
