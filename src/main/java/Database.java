import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connect(){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:resources:USERS.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Successfully connected to sqlite db.");
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        return conn;
    }
}
