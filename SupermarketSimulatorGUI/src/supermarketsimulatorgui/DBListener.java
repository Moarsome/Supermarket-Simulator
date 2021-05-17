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

/**
 *
 * @author kyliec
 */
public class DBListener implements ActionListener {

    private Connection connection;
    private LoginPanel panel;
    
    public DBListener(LoginPanel panel)
    {
        this.panel = panel;
        
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
       
    }

    public void addUser(User user) 
    {
        try {
            Statement stmt = connection.createStatement();
            
            stmt.executeUpdate("INSERT INTO USERS VALUES(" + user.getUserID() + ",'" + user.getName() + "', '" + user.getPassword() + "', " + user.getBudget() + ")");
            System.out.println("Added user");
        } catch (SQLException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
