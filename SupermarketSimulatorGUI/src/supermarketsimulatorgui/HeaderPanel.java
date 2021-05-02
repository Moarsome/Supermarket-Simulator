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
        
        budgetLabel = new JLabel("$00.00");
        budgetLabel.setForeground(Color.green);
        setLabelSize(budgetLabel);
        
        cartLabel = new JLabel("$00.00");
        cartLabel.setForeground(Color.red);
        setLabelSize(cartLabel);
        
        this.add(leftIsleButton);
        addSpace(this);
        this.add(budgetLabel);
        this.add(checkoutButton);
        this.add(cartLabel);
        addSpace(this);
        this.add(rightIsleButton);
        this.setOpaque(false);
    }
    
    public JButton createNewButton(ImageIcon image)
    {
        JButton tempButton = new JButton(image);
        tempButton.setBorderPainted(false);
        tempButton.setFocusPainted(false);
        tempButton.setContentAreaFilled(false);
        
        return tempButton;
    }
    
    public void addSpace(JPanel panel)
    {
        panel.add(Box.createRigidArea(new Dimension(20, 0)));
    }
    
    public void setLabelSize(JLabel label)
    {
        label.setOpaque(true);
        label.setMaximumSize(new Dimension(80,30));
        label.setPreferredSize(new Dimension(80,30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Open Sans", Font.PLAIN, 12));
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
