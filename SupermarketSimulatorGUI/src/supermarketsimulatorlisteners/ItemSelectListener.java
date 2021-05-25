/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.HeaderPanel;
import supermarketsimulatorgui.IsleMarker;
import supermarketsimulatorgui.ItemDatabase;
import supermarketsimulatorgui.MainPanel;
import supermarketsimulatorgui.User;

/**
 *
 * @author kyliec
 */

public class ItemSelectListener implements ActionListener{
    private JButton currentlySelected;
    private MainPanel mainPanel;
    private BodyPanel bodyPanel;
    private HeaderPanel headerPanel;
    private IsleMarker isleManagement;
    private User user;
    
    public ItemSelectListener(MainPanel mainPanel, IsleMarker isleManagement)
    {
        this.mainPanel = mainPanel;
        this.bodyPanel = mainPanel.getBodyPanel();
        this.isleManagement = isleManagement;
        this.user = mainPanel.getUser();
        this.headerPanel = mainPanel.getHeaderPanel();
        
        currentlySelected = isleManagement.getSelectedItem();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton selectedButton = (JButton) e.getSource();
        ItemDatabase item = (ItemDatabase) selectedButton.getClientProperty("item");
        currentlySelected = isleManagement.getSelectedItem();
        
        if (selectedButton != currentlySelected)
        {
            if (currentlySelected != null)
            {
               currentlySelected.putClientProperty("selected", false);
               currentlySelected.setBorderPainted(false);
            }
            isleManagement.setSelectedItem(selectedButton); 
            selectedButton.putClientProperty("selected", true);
            selectedButton.setBorderPainted(true);

            bodyPanel.setIndicatorText("Selected: $"+item.getPrice()+" "+item.getName()+", click again to buy");
        }
        else
        {
            selectedButton.setEnabled(false);
            selectedButton.setVisible(false);
            user.addInventory(item);
            headerPanel.setCartLabel(user.getCartCost());
            bodyPanel.setIndicatorText(item.getName()+" added to cart!");
        }
    }
}
