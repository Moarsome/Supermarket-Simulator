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
public class BodyPanel extends JPanel 
{
    private JLabel shelves;
    private JLabel isleLabel;
    
    public BodyPanel() 
    {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        ImageIcon shelvesImage = new ImageIcon("./resources/shelves.png");
        Image image = shelvesImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(650, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        shelvesImage = new ImageIcon(newimg);
        
        isleLabel = new JLabel("ISLE 1 - DRINKS");
        isleLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
        isleLabel.setFont(new Font("Avenir", Font.PLAIN, 30));
        isleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        shelves = new JLabel(shelvesImage);
        shelves.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.setOpaque(false);
        this.addSpace(this,30);
        this.add(isleLabel);
        this.addSpace(this,30);
        this.add(shelves);
        this.addSpace(this,70);
    }

    public void addSpace(JPanel panel, int space)
    {
        panel.add(Box.createRigidArea(new Dimension(0, space)));
    }
}
