/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.ItemDatabase;

/**
 *
 * @author kyliec
 */
public class ItemSelectListener implements ActionListener{
    private JButton currentlySelected;
    private BodyPanel bodyPanel;
    
    public ItemSelectListener(BodyPanel bodyPanel)
    {
        currentlySelected = null;
        this.bodyPanel = bodyPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectedButton = (JButton) e.getSource();
        ItemDatabase item = (ItemDatabase) selectedButton.getClientProperty("item");
        
        if (currentlySelected != null && selectedButton != currentlySelected)
        {
           currentlySelected.putClientProperty("selected", false);
           currentlySelected.setBorderPainted(false);
        }
        currentlySelected = selectedButton;
        currentlySelected.putClientProperty("selected", true);
        currentlySelected.setBorderPainted(true);
        currentlySelected.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        
        bodyPanel.setIndicatorText("Selected: $"+item.getPrice()+" "+item.getName()+", click again to buy");
    }
    
}
