/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author kyliec
 */
public class SupermarketFrame extends JFrame{
    public static void main(String[] args) 
    {
        SupermarketFrame frame = new SupermarketFrame();
        MainPanel mainPanel = new MainPanel();
        LoginPanel loginPanel = new LoginPanel(mainPanel);
        loginPanel.setVisible(false);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.getHSBColor(.678f, 0.46f, 1.0f));
        frame.add(loginPanel);
        frame.add(mainPanel);
        frame.setSize(750,750);
        frame.setVisible(true);
    }
}
