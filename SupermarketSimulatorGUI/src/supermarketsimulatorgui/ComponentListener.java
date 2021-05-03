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
public class ComponentListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("checkout"))
        {
            System.exit(0);
        }
    }
    
}
