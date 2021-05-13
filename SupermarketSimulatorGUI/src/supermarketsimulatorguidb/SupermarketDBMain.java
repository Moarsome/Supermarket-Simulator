package supermarketsimulatorguidb;

import java.sql.SQLException;

public class SupermarketDBMain {

    public static void main(String[] args) throws SQLException {

        UserDB user = new UserDB();
        InventoryDB inventory = new InventoryDB();
        user.createUserTable();
        user.addNewUser("Kylie", "123", 100);
        inventory.createInventoryTable();
    }

}
