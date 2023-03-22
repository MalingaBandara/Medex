package com.bitlord.medex.util;

import java.sql.*;

public class IdGenerator {

    public int generateId () {

        try {

                //  1 driver Load => dependency
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                //  2 Create a Connection
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/medex",
                        "root",
                        "spymali1021"
                );

            // 3 write a SQL
            String sql = "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1";

            PreparedStatement pstm = connection.prepareStatement(sql);

            // CRUD ==> Get(Read) => executeQuery() ===> Data set
            // CRUD ==> save(create), delete , update  => executeUpdate()
            ResultSet rst = pstm.executeQuery();

                if ( rst.next() ) {
                    return rst.getInt( 1 ) + 1;
                }


        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
        return 1;

    }

}
