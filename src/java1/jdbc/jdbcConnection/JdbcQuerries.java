package java1.jdbc.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcQuerries {
    static Connection connection = DatabaseConnection.getConnection();
    public static void getAllRows() throws SQLException {
        List<Employees> employees  =  new ArrayList<>();
        String sql = "select * from EMPLOYEES";

        //try with resources
        try {
            //query all the rows
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            //will traverse through all rows
            while(resultSet.next()) {
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Employees emp = new Employees(id, email, firstName, lastName);
                employees.add(emp);
                employees.stream().forEach(System.out::println);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getRecordByID() throws SQLException {
        List<Employees> employees  =  new ArrayList<>();

        String sql = "select * from EMPLOYEES where id =?";
        //query data using placeholder
        //try with resources
        try{
            //query all the rows
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,7);
            ResultSet resultSet = statement.executeQuery();
            //will traverse through all rows
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Employees emp = new Employees(id,email,firstName,lastName);
                System.out.println(emp.toString());
            }else
                System.out.println("resultset is empty ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
        }
    }


    public static void main(String[] args) throws SQLException {
        getAllRows();
        getRecordByID();
    }

}
