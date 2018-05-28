package view.panel;

import java.awt.Graphics;
import java.time.LocalDate;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Project;
import model.Receipt;

public class ReportPanel extends JPanel {

    private Project reportProject;
    
    public ReportPanel(Project project) {
        reportProject = project;
        JLabel label = new JLabel();
        label.setText(toString());
    }
    
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        
    }
    
    @Override
    public String toString() {
        if(reportProject == null) {
            return "No project available";
        }
        reportProject.getReceipts().sort(new Comparator<Receipt>() {

            @Override
            public int compare(Receipt o1, Receipt o2) {
                return o1.date.compareTo(o2.date);
            }
            
        });
        StringBuilder report = new StringBuilder();
        report.append("Date: " + reportProject.getDateCreated().toString() + "\n");
        report.append("Project Name: " + reportProject.getTitle() + "\n");
        
        int year = 0, month = 0, day = 0;
        for(Receipt entry : reportProject.getReceipts()) {
            LocalDate date = entry.date;
            if(date.getYear() != year || date.getMonthValue() != month 
                            || date.getDayOfMonth() != day) {
                year = date.getYear();
                month = date.getMonthValue();
                day = date.getDayOfMonth();
                report.append("\nDate of Purchase: " + month + "/" 
                                + day + "/" + year + "\n");
            }
            report.append(entry.title + ": $" + entry.cost + "\n");
            if(entry.note != null) {
                report.append("Note: " + entry.note + "\n");
            }
        }
        return report.toString();
    }
}
