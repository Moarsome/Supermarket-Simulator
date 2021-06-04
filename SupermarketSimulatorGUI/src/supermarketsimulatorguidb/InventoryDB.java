/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarketsimulatorguidb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import supermarketsimulatorgui.ItemDatabase;

/**
 * Inventory database table creator
 * @author kyliec
 */
public class InventoryDB {
    private final DBManager dbManager;
    private ArrayList<ItemDatabase> items;
    
    /**
     *
     * @throws SQLException
     */
    public InventoryDB(DBManager dbManager) throws SQLException {
        this.dbManager = dbManager;
        dbManager.establishConnection();
        items = new ArrayList<>();
        items.addAll(Arrays.asList(ItemDatabase.values()));
    }
    
    /**
     *
     */
    public void createInventoryTable() 
    {
        dbManager.updateDB("CREATE TABLE INVENTORY (ITEM_ID INT, NAME VARCHAR(50), PRICE FLOAT)");
    }
    
    /**
     *
     */
    public void fillInventoryTable() {
        
        for (int i = 0; i < items.size(); i++)
        {
         dbManager.updateDB("INSERT INTO INVENTORY VALUES("+items.get(i).getItemID()+",'" + items.get(i).getName() + "'," + items.get(i).getPrice() + ")");
        }
    }
}
