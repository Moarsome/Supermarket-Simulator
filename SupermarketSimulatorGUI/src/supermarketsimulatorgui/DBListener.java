/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorgui;

import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author kyliec
 */
public class DBListener implements ActionListener {

    private Connection connection;
    private LoginPanel panel;
    private MainPanel mainPanel;
    
    public DBListener(LoginPanel panel, MainPanel mainPanel)
    {
        this.panel = panel;
        this.mainPanel = mainPanel;
        
        try 
        {
            connection = DriverManager.getConnection("jdbc:derby:supermarketDB_Ebd", "super", "market");
        } catch (SQLException ex) 
        {

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("register"))
        {
            User newUser = new User(panel.getUserInput().getText(),panel.getPassInput().getText());
            addUser(newUser);
        }
        else if (e.getActionCommand().equals("login"))
        {
            String userInput = panel.getUserInput().getText();
            String passInput = panel.getPassInput().getText();
            
            if (findUser(userInput, passInput) == true)
            {
                User existingUser = new User(userInput,passInput);
                switchToMainPanel();
            }
        }
       
    }

    public void addUser(User user) 
    {
        try {
            Statement stmt = connection.createStatement();
            
            stmt.executeUpdate("INSERT INTO USERS VALUES(" + user.getUserID() + ",'" + user.getName() + "', '" + user.getPassword() + "', " + user.getBudget() + ")");
            panel.setTextFeedback("Successfully created new user '"+user.getName()+"'");
            
            switchToMainPanel();
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean findUser(String username, String password)
    {
        try {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'");
            if (rs.next())
            {
                panel.setTextFeedback("User '"+username+"' was found, loading data...");
                return true;
            }
            else
            {
                panel.setTextFeedback("Username and password combination not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void switchToMainPanel()
    {
        panel.setVisible(false);
        mainPanel.enableVisible();
    }
}
