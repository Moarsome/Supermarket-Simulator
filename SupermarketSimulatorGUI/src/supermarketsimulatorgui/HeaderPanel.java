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
/**
 *
 * @author kyliec
 */

public final class HeaderPanel extends StarterPanel {
    private final JButton leftIsleButton;
    private final JButton rightIsleButton;
    private final JButton checkoutButton;
    private final JLabel budgetLabel;
    private final JLabel cartLabel;
    
    private final IsleMarker isleManager;
    private final User user;
    private MainPanel mainPanel;
    
    public HeaderPanel(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        this.user = mainPanel.getUser();
        
        this.isleManager = mainPanel.getIsleMarker();
        
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        leftIsleButton = createNewButton(new ImageIcon("./resources/left.png"));
        leftIsleButton.setActionCommand("leftIsle");
        leftIsleButton.setEnabled(false);
        rightIsleButton = createNewButton(new ImageIcon("./resources/right.png"));
        rightIsleButton.setActionCommand("rightIsle");
        checkoutButton = createNewButton(resizeComponent("./resources/checkout.png",100,40));
        checkoutButton.setActionCommand("checkout");
        
        budgetLabel = new JLabel("$00.00");
        budgetLabel.setForeground(Color.getHSBColor(0.336f, .228f, .6f));
        setLabelSize(budgetLabel);
        
        cartLabel = new JLabel("$00.00");
        cartLabel.setForeground(Color.getHSBColor(1.0f, 1.0f, .6f));
        setLabelSize(cartLabel);
        
        addSpace(this,10, 0);
        this.add(leftIsleButton);
        addSpace(this,115, 0);
        this.add(budgetLabel);
        this.add(checkoutButton);
        this.add(cartLabel);
        addSpace(this, 115, 0);
        this.add(rightIsleButton);
        addSpace(this,10, 0);
        
        this.setOpaque(false);
    }
    
    public void addListeners()
    {
        IsleChangeListener listener = new IsleChangeListener(mainPanel);
        leftIsleButton.addActionListener(listener);
        rightIsleButton.addActionListener(listener);
        checkoutButton.addActionListener(listener);
    }
    
    public void setBudgetLabel(float value)
    {
        this.budgetLabel.setText(String.format("$%.02f", value));
    }
    
    public void setCartLabel(float value)
    {
        this.cartLabel.setText(String.format("$%.02f", value));
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
