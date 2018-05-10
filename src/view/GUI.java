package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * The graphical user interface used to show the user.
 *
 * @author Jim Phan phanjim2@hotmail.com
 * @version Apr 26, 2018
 */
public class GUI {
	
	/**
	 * The Title of the Frame.
	 */
	private static final String TITLE = "About";
	
	/**
	 * The JFrame used to display to the user.
	 */
	private JFrame myFrame;
	
	/**
	 * The constructor. Used to starts the frame.
	 */
	public GUI() {
		myFrame = new MainFrame();
	}
	
	/**
	 * Initialize the frame and starts the program.
	 */
	public void start() {
		myFrame.setTitle(TITLE);
	}
	
	/**
	 * Ends and dispose of the frame.
	 */
	public void end() {
		myFrame.dispose();
		System.exit(0);
	}
}
