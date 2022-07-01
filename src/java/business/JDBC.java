package bussiness;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    
    private static String jdbcURL="jdbc:mysql://localhost:3306/onlinestore";
    private static String jdbcUser="root";
    private static String jdbcPassword="root";
    private static String jdbcName="com.mysql.jdbc.Driver";

    private static Connection connection;
        
    public static Connection getConnection(){
        try {
            Class.forName(jdbcName);
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
            return connection;
        } 
        catch (Exception e) {
            System.out.println("Khoi tao that bai");
        }
        return null;
    }
    
    public static void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
        }
    }
}
