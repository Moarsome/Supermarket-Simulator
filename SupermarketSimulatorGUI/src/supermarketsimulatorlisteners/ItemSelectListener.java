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
import supermarketsimulatorgui.FooterPanel;
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
    private FooterPanel footerPanel;
    private IsleMarker isleManagement;
    private User user;
    
    public ItemSelectListener(MainPanel mainPanel, IsleMarker isleManagement)
    {
        this.mainPanel = mainPanel;
        this.isleManagement = isleManagement;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.bodyPanel = mainPanel.getBodyPanel();
        this.footerPanel = mainPanel.getFooterPanel();
        this.user = mainPanel.getUser();
        this.headerPanel = mainPanel.getHeaderPanel();
        
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

            bodyPanel.setIndicatorText("Selected: $"+item.getPrice()+" '"+item.getName()+"', click again to buy");
        }
        else
        {
            // Add item to inventory
            selectedButton.setEnabled(false);
            selectedButton.setBorderPainted(false);
            user.addInventory(item);
            headerPanel.setCartLabel(user.getCartCost());
            footerPanel.addItemToCart(item).putClientProperty("button", selectedButton);
            bodyPanel.setIndicatorText("'"+item.getName()+"' added to cart!");
            currentlySelected = null;
        }
    }
}
