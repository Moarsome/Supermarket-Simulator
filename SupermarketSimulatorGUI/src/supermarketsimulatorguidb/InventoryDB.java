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

import java.sql.SQLException;

public class InventoryDB {
    private final DBManager dbManager;
    private int itemID;
    
    public InventoryDB() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
        itemID = 0;
    }
    
    public void createInventoryTable() {
        dbManager.updateDB("CREATE TABLE INVENTORY (ITEM_ID INT, NAME VARCHAR(50), PRICE FLOAT, STOCK INT)");
        }
      
    
    public void addInventory(String user, String pass, float budget) {
        dbManager.updateDB("INSERT INTO INVENTORY VALUES("+itemID+"'" + user + "', '" + pass + "', " + budget + ")");
    }
}
