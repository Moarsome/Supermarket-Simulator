/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorlisteners;

import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Objects;
import supermarketsimulatorgui.LoginPanel;
import supermarketsimulatorgui.MainPanel;
import supermarketsimulatorgui.User;

/**
 *
 * @author kyliec
 */
public class DBListener implements ActionListener 
{
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
            User newUser = new User(panel.getUserInput().getText(),panel.getPassInput().getText(), 200.0f);
            panel.setUser(newUser);
            mainPanel.setUser(newUser);
            addUser(newUser);
        }
        else if (e.getActionCommand().equals("login"))
        {
            String userInput = panel.getUserInput().getText();
            String passInput = panel.getPassInput().getText();
            
            Float tempBudget = findUser(userInput, passInput);
            
            if (!Objects.equals(tempBudget, (Float) null))
            {
                User existingUser = new User(userInput,passInput, tempBudget);
                panel.setUser(existingUser);
                mainPanel.setUser(existingUser);
                mainPanel.getHeaderPanel().setBudgetLabel(tempBudget);
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
            mainPanel.getHeaderPanel().setBudgetLabel(user.getBudget());
            
            switchToMainPanel();
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public float findUser(String username, String password)
    {
        try {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'");
            if (rs.next())
            {
                panel.setTextFeedback("User '"+username+"' was found, loading data...");
                return rs.findColumn("BUDGET");
            }
            else
            {
                panel.setTextFeedback("Username and password combination not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Float) null;
    }
    
    public void switchToMainPanel()
    {
        panel.setVisible(false);
        mainPanel.enableVisible();
    }
}
