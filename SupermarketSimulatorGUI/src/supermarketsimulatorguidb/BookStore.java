package supermarketsimulatorguidb;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStore {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public BookStore() throws SQLException {
        dbManager = new DBManager();
        dbManager.establishConnection();
        conn = dbManager.getConnection();
        

    }

    public void connectBookStoreDB() throws SQLException {
        //use the conn, initialize database by creating BOOK Table and insert records
        statement = conn.createStatement();
        
        statement.executeUpdate("CREATE TABLE BOOK (BOOKID INT, TITLE VARCHAR(50), CATEGORY VARCHAR(20), PRICE FLOAT)");
        statement.executeUpdate("INSERT INTO BOOK VALUES(1, 'Slum Dog Millionaire', 'Fiction', 19.90),(2, 'Run Mummy Run', 'Fiction', 28.00),(3, 'The Land of Painted Caves', 'Fiction', 15.40),(4, 'Cook with Jamie', 'Non-fiction', 55.20),(5, 'Far Eastern Odyssey', 'Non-fiction', 24.90),(6, 'Open', 'Non-fiction', 33.60),(7, 'Big Java', 'Textbook', 55.00),(8, 'Financial Accounting', 'Textbook', 24.80)");
    }

    public void createPromotionTable() throws SQLException {
        /* You may need the following SQL statements for this method:

         * Create the table:
           CREATE TABLE PROMOTION (CATEGORY VARCHAR(20), DISCOUNT INT);

         * Insert records into the table: 
           INSERT INTO PROMOTION VALUES ('Fiction', 0),
           ('Non-fiction', 10),
           ('Textbook', 20);

         */
        statement.executeUpdate("CREATE TABLE PROMOTION (CATEGORY VARCHAR(20), DISCOUNT INT)");
        statement.executeUpdate("INSERT INTO PROMOTION VALUES ('Fiction', 0), ('Non-fiction', 10), ('Textbook', 20)");

    }

    public ResultSet getWeekSpecial() throws SQLException {
        /* You may need the following SQL statements for this method:

        * Query multiple tables:
        
          SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;

         */
statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY");

        return (rs);

    }

    public void createWeekSpecialTable(ResultSet rs) throws SQLException {
        statement = conn.createStatement();
        statement.executeUpdate("CREATE TABLE WEEKSPECIAL (TITLE VARCHAR(50), SPECIALPRICE FLOAT)");
        try {
            
            while (rs.next()) {
                String title = rs.getString(1);
                float price = rs.getFloat(2);
                float discount = rs.getFloat(3);

                float total = price - (price * (discount / 100));

                System.out.println(title+", "+price+", "+discount);
                
                statement.executeUpdate("INSERT INTO WEEKSPECIAL VALUES ('" + title + "', " + total + ")");
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
