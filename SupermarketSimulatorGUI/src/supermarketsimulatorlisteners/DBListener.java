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
    private LoginPanel loginPanel;
    private MainPanel mainPanel;
    private User user;
    
    public DBListener(LoginPanel loginPanel, MainPanel mainPanel)
    {
        this.user = mainPanel.getUser();
        this.loginPanel = loginPanel;
        this.mainPanel = mainPanel;
        
        try 
        {
            connection = DriverManager.getConnection("jdbc:derby:supermarketDB_Ebd", "super", "market");
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("register"))
        {
            user.setUserID(0);
            user.setUsername(loginPanel.getUserInput().getText());
            user.setPassword(loginPanel.getPassInput().getText());
            user.setBudget(200.0f);
            addUser(user);
        }
        else if (e.getActionCommand().equals("login"))
        {
            String userInput = loginPanel.getUserInput().getText();
            String passInput = loginPanel.getPassInput().getText();
            
            Float tempBudget = findUser(userInput, passInput);
            
            if (!Objects.equals(tempBudget, (Float) null))
            {
                loginPanel.switchToSetBudget();
                
                user.setUsername(userInput);
                user.setPassword(passInput);
                user.setBudget(tempBudget);
                
                loginPanel.setTextFeedback("User successfully loaded! Please add to your existing budget of "+tempBudget+".");
            }
        }
        else if (e.getActionCommand().equals("budget"))
        {
            Float tempBudget = user.getBudget();
                
            try
            {
                Float enteredBudget = Float.parseFloat(loginPanel.getBudgetInput().getText());
                Float newBudget = tempBudget + enteredBudget;
                
                user.setBudget(newBudget);
                mainPanel.getHeaderPanel().setBudgetLabel(newBudget);
                switchToMainPanel();
            }
            catch (NumberFormatException ex)
            {
                loginPanel.setTextFeedback("Invalid budget value! Please enter a valid number and try again.");
            }
            
            
        }
       
    }

    public void addUser(User user) 
    {
        try 
        {
            Statement stmt = connection.createStatement();
            user.setUserID(generateUserID());
            
            stmt.executeUpdate("INSERT INTO USERS VALUES(" + user.getUserID() + ",'" + user.getName() + "', '" + user.getPassword() + "', " + user.getBudget() + ")");
            loginPanel.setTextFeedback("Successfully created new user '"+user.getName()+"'");
            mainPanel.getHeaderPanel().setBudgetLabel(user.getBudget());
            
            switchToMainPanel();
        } 
        catch (SQLException ex) 
        {
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
                loginPanel.setTextFeedback("User '"+username+"' was found, loading data...");
                
                float foundBudget = rs.getFloat("BUDGET");
                return foundBudget;
            }
            else
            {
                loginPanel.setTextFeedback("Username and password combination not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Float) null;
    }
    
    public int generateUserID()
    {
        try {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM USERS");
            rs.next();
            return rs.getInt("total");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public void switchToMainPanel()
    {
        loginPanel.setVisible(false);
        mainPanel.enableVisible();
    }
}
