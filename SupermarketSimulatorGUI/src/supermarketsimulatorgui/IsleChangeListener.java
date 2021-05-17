/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.event.*;

/**
 *
 * @author kyliec
 */
public class IsleChangeListener implements ActionListener
{
    private IsleMarker isleManager;
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
    
    public IsleChangeListener(IsleMarker isleManager, HeaderPanel headerPanel, BodyPanel bodyPanel)
    {
        super();
        this.isleManager = isleManager;
        this.headerPanel = headerPanel;
        this.bodyPanel = bodyPanel;
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
            
            isleManager.setIsle(currentIsle);
            bodyPanel.setIsleLabel("ISLE "+(currentIsle)+" - "+isleManager.getIsleName(currentIsle));
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
            
            isleManager.setIsle(currentIsle);
            bodyPanel.setIsleLabel("ISLE "+(currentIsle)+" - "+isleManager.getIsleName(currentIsle));
        }
    }
    
}
