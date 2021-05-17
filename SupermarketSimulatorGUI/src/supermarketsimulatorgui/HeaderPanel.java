/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author kyliec
 */

public final class HeaderPanel extends JPanel {
    private final JButton leftIsleButton;
    private final JButton rightIsleButton;
    private final JButton checkoutButton;
    private final JLabel budgetLabel;
    private final JLabel cartLabel;
    
    private final IsleMarker isleManager;
    private final User user;
    
    public HeaderPanel(BodyPanel panel)
    {
        user = new User(200.0f, "test");
        isleManager = new IsleMarker(user);
        isleManager.setIsle(1);
        
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        
        leftIsleButton = createNewButton(new ImageIcon("./resources/left.png"));
        leftIsleButton.setActionCommand("leftIsle");
        rightIsleButton = createNewButton(new ImageIcon("./resources/right.png"));
        rightIsleButton.setActionCommand("rightIsle");
        checkoutButton = createNewButton(resizeComponent("./resources/checkout.png",100,40));
        checkoutButton.setActionCommand("checkout");
        
        budgetLabel = new JLabel("$"+user.getBudget());
        budgetLabel.setForeground(Color.getHSBColor(0.336f, .228f, .6f));
        setLabelSize(budgetLabel);
        
        cartLabel = new JLabel("$00.00");
        cartLabel.setForeground(Color.getHSBColor(1.0f, 1.0f, .6f));
        setLabelSize(cartLabel);
        
        //ComponentListener listener = new ComponentListener(isleManager,this, panel);
        
        leftIsleButton.addActionListener(new ComponentListener(isleManager,this, panel));
        rightIsleButton.addActionListener(new ComponentListener(isleManager,this, panel));
        checkoutButton.addActionListener(new ComponentListener(isleManager,this, panel));
        
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
        tempButton.setAlignmentY(TOP_ALIGNMENT);
        
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
    
    public void enableLeftIsleButton()
    {
        this.leftIsleButton.setEnabled(true);
    }
    
    public void disableLeftIsleButton()
    {
        this.leftIsleButton.setEnabled(false);
    }
    
    public void enableRightIsleButton()
    {
        this.rightIsleButton.setEnabled(true);
    }
    
    public void disableRightIsleButton()
    {
        this.rightIsleButton.setEnabled(false);
    }
}
