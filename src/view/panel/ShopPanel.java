package view.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import model.Material;
import model.Project;
import model.ProjectManager;
import model.ShopSim;
import model.Utility;

/**
 * 
 * @author David
 */
public class ShopPanel extends JPanel {

    /**
     * Serial code of the class.
     */
    private static final long serialVersionUID = 7999942536513877098L;
    
    /**
     * Used to set the frame's title.
     */
    public static final String FRAME_TITLE = "Shop Sim";
    
    
    GridLayout thisLayout = new GridLayout(0,3);
    
    /**
     * Takes in text to display in a panel and a minimum size the panel can be displayed in.
     * @param aboutText the text to display
     * @param width minimum width of the panel
     * @param height minimum height of the panel
     * @author David
     * @author caleb
     */
    public ShopPanel(ShopSim testStore) {
        String materialText;
        for (Material mat: testStore.getMyMaterials()) {
            materialText = Utility.convertToHTML(mat.toString());
            JButton btnMaterial = new JButton(materialText);
            btnMaterial.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Integer index = ProjectManager.getCurrentProjectIndex();
                    Project p = ProjectManager.getProject(index);
                    p.addMaterial(mat);
                    ProjectManager.updateProject(index, p.getTitle(), p.getMaterials(), p.getReceipts());
                }
                
            });
            this.add(btnMaterial);
        }
        this.setLayout(thisLayout);
        this.setAutoscrolls(true);
        this.setBorder(new LineBorder(Color.BLACK));
    }
    
}

