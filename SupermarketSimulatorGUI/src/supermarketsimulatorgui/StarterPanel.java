/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
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
    
    public void addSpace(JPanel panel, int xSpace, int ySpace)
    {
        panel.add(Box.createRigidArea(new Dimension(xSpace, ySpace)));
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
        ImageIcon tempImage = new ImageIcon(imgURL);
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
