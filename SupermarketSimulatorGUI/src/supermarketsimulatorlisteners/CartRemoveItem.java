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
import supermarketsimulatorgui.ItemDatabase;
import supermarketsimulatorgui.MainPanel;
import supermarketsimulatorgui.User;

/**
 *
 * @author kyliec
 */
public class CartRemoveItem implements ActionListener {

    private MainPanel mainPanel;
    private FooterPanel footerPanel;
    private BodyPanel bodyPanel;
    private HeaderPanel headerPanel;
    private User user;
    
    public CartRemoveItem(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        this.footerPanel = mainPanel.getFooterPanel();
        this.bodyPanel = mainPanel.getBodyPanel();
        this.headerPanel = mainPanel.getHeaderPanel();
        this.user = mainPanel.getUser();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectedButton = (JButton) e.getSource();
        ItemDatabase item = (ItemDatabase) selectedButton.getClientProperty("item");
        JButton currentlySelected = footerPanel.getSelectedButton();
        
        if (selectedButton != currentlySelected)
        {
            if (currentlySelected != null)
            {
               currentlySelected.setBorderPainted(false);
            }
            footerPanel.setSelectedButton(selectedButton);
            selectedButton.setBorderPainted(true);

            bodyPanel.setIndicatorText("Selected: $"+item.getPrice()+" '"+item.getName()+"' in inventory, click again to remove");
        }
        else
        {
            // Remove item from inventory
            selectedButton.setVisible(false);
            user.removeFromInventory(item);
            headerPanel.setCartLabel(user.getCartCost());
            bodyPanel.setIndicatorText("'"+item.getName()+"' removed from cart!");
            footerPanel.setSelectedButton(null);
        }
    }
    
}
