package com.bitlord.medex.util;

import com.bitlord.medex.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {

    //  ways =>  , modern

    private static PreparedStatement execute ( String sql, Object...params ) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        for ( int i = 0; i < params.length; i++ ) {

            pstm.setObject( ( i + 1 ), params[ i ] );

        }

        return pstm;

    }


    // CRUD ==> save(create), delete , update  => executeUpdate()
    public static boolean executeUpdate ( String sql, Object...params ) throws SQLException, ClassNotFoundException {

        // PreparedStatement pstm = execute( sql, params );
        // return pstm.executeUpdate() > 0;

        return execute( sql, params ).executeUpdate() > 0;

    }


    //  CRUD ==> Get(Read) => executeQuery() ===> Data set
    public static ResultSet executeQuery  (String sql, Object...params ) throws SQLException, ClassNotFoundException {

        return execute( sql, params ).executeQuery();

    }


}

