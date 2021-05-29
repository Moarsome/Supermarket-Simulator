/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorguidb;

/**
 *
 * @author kyliec
 */
import java.sql.SQLException;

public class UserInventoryDB {
    private final DBManager dbManager;
    
    public UserInventoryDB() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
    }
    
    public void createInventoryTable() {
        dbManager.updateDB("CREATE TABLE USER_INVENTORY (USER_ID INT, ITEM_ID INT, NAME VARCHAR(50))");
        }
}