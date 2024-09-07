package java1.jdbc.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    private static Connection connection = null;

    private static String name;
    static
    {
        String url = "jdbc:mysql://localhost:3306/employee?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String pass = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}