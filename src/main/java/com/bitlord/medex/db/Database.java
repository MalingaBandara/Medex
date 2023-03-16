package com.bitlord.medex.db;

import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.AccountType;

import java.util.ArrayList;

public class Database {


    // ------- First Table - Users
        public static ArrayList<UserDto> userTable = new ArrayList();


        // Create Default users
        static {
            //---------------
                userTable.add( new UserDto( "Jhon", "Brw", "john@gmail.com","1234", AccountType.PATIENT) ); // Patient User

                userTable.add( new UserDto( "Malinga", "Bandara", "malinga@gmail.com","1234", AccountType.DOCTOR) ); // Doctor User
            //---------------
        }


    // -------  ******


}
