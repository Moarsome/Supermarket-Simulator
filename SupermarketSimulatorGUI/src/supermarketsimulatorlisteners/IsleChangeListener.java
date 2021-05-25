/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.event.*;
import supermarketsimulatorgui.BodyPanel;
import supermarketsimulatorgui.HeaderPanel;
import supermarketsimulatorgui.IsleMarker;
import supermarketsimulatorgui.MainPanel;

/**
 *
 * @author kyliec
 */
public class IsleChangeListener implements ActionListener
{
    private IsleMarker isleManager;
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
    private MainPanel mainPanel;
    
    public IsleChangeListener(MainPanel mainPanel)
    {
        super();
        this.isleManager = mainPanel.getIsleMarker();
        this.headerPanel = mainPanel.getHeaderPanel();
        this.bodyPanel = mainPanel.getBodyPanel();
        this.mainPanel = mainPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("checkout"))
        {
            System.exit(0);
        }
        else if (e.getActionCommand().equals("leftIsle"))
        {
            int currentIsle = isleManager.getIsle() - 1;
            
            if (currentIsle == 1)
            {
                headerPanel.disableLeftIsleButton();
            }
            if (currentIsle < isleManager.getIsles().size())
            {
                headerPanel.enableRightIsleButton();
            }
            setIsleVisibility(currentIsle);
            
        }
        else if (e.getActionCommand().equals("rightIsle"))
        {
            
            int currentIsle = isleManager.getIsle() + 1;
            
            if (currentIsle == isleManager.getIsles().size())
            {
                headerPanel.disableRightIsleButton();
            }
            if (currentIsle > 1)
            {
                headerPanel.enableLeftIsleButton();
            }
            
            setIsleVisibility(currentIsle);
        }
    }
    
    public void setIsleVisibility(int currentIsle)
    {
            isleManager.setIsle(currentIsle);
            bodyPanel.setIsleLabel("ISLE "+(currentIsle)+" - "+isleManager.getIsleName(currentIsle));
    }
}
