package com.bitlord.medex.db;

import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.dto.PatientDto;
import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.AccountType;
import com.bitlord.medex.enums.GenderType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Database {


    // ------- First Table - Users
        public static ArrayList<UserDto> userTable = new ArrayList();

    // ------- Second Table - Doctors
        public static ArrayList<DoctorDto> doctorTable = new ArrayList();

    // ------- Third Table - Patient
        public static ArrayList<PatientDto> patientTable = new ArrayList();



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
        try {

            patientTable.add(
                    new PatientDto("95", "Eran", "Kaan",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1991-04-01"),
                            GenderType.MALE, "Galle", "eran@gmail.com"));

            patientTable.add(
                    new PatientDto("912", "Samantha", "Bndara",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1991-04-01"),
                            GenderType.MALE, "Kaluthara", "sama@gmail.com"));

            patientTable.add(
                    new PatientDto("66", "Namal", "Kaan",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1991-04-01"),
                            GenderType.MALE, "Wattala", "namma@gmail.com"));

            patientTable.add(
                    new PatientDto("456", "Wassa", "Kuna",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1991-04-01"),
                            GenderType.MALE, "Horna", "wasssa@gmail.com"));

            patientTable.add(
                    new PatientDto("695", "Gota", "Hora",
                            new SimpleDateFormat("yyyy-MM-dd").parse("1991-04-01"),
                            GenderType.MALE, "Colombo", "gotaa@gmail.com"));

        } catch ( Exception e ){
            e.printStackTrace();
        }

            //---------------

        }


    // -------  ******


}
