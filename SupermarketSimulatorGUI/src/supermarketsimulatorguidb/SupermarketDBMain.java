package supermarketsimulatorguidb;

import java.sql.SQLException;

public class SupermarketDBMain {

    public static void main(String[] args) throws SQLException {

        User user = new User();
        Inventory inventory = new Inventory();
        user.createUserTable();
        inventory.createInventoryrTable();
        
        
    }

}
