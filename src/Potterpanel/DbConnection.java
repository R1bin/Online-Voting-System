package Potterpanel;

import javax.swing.*;
import java.sql.*;

public class DbConnection {

//      String url = "jdbc:mysql://localhost:3306/";
//    String dbName = "test";
//    String driver = "com.mysql.jdbc.Driver";
//    String userName = "root";
//    String password = "";
    public Connection connection;

    Statement statement;

    ResultSet resultSet;

    int value;

    public DbConnection() {

        try {

            String username = "sql6580619";

            String password = "4WswNZR8Cq";

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql6580619", username, password);

            if (connection != null) {

                System.out.println("Connected to database");

            } else {

                System.out.println("Error connecting to database");

            }

            statement = connection.createStatement();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // Via the use of sql query
    // insert, update and delete
    public int manipulate(String query) {

        try {

            value = statement.executeUpdate(query);

            connection.close();

        } catch (SQLIntegrityConstraintViolationException ex) {

            JOptionPane.showMessageDialog(null, "These details already exist!");

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return value;

    }

    public ResultSet retrieve(String query) {

        try {

            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return resultSet;

    }

    public static void main(String[] args) {

        new DbConnection();

    }

}
