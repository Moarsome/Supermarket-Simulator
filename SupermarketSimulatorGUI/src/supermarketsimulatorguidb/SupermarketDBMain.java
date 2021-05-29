package supermarketsimulatorguidb;

import java.sql.SQLException;

public class SupermarketDBMain {

    public static void main(String[] args) throws SQLException {
        
        UserDB user = new UserDB();
        InventoryDB inventory = new InventoryDB();
        UserInventoryDB userInventory = new UserInventoryDB();
        user.createUserTable();
        inventory.createInventoryTable();
        inventory.fillInventoryTable();
        userInventory.createInventoryTable();
    }

}
