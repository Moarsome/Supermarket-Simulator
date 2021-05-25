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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kyliec
 */
public class ItemDisplayPanel extends StarterPanel {
    
    private IsleMarker isleManagement;

    public ItemDisplayPanel(IsleMarker isleManagement) {
        this.setMaximumSize(new Dimension(750, 350));
        this.setLayout(new GridBagLayout());
        this.isleManagement = isleManagement;
                
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
            ItemDatabase tempItem = isleManagement.getItem(row);
        for (int column = 0; column < 8; column++)
            {
                changeGridLayout(c, column, row);
                JButton tempButton = createNewButton(resizeComponent(tempItem.getImgURL(), 50, 80));
                tempButton.putClientProperty(tempItem, tempItem.getName());
                panel.add(tempButton, c);
            }
        }
        
        
    }
}
