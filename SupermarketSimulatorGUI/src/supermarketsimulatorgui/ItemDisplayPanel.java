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
import supermarketsimulatorlisteners.ItemSelectListener;

/**
 *
 * @author kyliec
 */
public class ItemDisplayPanel extends StarterPanel {
    private MainPanel mainPanel;
    private IsleMarker isleManagement;
    private int isleNum;
    
    public ItemDisplayPanel(MainPanel mainPanel, IsleMarker isleManagement, int isleNum) 
    {
        this.mainPanel = mainPanel;
        this.setMaximumSize(new Dimension(750, 320));
        this.setLayout(new GridBagLayout());
        this.isleManagement = isleManagement;
        this.isleNum = isleNum;

        addPanels(this);
        
        this.setOpaque(false);
    }

    private void addPanels(JPanel panel){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.weighty = 1.0;
        c.insets = new Insets(10,5,30,5);
        c.fill = GridBagConstraints.NONE;
        
        for (int row = 0; row < 3; row++)
        {
            ItemDatabase tempItem = isleManagement.getItem(row, isleNum);
            for (int column = 0; column < 8; column++)
            {
                changeGridLayout(c, column, row);
                JButton tempButton = createNewButton(resizeComponent(tempItem.getImgURL(), 65, 65));
                tempButton.putClientProperty("item", tempItem);
                tempButton.putClientProperty("selected", false);
                tempButton.addActionListener(new ItemSelectListener(mainPanel, isleManagement));
                panel.add(tempButton, c);
            }
        }
    }
}
