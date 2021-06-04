/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import supermarketsimulatorlisteners.FieldFocusListener;

/**
 * This abstract class provides vital methods related to the supermarket simulator
 * 
 * @author kyliec
 */
abstract class StarterPanel extends JPanel{
    public JButton createNewButton(ImageIcon image)
    {
        JButton tempButton = new JButton(image);
        tempButton.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(.641f, .59f, .5f),3));
        tempButton.setBorderPainted(false);
        tempButton.setFocusPainted(false);
        tempButton.setContentAreaFilled(false);
        int width = image.getIconWidth();
        int height = image.getIconHeight();
        tempButton.setMinimumSize(new Dimension(width,height));
        tempButton.setMaximumSize(new Dimension(width,height));
        tempButton.setPreferredSize(new Dimension(width,height));
        tempButton.setAlignmentY(TOP_ALIGNMENT);
        
        return tempButton;
    }
    
    public Component addSpace(JPanel panel, int xSpace, int ySpace)
    {
        Component space = Box.createRigidArea(new Dimension(xSpace, ySpace));
        panel.add(space);
        return space;
    }
    
    public void designTextField(JComponent comp)
    {
        comp.addFocusListener(new FieldFocusListener());
        comp.setFont(new Font("Avenir", Font.ITALIC,16));
        comp.setForeground(Color.DARK_GRAY);
    }
    
    public void setLabelSize(JLabel label)
    {
        label.setOpaque(true);
        label.setMinimumSize(new Dimension(80,30));
        label.setMaximumSize(new Dimension(80,30));
        label.setPreferredSize(new Dimension(80,30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Avenir", Font.PLAIN, 12));
        label.setAlignmentY(TOP_ALIGNMENT);
    }
    
    public ImageIcon resizeComponent(String imgURL, int width, int height)
    {
        java.net.URL imageURL = getClass().getResource(imgURL);
        ImageIcon tempImage = new ImageIcon(imageURL);
        Image image = tempImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        tempImage = new ImageIcon(newimg);
        
        return tempImage;
    }
    
    public void changeGridLayout(GridBagConstraints constraints, int x, int y)
    {
        constraints.gridx = x;
        constraints.gridy = y;
    }
    
}
