/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author kyliec
 */
public class BodyPanel extends StarterPanel 
{
    private JLabel shelves;
    private JLabel isleLabel;
    private JLabel itemIndicator;
    private JButton cancelCheckout;
    
    public BodyPanel() 
    {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        ImageIcon shelvesImage = resizeComponent("./resources/shelves.png", 600, 320);
        
        cancelCheckout = createNewButton(resizeComponent("./resources/cancelCheckout.png", 100, 40));
        cancelCheckout.setAlignmentX(Component.CENTER_ALIGNMENT);
        //cancelCheckout.setVisible(false);
        
        isleLabel = new JLabel("ISLE 1 - CONFECTIONARY");
        isleLabel.setFont(new Font("Avenir", Font.PLAIN, 30));
        isleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        shelves = new JLabel(shelvesImage);
        shelves.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        itemIndicator = new JLabel("Click any item to display information.");
        itemIndicator.setFont(new Font("Avenir", Font.PLAIN, 18));
        itemIndicator.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.setOpaque(false);
        this.add(cancelCheckout);
        this.addSpace(this,0, 50);
        this.add(isleLabel);
        this.addSpace(this,0, 40);
        this.add(shelves);
        this.addSpace(this,0, 30);
        this.add(itemIndicator);
    }
    
    public void setIsleLabel(String newText)
    {
        this.isleLabel.setText(newText);
    }
    
    public void setIndicatorText(String newText)
    {
        this.itemIndicator.setText(newText);
    }
}
