/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kyliec
 */
public class MiscActionListener implements ActionListener{
    private LoginPanel panel;
    
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
