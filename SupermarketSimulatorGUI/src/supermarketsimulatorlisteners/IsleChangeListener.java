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
    
    public IsleChangeListener(IsleMarker isleManager, HeaderPanel headerPanel, BodyPanel bodyPanel, MainPanel mainPanel)
    {
        super();
        this.isleManager = isleManager;
        this.headerPanel = headerPanel;
        this.bodyPanel = bodyPanel;
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
