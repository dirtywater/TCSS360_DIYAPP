package view.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * The JPanel class used to display different panels.
 *
 * @author Jim Phan phanjim2@hotmail.com
 * @version May 17, 2018
 */
public class DisplayPanel extends JPanel {

	public DisplayPanel(Color color) {
		this.setBackground(color);
		this.setPreferredSize(new Dimension(500,500));
	}
}
