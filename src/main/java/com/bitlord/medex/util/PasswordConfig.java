package com.bitlord.medex.util;

import org.mindrot.BCrypt;

public class PasswordConfig {

        // Encrypt
            public  String enctypt ( String text ) {

                return  BCrypt.hashpw ( text, BCrypt.gensalt( 10 ) );

            }


        // Decrypt
            public  boolean enctypt ( String rowPassword , String encryptedPassword  ) {

                return  BCrypt.checkpw ( rowPassword, encryptedPassword );

            }

}
