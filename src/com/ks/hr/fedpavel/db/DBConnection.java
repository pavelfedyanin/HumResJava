package com.ks.hr.fedpavel.db;

import java.sql.*;

/**
 * Created by Pavel on 23.06.14.
 */
public class DBConnection {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DBConnection(String databaseURL, String user, String password)throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("com.mysql.jdbc.Driver not found");
            e.printStackTrace();
            System.exit(1);
        }
        connection = DriverManager.getConnection(databaseURL, user, password);
    }

    public Connection getConnection() {
        return connection;
    }


/*

 */

}
