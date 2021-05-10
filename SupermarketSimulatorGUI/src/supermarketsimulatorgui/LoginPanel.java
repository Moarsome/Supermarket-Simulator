/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.awt.Image;
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
public class LoginPanel extends JPanel {
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
        layerPane = new JLayeredPane();
        
        userIcon = new JLabel(resizeComponent("./resources/userIcon.png", 300,300));
        borderDecoration = new JLabel(resizeComponent("./resources/border.png",500,700));
        
        userInput = new JTextField("Username");
        passInput = new JTextField("Password");
        
        submitButton = new JButton("SUBMIT");
        loginButton = new JButton("LOGIN");
        registerButton = new JButton("REGISTER");
        
        layerPane.add(borderDecoration);
        layerPane.add(loginButton);
        layerPane.add(registerButton);
        layerPane.add(userInput);
        layerPane.add(passInput);
        layerPane.add(submitButton);
        
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
}
