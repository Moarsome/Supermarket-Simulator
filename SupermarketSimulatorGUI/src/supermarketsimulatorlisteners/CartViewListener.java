/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import supermarketsimulatorgui.FooterPanel;

/**
 *
 * @author kyliec
 */
public class CartViewListener implements ActionListener {

    private FooterPanel footerPanel;
    public CartViewListener(FooterPanel footerPanel)
    {
        this.footerPanel = footerPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton viewButton = (JButton) e.getSource();
        
        if ((boolean) viewButton.getClientProperty("status") == false)
        {
           footerPanel.showInventory();
           viewButton.putClientProperty("status", true);
        }
        else
        {
            footerPanel.hideInventory();
            viewButton.putClientProperty("status", false);
        }
    }
    
}
