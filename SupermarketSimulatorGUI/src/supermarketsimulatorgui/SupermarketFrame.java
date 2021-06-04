/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.*;
import supermarketsimulatorguidb.DBManager;

/**
 *
 * @author kyliec
 */
public class SupermarketFrame extends JFrame{

    /**
     * Creates JFrame for program
     * 
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException 
    {
        DBManager dbManager = new DBManager();
        SupermarketFrame frame = new SupermarketFrame();
        
        createPanels(frame);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.getContentPane().setBackground(Color.getHSBColor(.678f, 0.46f, 1.0f));
        frame.pack();
        frame.getContentPane().requestFocusInWindow();
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    /**
     * Creates panels for JFrame
     * 
     * @param frame
     */
    public static void createPanels(JFrame frame)
    {
        User user = new User();
        
        InventoryPanel inventoryPanel = new InventoryPanel(frame);
        MainPanel mainPanel = new MainPanel(user, inventoryPanel);
        LoginPanel loginPanel = new LoginPanel(mainPanel, user);
        
        mainPanel.setVisible(false);
        inventoryPanel.setVisible(false);
        
        frame.add(inventoryPanel);
        frame.add(loginPanel);
        frame.add(mainPanel);
        frame.validate();
        frame.repaint();
    }
    
    /**
     * Removes panels from JFrame
     * 
     * @param frame
     */
    public static void removePanels(JFrame frame)
    {
        frame.getContentPane().removeAll();
    }
}
