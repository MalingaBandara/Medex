package com.bitlord.medex.db;

import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.AccountType;
import com.bitlord.medex.enums.GenderType;

import java.util.ArrayList;

public class Database {


    // ------- First Table - Users
        public static ArrayList<UserDto> userTable = new ArrayList();

    // ------- Second Table - Doctors
        public static ArrayList<DoctorDto> doctorTable = new ArrayList();


        // Create Default users
        static {
            //---------------
                userTable.add( new UserDto( "Jhon", "Brw", "john@gmail.com","1234", AccountType.PATIENT) ); // Patient User

                userTable.add( new UserDto( "Malinga", "Bandara", "malinga@gmail.com","1234", AccountType.DOCTOR) ); // Doctor User

            //---------------

                doctorTable.add( new DoctorDto(
                                                "Malinga",
                                                "Bandara",
                                                "23453",
                                                "+4535",
                                                "malinga@gmail.com",
                                                "Sample",
                                                "Colombo",
                                                GenderType.MALE
                                ) ) ;

            //---------------

        }


    // -------  ******


}
