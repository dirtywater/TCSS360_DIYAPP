package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import main.ReadTextFile;

/**
 * The Main frame the user sees. It houses the home screen and its buttons.
 *
 * @author Jim Phan phanjim2@hotmail.com
 * @version Apr 26, 2018
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
	 * 
	 * @param width Width of the frame.
	 * @param height Height of the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		dynamicPanel = new JPanel();
		
		displayPanel = new AboutPanel(new ReadTextFile("testAbout.txt").myText);
		
		add(dynamicPanel);
		dynamicPanel.add(displayPanel);

		setMinimumSize(this.getPreferredSize());
		setMaximumSize(this.getPreferredSize());
	}
}
