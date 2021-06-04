/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author kyliec
 */
public class FieldFocusListener implements FocusListener 
{

    /**
     *
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        JTextField comp = (JTextField) e.getComponent();
        comp.setText("");
        comp.setFont(new Font("Avenir", Font.PLAIN, 16));
    }

    /**
     *
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
}
