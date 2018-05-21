package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.ReadTextFile;
import model.Utility;
import view.panel.DisplayPanel;


/**
 * The Main frame the user sees. It houses the home screen and its buttons.
 *
 * @author Jim Phan phanjim2@hotmail.com Jim Was here
 * @author Michelle
 * 
 * @version Apr 29, 2018
 */
public class MainFrame extends JFrame {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = -7259295803716311757L;
    
    /**
     * The reduction value used on the computer's screen resolution.
     */
    private static final double REDUCTION = 0.75;
    
    /**
     * Reduction used for the side panel.
     */
    private static final double SIDE = 0.10;
    
    /**
     * The panel that is held to the frame.
     */
    private JPanel displayPanel;
    
    /**
     * The current panel that's displayed to the user.
     */
    private JPanel dynamicPanel;
    
    /**
     * The Side Panel that houses the buttons.
     */
    private JPanel sidePanel;
    
    /**
     * The dimension of the frame.
     */
    private Dimension frameDimension;
    
    /**
     * a class that holds some helper utility methods
     */
    private Utility utility;
    
    /**
     * The constructor. Initialize the values of the frame and sets up the panels.
     * 
     * @param width Width of the frame.
     * @param height Height of the frame.
     * @throws IOException 
     */
    public MainFrame(int width, int height) throws IOException {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setSize(new Dimension(width, height));
        frameDimension = new Dimension((int)(size.getWidth() * REDUCTION),
                (int)(size.getHeight() * REDUCTION));
        setSize(new Dimension((int)(frameDimension.getWidth()),
                (int)frameDimension.getHeight()));
        dynamicPanel = new JPanel();
        displayPanel = new JPanel(); //Replace with Caleb's code.
        sidePanel = createSidePanel((int)(frameDimension.width * SIDE),
                (int)(frameDimension.height * REDUCTION));
        add(sidePanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.EAST);
        displayPanel.add(dynamicPanel);
    }
    
    private JPanel createSidePanel(int width, int height) throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(width, height));
        
        panel.add(createButton("Home", "Home"));
        panel.add(createButton("Projects", "Projects"));
        panel.add(createButton("Graph", "Graph"));
        panel.add(createButton("Shop", "Shop"));
        panel.add(createButton("About", "About"));
        panel.add(createButton("Settings", "Settings"));
        return panel;
    }
    
    private JButton createButton(String name, String icon) throws IOException {
        JButton button = new JButton(name);

        //Image image = ImageIO.read(new File(icon));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.remove(dynamicPanel);
                dynamicPanel = createPanel(button.getText());
                displayPanel.add(dynamicPanel, BorderLayout.CENTER);
                validate();
            }
        });
        return button;
    }
    
    private JPanel createPanel(String name) {
        JPanel panel;
        utility = new Utility();
        if(name.equals("Home")) {
            panel = new DisplayPanel(Color.BLACK, frameDimension);
        } else if(name.equals("Projects")){
            panel = new DisplayPanel(Color.BLUE, frameDimension);
        } else if(name.equals("Graph")){
            panel = new DisplayPanel(Color.GREEN, frameDimension);
        } else if(name.equals("Shop")) {
            panel = new DisplayPanel(Color.RED, frameDimension);
        } else if(name.equals("About")){
            String aboutText = "";
            try {
                aboutText = utility.ReadTextFile("testAbout.txt");
            } catch (FileNotFoundException e) { e.printStackTrace(); }
            panel = new AboutPanel(aboutText);
        } else if(name.equals("Settings")){
            panel = new SettingsPanel(frameDimension);
        } else {
            panel = new DisplayPanel(Color.ORANGE, frameDimension);
        }
        return panel;
    }
}
