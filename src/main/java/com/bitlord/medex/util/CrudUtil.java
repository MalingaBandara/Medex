package com.bitlord.medex.util;

import com.bitlord.medex.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    //  ways =>   , modern

    // Legacy Way
        /*    private static PreparedStatement execute ( String sql, Object...params ) throws SQLException, ClassNotFoundException {

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

    }*/

    // Modern Way
        private static <T> T execute ( String sql, Object...params ) throws SQLException, ClassNotFoundException {

                PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

                for ( int i = 0; i < params.length; i++ ) {

                    pstm.setObject( ( i + 1 ), params[ i ] );

                }

                if ( sql.startsWith( "SELECT" ) ) {
                    return (T)pstm.executeQuery();
                }

                return  (T)(Boolean) ( pstm.executeUpdate()>0 );

        }


}

