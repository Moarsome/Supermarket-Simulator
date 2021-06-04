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
import supermarketsimulatorlisteners.CancelListener;

/**
 *This JPanel class displays the middle portion of the main panel; i.e. the shelves
 * 
 * @author kyliec
 */
public class BodyPanel extends StarterPanel 
{
    private JLabel shelves;
    private JLabel isleLabel;
    private JLabel itemIndicator;
    private JButton cancelCheckout;
    private Component space;
    
    /**
     * Constructor for the body panel
     * 
     * @param mainPanel
     */
    public BodyPanel(MainPanel mainPanel) 
    {
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        this.setOpaque(false);
        
        createComponents(mainPanel);
        
        addComponents();
        
    }
    
    /**
     * Create JComponents for BodyPanel
     * 
     * @param mainPanel
     */
    public void createComponents(MainPanel mainPanel)
    {
        cancelCheckout = createNewButton(resizeComponent("/resources/cancelCheckout.png", 100, 40));
        cancelCheckout.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelCheckout.addActionListener(new CancelListener(mainPanel));
        cancelCheckout.setVisible(false);
        
        isleLabel = new JLabel("ISLE 1 - CONFECTIONARY");
        isleLabel.setFont(new Font("Avenir", Font.PLAIN, 30));
        isleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        ImageIcon shelvesImage = resizeComponent("/resources/shelves.png", 620, 320);
        shelves = new JLabel(shelvesImage);
        shelves.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        itemIndicator = new JLabel("Click any item to display information.");
        itemIndicator.setFont(new Font("Avenir", Font.PLAIN, 18));
        itemIndicator.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    /**
     * Add created components to BodyPanel, including spaces
     */
    public void addComponents()
    {
        this.removeAll();
        
        space = addSpace(this,0,40);
        
        this.add(space);
        this.add(cancelCheckout);
        this.addSpace(this,0, 50);
        this.add(isleLabel);
        this.addSpace(this,0, 40);
        this.add(shelves);
        this.addSpace(this,0, 30);
        this.add(itemIndicator);
        
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Set text of isle labels
     * 
     * @param newText
     */
    public void setIsleLabel(String newText)
    {
        this.isleLabel.setText(newText);
    }
    
    /**
     * Set text that on indicator label that directly communicates with user
     * 
     * @param newText
     */
    public void setIndicatorText(String newText)
    {
        this.itemIndicator.setText(newText);
    }
    
    /**
     * Returns button that cancels checkout
     * 
     * @return
     */
    public JButton getCancelButton()
    {
        return this.cancelCheckout;
    }
    
    /**
     * Remove space component
     */
    public void removeSpace()
    {
        this.remove(space);
    }
}
