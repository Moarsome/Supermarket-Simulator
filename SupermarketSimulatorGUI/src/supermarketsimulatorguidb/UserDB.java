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

/**
 *
 * @author kyliec
 */
public class UserDB {

    private final DBManager dbManager;

    /**
     *
     * @throws SQLException
     */
    public UserDB() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
    }

    /**
     *
     */
    public void createUserTable() 
    {
        dbManager.updateDB("CREATE TABLE USERS (USER_ID INT, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), BUDGET FLOAT)");
    }
}
