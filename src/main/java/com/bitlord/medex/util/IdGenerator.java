package com.bitlord.medex.util;

import java.sql.*;

public class IdGenerator {

    /*
    public int generateId () {

        try {

            ResultSet rst = CrudUtil.execute(
                    "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1"
            );

                if ( rst.next() ) {
                    return rst.getInt( 1 ) + 1;
                }


        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
        return 1;
    } */

    public String generateId ( String sql, String prefix ) {


         try {

            ResultSet rst = CrudUtil.execute( sql );

                if ( rst.next() ) {
                        String tempId =  rst.getString( 1 ) ; // get id for particular table

                        int id = Integer.parseInt( tempId.split( "-")[1] ); // split id and get the number and assign it to Int

                        id ++; // increment id for new recode

                        return prefix + "-" + id; // return new id
                }


        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }

        return prefix + "-1"; // if table empty


    }


}
