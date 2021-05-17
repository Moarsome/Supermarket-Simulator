/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author kyliec
 */
public class FooterPanel extends StarterPanel{
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
}
