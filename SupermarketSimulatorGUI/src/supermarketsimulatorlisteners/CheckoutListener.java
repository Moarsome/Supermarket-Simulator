/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.ItemDatabase;
import supermarketsimulatorgui.MainPanel;
import supermarketsimulatorgui.User;
import supermarketsimulatorgui.InventoryPanel;

/**
 *
 * @author kyliec
 */

public class CheckoutListener implements ActionListener {
    private MainPanel mainPanel;
    private BodyPanel bodyPanel;
    private InventoryPanel inventoryPanel;
    private Connection connection;
    private User user;
    
    public CheckoutListener(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        try 
        {
            connection = DriverManager.getConnection("jdbc:derby:supermarketDB_Ebd", "super", "market");
        } catch (SQLException ex) 
        {
            Logger.getLogger(CheckoutListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.bodyPanel = mainPanel.getBodyPanel();
        this.user = mainPanel.getUser();
        
        try {
            Statement statement = connection.createStatement();
            JButton checkoutButton = (JButton) e.getSource();
            JButton cancelButton = bodyPanel.getCancelButton();

            // User has enough money
            if (user.hasEnoughMoney() == true)
            {
                // If checkout button is clicked once
                if ((boolean) checkoutButton.getClientProperty("status") == false)
                {
                    checkoutButton.putClientProperty("status", true); 
                    bodyPanel.removeSpace();
                    cancelButton.setVisible(true);
                    String costAfter = String.format("$%.02f", user.getBudget()-user.getCartCost());
                    bodyPanel.setIndicatorText("Click 'checkout' again to confirm or click 'cancel'. Your budget after will be "+costAfter);
                }
                // If checkout button is clicked twice (confirmed checkout)
                else
                {
                    // initiate checkout
                    
                    user.purchaseCart();
                    
                    for (ItemDatabase item:user.getInventory())
                    {
                        try
                        {
                            statement.executeUpdate("INSERT INTO USER_INVENTORY VALUES("+user.getUserID()+","+item.getItemID()+",'"+item.getName()+"')");
                            statement.executeUpdate("UPDATE USERS SET BUDGET = "+user.getBudget()+" WHERE USER_ID = "+user.getUserID());
                        } catch (SQLException ex) {
                            Logger.getLogger(CheckoutListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    user.setInventory(new ArrayList<>());
                    setFinalPanel(user);
                }
            }
            // User does not have enough money
            else
            {
                bodyPanel.setIndicatorText("You do not have enough money! Please remove some items");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setFinalPanel(User user)
    {
        inventoryPanel = mainPanel.getInventoryPanel();
        
        mainPanel.setVisible(false);
        inventoryPanel.setVisible(true);
        
        try {
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM USER_INVENTORY WHERE USER_ID = "+user.getUserID());
            
            while (rs.next())
            {
                ItemDatabase tempItem = getItemFromName(rs.getString("NAME"));
                inventoryPanel.addItemToPanel(tempItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        inventoryPanel.enablePanel();
    }
    
    private ItemDatabase getItemFromName(String itemName)
    {
        for (ItemDatabase item:ItemDatabase.values())
        {
            if (item.getName().equals(itemName))
            {
                return item;
            }
        }
        return null;
    }
}
