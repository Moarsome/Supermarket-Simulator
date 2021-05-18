/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import supermarketsimulatorgui.LoginPanel;

/**
 *
 * @author kyliec
 */
public class MiscActionListener implements ActionListener{
    private final LoginPanel panel;
    
    public MiscActionListener(LoginPanel panel)
    {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login"))
        {
            panel.switchToLogin();
        }
        else if (e.getActionCommand().equals("register"))
        {
            panel.switchToRegister();
        }
    }
    
}
