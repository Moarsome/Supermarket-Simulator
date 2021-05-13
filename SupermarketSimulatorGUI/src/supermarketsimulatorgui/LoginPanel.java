/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kyliec
 */
public final class LoginPanel extends JPanel {
    private JLabel userIcon;
    private JLabel borderDecoration;
    private JTextField userInput;
    private JTextField passInput;
    private JButton submitButton;
    private JButton loginButton;
    private JButton registerButton;
    private JLayeredPane layerPane;
    
    public LoginPanel()
    {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(700,700));
        layerPane = new JLayeredPane();
        layerPane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        userIcon = new JLabel(resizeComponent("./resources/userIcon.png", 80,100));
        borderDecoration = new JLabel(resizeComponent("./resources/border.png",300,300));
        
        userInput = new JTextField("Username");
        passInput = new JTextField("Password");
        
        submitButton = createButton("SUBMIT");
        loginButton = createButton("LOGIN");
        registerButton = createButton("REGISTER");
        
        layerPane.add(borderDecoration,-3);
        layerPane.add(loginButton);
        layerPane.add(registerButton);
        layerPane.add(userInput);
        layerPane.add(passInput);
        layerPane.add(submitButton);
        
        this.setOpaque(false);
        this.add(userIcon);
        this.add(layerPane);
        
    }
    
    public ImageIcon resizeComponent(String imgURL, int width, int height)
    {
        ImageIcon tempImage = new ImageIcon(imgURL);
        Image image = tempImage.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        tempImage = new ImageIcon(newimg);
        
        return tempImage;
    }
    
    public JButton createButton(String text)
    {
        JButton tempButton = new JButton(text);
        tempButton.setPreferredSize(new Dimension(130,40));
        return tempButton;
    }
}
