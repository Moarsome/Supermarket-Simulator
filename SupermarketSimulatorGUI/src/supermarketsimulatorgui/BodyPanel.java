/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author kyliec
 */
public class BodyPanel extends JPanel 
{
    private JLabel shelves;
    private JLabel isleLabel;
    
    public BodyPanel() 
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0,20));
        
        ImageIcon shelvesImage = new ImageIcon("./resources/shelves.png");
        Image image = shelvesImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(650, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        shelvesImage = new ImageIcon(newimg);
        
        isleLabel = new JLabel("ISLE 1 - DRINKS");
        isleLabel.setFont(new Font("Open Sans", Font.PLAIN, 30));
        
        shelves = new JLabel(shelvesImage);
        
        this.setOpaque(false);
        this.addSpace(this);
        this.add(isleLabel);
        this.addSpace(this);
        this.add(shelves);
    }

    public void addSpace(JPanel panel)
    {
        panel.add(Box.createRigidArea(new Dimension(0, 100)));
    }
}
