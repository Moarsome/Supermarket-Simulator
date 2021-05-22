/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author kyliec
 */
public class BodyPanel extends StarterPanel 
{
    private JLabel shelves;
    private JLabel isleLabel;
    
    public BodyPanel() 
    {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        ImageIcon shelvesImage = new ImageIcon("./resources/shelves.png");
        Image image = shelvesImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(600, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        shelvesImage = new ImageIcon(newimg);
        
        isleLabel = new JLabel("ISLE 1 - DRINKS");
        isleLabel.setFont(new Font("Avenir", Font.PLAIN, 30));
        isleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        shelves = new JLabel(shelvesImage);
        shelves.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.setOpaque(false);
        this.add(isleLabel);
        this.addSpace(this,0, 40);
        this.add(shelves);
    }
    
    public void setIsleLabel(String newText)
    {
        this.isleLabel.setText(newText);
    }
}
