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
 * ActionListener for loggin in
 * @author kyliec
 */
public class LoginListener implements ActionListener{
    private final LoginPanel panel;
    
    /**
     * Constructor
     * @param panel
     */
    public LoginListener(LoginPanel panel)
    {
        this.panel = panel;
    }
    
    /**
     * When login button or register button is clicked
     * @param e
     */
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
