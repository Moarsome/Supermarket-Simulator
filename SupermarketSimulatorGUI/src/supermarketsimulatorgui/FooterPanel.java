/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author kyliec
 */
public class FooterPanel extends JPanel{
    private JButton viewCartButton;
    
    public FooterPanel()
    {
        viewCartButton = createNewButton(resizeComponent("./resources/viewCart.png",110,40));
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setOpaque(false);
        this.add(viewCartButton);
    }
    
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
        
        return tempButton;
    }
    
    public void addSpace(JPanel panel, int xSpace)
    {
        panel.add(Box.createRigidArea(new Dimension(xSpace, 0)));
    }
    
    public ImageIcon resizeComponent(String imgURL, int width, int height)
    {
        ImageIcon tempImage = new ImageIcon(imgURL);
        Image image = tempImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        tempImage = new ImageIcon(newimg);
        
        return tempImage;
    }
}
