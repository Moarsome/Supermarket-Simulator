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

public class HeaderPanel extends JPanel {
    private JButton leftIsleButton;
    private JButton rightIsleButton;
    private JButton checkoutButton;
    private JLabel budgetLabel;
    private JLabel cartLabel;
    
    public HeaderPanel(JFrame frame)
    {
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        leftIsleButton = createNewButton(new ImageIcon("./resources/left.png"));
        rightIsleButton = createNewButton(new ImageIcon("./resources/right.png"));
        checkoutButton = createNewButton(resizeComponent("./resources/checkout.png",100,40));
        checkoutButton.setActionCommand("checkout");
        checkoutButton.addActionListener(new ComponentListener());
        
        budgetLabel = new JLabel("$00.00");
        budgetLabel.setForeground(Color.getHSBColor(0.336f, .228f, .6f));
        setLabelSize(budgetLabel);
        
        cartLabel = new JLabel("$00.00");
        cartLabel.setForeground(Color.getHSBColor(1.0f, 1.0f, .6f));
        setLabelSize(cartLabel);
        
        addSpace(this,10);
        this.add(leftIsleButton);
        addSpace(this,80);
        this.add(budgetLabel);
        this.add(checkoutButton);
        this.add(cartLabel);
        addSpace(this,80);
        this.add(rightIsleButton);
        addSpace(this,10);
        
        this.setOpaque(false);
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
    
    public void setLabelSize(JLabel label)
    {
        label.setOpaque(true);
        label.setMinimumSize(new Dimension(80,30));
        label.setMaximumSize(new Dimension(80,30));
        label.setPreferredSize(new Dimension(80,30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Avenir", Font.PLAIN, 12));
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
