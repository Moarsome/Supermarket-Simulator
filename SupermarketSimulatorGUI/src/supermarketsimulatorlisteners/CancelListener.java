/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.HeaderPanel;
import supermarketsimulatorgui.MainPanel;

/**
 *
 * @author kyliec
 */
public class CancelListener implements ActionListener{
    private MainPanel mainPanel;
    private BodyPanel bodyPanel;
    private HeaderPanel headerPanel;
    
    /**
     *
     * @param mainPanel
     */
    public CancelListener(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.bodyPanel = mainPanel.getBodyPanel();
        this.headerPanel = mainPanel.getHeaderPanel();
        
        JButton cancelButton = (JButton) e.getSource();
        JButton checkoutButton = headerPanel.getCheckoutButton();
        
        bodyPanel.addComponents();
        cancelButton.setVisible(false);
        checkoutButton.putClientProperty("status", false);
        
        bodyPanel.setIndicatorText("Checkout cancelled!");
    }
}
