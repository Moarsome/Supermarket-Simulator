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


public class Inventory {
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public Inventory() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
        conn = dbManager.getConnection();
    }
    
    public void createInventoryTable() {
        dbManager.updateDB("CREATE TABLE INVENTORY (NAME VARCHAR(50), PRICE FLOAT, STOCK INT)");
        }
      
    
    public void addInventory(String user, String pass, float budget) {
        dbManager.updateDB("INSERT INTO USERS VALUES('" + user + "', '" + pass + "', " + budget + ")");
    }
}
