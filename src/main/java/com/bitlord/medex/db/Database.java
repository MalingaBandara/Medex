package com.bitlord.medex.db;

import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.dto.PatientDto;
import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.AccountType;
import com.bitlord.medex.enums.GenderType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database {


    // ------- First Table - Users
        public static ArrayList<UserDto> userTable = new ArrayList();

    // ------- Second Table - Doctors
        public static ArrayList<DoctorDto> doctorTable = new ArrayList();

    // ------- Second Table - Doctors
    public static ArrayList<PatientDto> patientTable = new ArrayList<>();
    //------------



    // Create Default users
        static {
            //---------------
                userTable.add( new UserDto( "Jhon", "Brw", "john@gmail.com","1234", AccountType.PATIENT) ); // Patient User

                userTable.add( new UserDto( "Malinga", "Bandara", "malinga@gmail.com","1234", AccountType.DOCTOR) ); // Doctor User

            //---------------

                /*doctorTable.add( new DoctorDto(
                                                "Malinga",
                                                "Bandara",
                                                "23453",
                                                "+4535",
                                                "malinga@gmail.com",
                                                "Sample",
                                                "Colombo",
                                                GenderType.MALE
                                ) ) ;*/

            //---------------

            try{
                patientTable.add(
                        new PatientDto("95","Hasika","Sandaruwan",
                                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                                ,GenderType.MALE,"Galle","hasika@gmail.com"));
                patientTable.add(
                        new PatientDto("124","Samantha","Bandara",
                                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                                ,GenderType.MALE,"Aluthgama","samantha@gmail.com"));
                patientTable.add(
                        new PatientDto("452","Namal","Chandana",
                                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                                ,GenderType.MALE,"Kalutara","namal@gmail.com"));
                patientTable.add(
                        new PatientDto("457","Wasantha","nihal",
                                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                                ,GenderType.MALE,"Wadduwa","wasantha@gmail.com"));
                patientTable.add(
                        new PatientDto("8745","Banda","samanmal",
                                new SimpleDateFormat("yyyy-MM-dd").parse("1880-10-16")
                                ,GenderType.MALE,"Panadura","banda@gmail.com"));
            }catch (Exception e){
                e.printStackTrace();
                //System.out.println(e);
                //System.out.println(e.getMessage());
            }

        //----------------

        }


    // -------  ******


}
