/*
 * The programs are designed for PDC paper
 */
package supermarketsimulatorguidb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBManager {

    private static final String USER_NAME = "super"; //your DB username
    private static final String PASSWORD = "market"; //your DB password
    private static final String URL = "jdbc:derby:supermarketDB_Ebd; create=true";  //url of the DB host

    Connection conn;

    public DBManager() throws SQLException {
        establishConnection();
        
        System.out.println("connection: "+getConnection());
            
//            System.out.println("Running create tables");
//            UserDB user = new UserDB();
//            InventoryDB inventory = new InventoryDB();
//            UserInventoryDB userInventory = new UserInventoryDB();
//            user.createUserTable();
//            inventory.createInventoryTable();
//            inventory.fillInventoryTable();
//            userInventory.createInventoryTable();
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        try {
            //Establish a connection to Database
            conn=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
