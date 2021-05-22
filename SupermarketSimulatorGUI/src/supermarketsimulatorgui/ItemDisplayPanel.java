/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kyliec
 */
public class ItemDisplayPanel extends StarterPanel {

    public ItemDisplayPanel(IsleMarker isleManagement) {
        this.setMaximumSize(new Dimension(750, 350));
        this.setLayout(new GridBagLayout());
                
        addPanels(this);
        
        this.setOpaque(false);
        
    }

    private void addPanels(JPanel panel){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weighty = 1.0;
        c.insets = new Insets(10,10,30,10);
        c.fill = GridBagConstraints.NONE;
        
        for (int row = 0; row < 3; row++)
        {
        for (int column = 0; column < 8; column++)
            {
                changeGridLayout(c, column, row);
                JButton tempButton = createNewButton(resizeComponent("./resources/items/coca_cola.png", 50, 80));
                tempButton.putClientProperty("insert itemDatabase obj here", "maybe its name here??");
                panel.add(tempButton, c);
            }
        }
        
        
    }
}
