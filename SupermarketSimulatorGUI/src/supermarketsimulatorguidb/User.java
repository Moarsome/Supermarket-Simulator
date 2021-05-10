/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorguidb;

/**
 *
 * @author poyanpayandeh
 */

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User {
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public User() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
        conn = dbManager.getConnection();
    }
    
    public void createItemTable()
    {
        try {
            statement = conn.createStatement();
            
            statement.executeUpdate("CREATE TABLE ");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createUserTable() throws SQLException {
        statement = conn.createStatement();
        
        statement.executeUpdate("CREATE TABLE USERS (USERNAME VARCHAR(50), PASSWORD VARCHAR(50), BUDGET FLOAT)");
        }
      
    
    public void addNewUser(String user, String pass, float budget) throws SQLException {
        statement = conn.createStatement();
        
        statement.executeUpdate("INSERT INTO USERS VALUES('" + user + "', '" + pass + "', " + budget + ")");
    }
    
    
    //need to figure out how to udate shit
    public void updateUserBudget(float budget) throws SQLException {
        //use the conn, initialize database by creating BOOK Table and insert records
        statement = conn.createStatement();
        
       // statement.executeUpdate();
    }
}
