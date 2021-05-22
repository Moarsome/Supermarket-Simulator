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
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInventoryDB {
    private final DBManager dbManager;
    private int itemID;
    
    public UserInventoryDB() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
        itemID = 0;
    }
    
    public void createInventoryTable() {
        dbManager.updateDB("CREATE TABLE USER_INVENTORY (USER_ID INT, ITEM_ID INT, NAME VARCHAR(50), STOCK INT)");
        }
    
    public void addInventory(int userID, int number) {
        dbManager.updateDB("INSERT INTO USER_INVENTORY VALUES("+userID+","+itemID+",'" + getUserFromID(userID) + "'," + number + ")");
    }
    
    public String getUserFromID(int userID)
    {
        ResultSet rs = null;
        try {
            rs = dbManager.queryDB("SELECT * FROM USERS WHERE USERS.ID = "+userID);
            
            while (rs.next())
            {
                String name = rs.getString("USERNAME");
                System.out.println(name);
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInventoryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}