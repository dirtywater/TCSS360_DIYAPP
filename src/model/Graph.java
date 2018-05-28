package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int graphEnd;
    
    private List<Receipt> graphReceipt;
    
    public Graph(List<Receipt> receipts) {
        graphReceipt = new ArrayList<Receipt>();
        if(receipts != null) {
            for(Receipt entry : receipts) {
                graphReceipt.add(entry);
            }
        }
    }
    
    
}
