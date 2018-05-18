package view;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.ReadTextFile;

/**
 * The Main frame the user sees. It houses the home screen and its buttons.
 *
 * @author Jim Phan phanjim2@hotmail.com Jim Was here
 * @author Michelle Brown
 * 
 * @version Apr 29, 2018
 */
public class MainFrame extends JFrame {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = -7259295803716311757L;

    /**
     * The JPanel that's displayed to the user.
     */
    private JPanel displayPanel;

    /**
     * The JPanel that handles the change of the display panel.
     */
    private JPanel dynamicPanel;

    /**
     * The constructor. Initialize the values of the frame and sets up the panels.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        dynamicPanel = new JPanel();

        String aboutText = null;
        try {
            aboutText = new ReadTextFile("testAbout.txt").myText;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: about file missing", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); //fix it later so it will stay open
        }
        displayPanel = new AboutPanel(aboutText);

        add(dynamicPanel);
        dynamicPanel.add(displayPanel);

        setMinimumSize(this.getPreferredSize());
        setMaximumSize(this.getPreferredSize());
    }
}
