/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

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
    
    public HeaderPanel(BodyPanel panel)
    {
        user = new User(200.0f, "test", "test");
        isleManager = new IsleMarker(user);
        isleManager.setIsle(1);
        
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
        
        leftIsleButton = createNewButton(new ImageIcon("./resources/left.png"));
        leftIsleButton.setActionCommand("leftIsle");
        leftIsleButton.setEnabled(false);
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
        
        leftIsleButton.addActionListener(new IsleChangeListener(isleManager,this, panel));
        rightIsleButton.addActionListener(new IsleChangeListener(isleManager,this, panel));
        checkoutButton.addActionListener(new IsleChangeListener(isleManager,this, panel));
        
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
