package supermarketsimulatorguidb;

import java.sql.SQLException;

public class SupermarketDBMain {

    public static void main(String[] args) throws SQLException {

        User user = new User();
        DBManager dbm = new DBManager();
        user.createUserTable();
    }

}
