/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kyliec
 */
public final class LoginPanel extends StarterPanel {
    private final JLabel userIcon;
    private final JLabel loginHeader;
    private final JTextField userInput;
    private final JTextField passInput;
    private final JButton submitButton;
    private final JButton loginButton;
    private final JButton registerButton;
    private final JPanel innerPane;
    
    public LoginPanel()
    {
        this.setSize(new Dimension(750,750));
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        innerPane = new JPanel();
        innerPane.setMaximumSize(new Dimension(300,230));
        innerPane.setAlignmentY(TOP_ALIGNMENT);
        innerPane.setLayout(new GridBagLayout());
        innerPane.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,0,5,0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        userIcon = new JLabel(resizeComponent("./resources/userIcon.png", 80,100));
        userIcon.setAlignmentX(CENTER_ALIGNMENT);
        loginHeader = new JLabel(resizeComponent("./resources/shoppingLogo.png", 509,124));
        loginHeader.setAlignmentX(CENTER_ALIGNMENT);
        
        userInput = new JTextField("Username");
        userInput.setFont(new Font("Verdana", Font.ITALIC,16));
        userInput.setForeground(Color.DARK_GRAY);
        passInput = new JTextField("Password");
        passInput.setFont(new Font("Verdana", Font.ITALIC,16));
        passInput.setForeground(Color.DARK_GRAY);
        
        submitButton = createNewButton(resizeComponent("./resources/submit.png", 208, 40));
        submitButton.setActionCommand("register");
        submitButton.addActionListener(new DBListener(this));
        loginButton = createNewButton(resizeComponent("./resources/login.png", 104, 40));
        loginButton.setEnabled(false);
        registerButton = createNewButton(resizeComponent("./resources/register.png", 104, 40));
        
        changeGridLayout(constraints, 0, 0);
        innerPane.add(loginButton,constraints);
        changeGridLayout(constraints, 1, 0);
        innerPane.add(registerButton,constraints);
        constraints.gridwidth = 2;
        changeGridLayout(constraints, 0, 3);
        innerPane.add(submitButton, constraints);
        changeGridLayout(constraints, 0, 1);
        innerPane.add(userInput, constraints);
        changeGridLayout(constraints, 0, 2);
        innerPane.add(passInput, constraints);
        
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(loginHeader);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(userIcon);
        this.add(innerPane);
        
        this.setOpaque(false);
    }
    
    public void changeGridLayout(GridBagConstraints constraints, int x, int y)
    {
        constraints.gridx = x;
        constraints.gridy = y;
    }

    /**
     * @return the userInput
     */
    public JTextField getUserInput() {
        return userInput;
    }

    /**
     * @return the passInput
     */
    public JTextField getPassInput() {
        return passInput;
    }
    
    
}
