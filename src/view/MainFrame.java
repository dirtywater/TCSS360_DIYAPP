package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Utility;
import model.ProjectManager;
import model.ShopSim;
import view.panel.AboutPanel;
import view.panel.DisplayPanel;
import view.panel.ProjectPanel;
import view.panel.SettingsPanel;
import view.panel.ShopPanel;


/**
 * The Main frame the user sees. It houses the home screen and its buttons.
 *
 * @author Jim Phan phanjim2@hotmail.com Jim Was here
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
    
    /**
     * Creates the panel that will hold all of the buttons to navigate to different pages.
     * 
     * @param width
     * @param height
     * @return
     * @throws IOException
     */
    private JPanel createSidePanel(int width, int height) throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(width, height));
        
        panel.add(createButton("Home", "home_button.png"));
        panel.add(createButton("Projects", "projects_button.png"));
        panel.add(createButton("Graph", "efficiency_button.png"));
        panel.add(createButton("Shop", "shop_button.png"));
        panel.add(createButton("About", "about_button.png"));
        panel.add(createButton("Settings", "settings_button.png"));
        return panel;
    }
    
    /**
     * Creates a specific button for the SidePanel menu that will be used
     * to access its corresponding "page".
     * 
     * @param name
     * @param icon
     * @return
     * @throws IOException
     * 
     * @author Jim
     * @author Michelle
     */
    private JButton createButton(String name, String icon) throws IOException {
        ProjectManager.loadProjects();
        Image image = ImageIO.read(new File(icon));
        image = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
        ImageIcon button_image = new ImageIcon(image);
        JButton button = new JButton(button_image);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.remove(dynamicPanel);
                dynamicPanel = createPanel(name);
                displayPanel.add(dynamicPanel, BorderLayout.CENTER);
                validate();
            }
        });
        return button;
    }
    
    /**
     * A pseudo DisplayPanel factory that creates the panel to display
     * based on the button pressed in the SidePanel.
     * 
     * @param name
     * @return
     */
    private JPanel createPanel(String name) {
        JPanel panel;
        
        if(name.equals("Home")) {
            panel = new DisplayPanel(Color.BLACK, frameDimension);
        } else if(name.equals("Projects")) {
            panel = new ProjectPanel(new Dimension((int)(frameDimension.getWidth()*(1-SIDE*1.4)),
                                                  (int)(frameDimension.getHeight()*(REDUCTION))));
        } else if(name.equals("Graph")){
            panel = new DisplayPanel(Color.GREEN, frameDimension);
        } else if(name.equals("Shop")) {
            
            ShopSim testStore = new ShopSim();
            //panel = new DisplayPanel(Color.RED, frameDimension);
            
            panel = new ShopPanel(testStore);
            
        } else if(name.equals("About")){
            String aboutText = "";
            try {
                aboutText = Utility.ReadTextFile("testAbout.txt");
            } catch (FileNotFoundException e) {
                aboutText = "file not found";
                e.printStackTrace();
            }
            
            panel = new AboutPanel(aboutText);
            
        } else if(name.equals("Settings")){
            panel = new SettingsPanel(frameDimension);
        } else {
            panel = new DisplayPanel(Color.ORANGE, frameDimension);
        }
        return panel;
    }
    
    /**
     * change the title of the frame to reflect the current project.
     * @param title
     * @author caleb
     */
    public void SetTitle(String title) {
        this.setTitle("DIY Project\t -" + title);
        
        
    }
    
}
