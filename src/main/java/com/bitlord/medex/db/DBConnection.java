package com.bitlord.medex.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // 1 private static reference variable
    private static DBConnection dbConnection;

    private Connection connection;

    // constructor private
    private DBConnection () throws ClassNotFoundException, SQLException {  // first calling

        Class.forName( "com.mysql.cj.jdbc.Driver" );
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/medex",
                "root",
                "spymali1021"
        );

    }


    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {

        /*if ( dbConnection = null ) {
            dbConnection = new DBConnection();
        }
        return dbConnection;*/

        return dbConnection == null ? ( dbConnection = new DBConnection() ) : dbConnection;

    }

    public Connection getConnection() {
        return connection;
    }

}
