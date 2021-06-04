/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import supermarketsimulatorlisteners.IsleChangeListener;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import supermarketsimulatorlisteners.CheckoutListener;

/**
 * 
 * 
 * @author kyliec
 */

public final class HeaderPanel extends StarterPanel {
    private JButton leftIsleButton;
    private JButton rightIsleButton;
    private JButton checkoutButton;
    private JLabel budgetLabel;
    private JLabel cartLabel;
    
    private MainPanel mainPanel;
    
    /**
     * The HeaderPanel creates the top-most panel for the MainPanel
     * 
     * @param mainPanel
     */
    public HeaderPanel(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        createComponents();
        
        addComponents();
        
        this.setOpaque(false);
    }
    
    /**
     * Creates components for the JPanel
     */
    public void createComponents()
    {
        leftIsleButton = createNewButton(new ImageIcon(getClass().getResource("/resources/left.png")));
        leftIsleButton.setActionCommand("leftIsle");
        leftIsleButton.setEnabled(false);
        
        rightIsleButton = createNewButton(new ImageIcon(getClass().getResource("/resources/right.png")));
        rightIsleButton.setActionCommand("rightIsle");
        
        checkoutButton = createNewButton(resizeComponent("/resources/checkout.png",100,40));
        checkoutButton.putClientProperty("status", false);
        checkoutButton.setActionCommand("checkout");
        checkoutButton.addActionListener(new CheckoutListener(mainPanel));
        
        budgetLabel = new JLabel("$00.00");
        budgetLabel.setForeground(Color.getHSBColor(0.336f, .228f, .6f));
        setLabelSize(budgetLabel);
        
        cartLabel = new JLabel("$00.00");
        cartLabel.setForeground(Color.getHSBColor(1.0f, 1.0f, .6f));
        setLabelSize(cartLabel);
    }
    
    /**
     * Add created components to the panel
     */
    public void addComponents()
    {
        addSpace(this,10, 0);
        this.add(leftIsleButton);
        addSpace(this,115, 0);
        this.add(budgetLabel);
        this.add(checkoutButton);
        this.add(cartLabel);
        addSpace(this, 115, 0);
        this.add(rightIsleButton);
        addSpace(this,10, 0);
    }
    
    /**
     * Add necessary listeners to buttons
     */
    public void addListeners()
    {
        IsleChangeListener listener = new IsleChangeListener(mainPanel);
        leftIsleButton.addActionListener(listener);
        rightIsleButton.addActionListener(listener);
        checkoutButton.addActionListener(listener);
    }
    
    /**
     * Set the budget label to a float value
     * 
     * @param value
     */
    public void setBudgetLabel(float value)
    {
        this.budgetLabel.setText(String.format("$%.02f", value));
    }
    
    /**
     * Set the cart label with a float value
     * 
     * @param value
     */
    public void setCartLabel(float value)
    {
        this.cartLabel.setText(String.format("$%.02f", value));
    }
    
    /**
     * Enable left isle button for clicking
     */
    public void enableLeftIsleButton()
    {
        this.leftIsleButton.setEnabled(true);
    }
    
    /**
     * Disable left isle button
     */
    public void disableLeftIsleButton()
    {
        this.leftIsleButton.setEnabled(false);
    }
    
    /**
     * Enable right isle button
     */
    public void enableRightIsleButton()
    {
        this.rightIsleButton.setEnabled(true);
    }
    
    /**
     * Disable right isle button
     */
    public void disableRightIsleButton()
    {
        this.rightIsleButton.setEnabled(false);
    }
    
    /**
     * Retrieve checkout button
     * 
     * @return
     */
    public JButton getCheckoutButton()
    {
        return this.checkoutButton;
    }
}
