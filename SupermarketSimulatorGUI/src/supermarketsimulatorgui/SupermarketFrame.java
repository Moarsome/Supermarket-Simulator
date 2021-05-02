/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author kyliec
 */
public class SupermarketFrame extends JFrame{
    static JFrame frame;
    static JPanel headerPanel;
    static JPanel bodyPanel;
    
    public static void main(String[] args) 
    {
        frame = new JFrame();
        headerPanel = new HeaderPanel(frame);
        bodyPanel = new BodyPanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(.678f, 0.46f, 1.0f));
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bodyPanel);
        frame.pack();
        frame.setSize(700,700);
        frame.setVisible(true);
    }
}
