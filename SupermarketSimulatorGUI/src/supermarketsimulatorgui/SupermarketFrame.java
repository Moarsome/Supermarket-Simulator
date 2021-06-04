/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import javax.swing.*;
import supermarketsimulatorguidb.DBManager;

/**
 *
 * @author kyliec
 */
public class SupermarketFrame extends JFrame{
    public static void main(String[] args) 
    {
        DBManager dbManager = new DBManager();
        
        User user = new User();
        SupermarketFrame frame = new SupermarketFrame();
        InventoryPanel inventoryPanel = new InventoryPanel();
        MainPanel mainPanel = new MainPanel(user, inventoryPanel);
        LoginPanel loginPanel = new LoginPanel(mainPanel, user);
        inventoryPanel.setLoginPanel(loginPanel);
        
        mainPanel.setVisible(false);
        inventoryPanel.setVisible(false);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.getContentPane().setBackground(Color.getHSBColor(.678f, 0.46f, 1.0f));
        frame.add(inventoryPanel);
        frame.add(loginPanel);
        frame.add(mainPanel);
        frame.pack();
        frame.getContentPane().requestFocusInWindow();
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
