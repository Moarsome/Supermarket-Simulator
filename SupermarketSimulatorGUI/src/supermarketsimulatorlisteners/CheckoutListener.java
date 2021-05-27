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
import javax.swing.JButton;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.MainPanel;

/**
 *
 * @author kyliec
 */

public class CheckoutListener implements ActionListener {
    private BodyPanel bodyPanel;
    private Connection connection;
    
    public CheckoutListener(MainPanel mainPanel)
    {
        bodyPanel = mainPanel.getBodyPanel();
        
        try 
        {
            connection = DriverManager.getConnection("jdbc:derby:supermarketDB_Ebd", "super", "market");
        } catch (SQLException ex) 
        {

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton checkoutButton = (JButton) e.getSource();
        
        
    }
    
}
