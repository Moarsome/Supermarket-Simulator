/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
        FooterPanel footerPanel = new FooterPanel();
        BodyPanel bodyPanel = new BodyPanel();
        HeaderPanel headerPanel = new HeaderPanel(bodyPanel);
        LoginPanel loginPanel = new LoginPanel();
        
        hideMain(bodyPanel,headerPanel,footerPanel);
        loginPanel.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.getHSBColor(.678f, 0.46f, 1.0f));
        frame.add(loginPanel);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bodyPanel);
        frame.add(footerPanel, BorderLayout.SOUTH);
        frame.setSize(750,750);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public static void hideMain(JPanel p1, JPanel p2, JPanel p3)
    {
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
    }
}
