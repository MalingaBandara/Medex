package com.bitlord.medex.dto;

import com.bitlord.medex.enums.GenderType;

import java.util.Date;

public class PatientDto {

    private String nic;
    private String firstName;
    private String lastName;
    private Date dob;
    private GenderType genderType;
    private String address;
    private String email;

       // Constructor
             // full args Constructor
            public PatientDto(String nic, String firstName, String lastName, Date dob, GenderType genderType, String address, String email) {
                this.nic = nic;
                this.firstName = firstName;
                this.lastName = lastName;
                this.dob = dob;
                this.genderType = genderType;
                this.address = address;
                this.email = email;
            }

            // no args Constructor
            public PatientDto() {
            }

                // toString Method - dev perpos
                @Override
                public String  toString() {
                    return "PatientDto{" +
                            "nic='" + nic + '\'' +
                            ", firstName='" + firstName + '\'' +
                            ", lastName='" + lastName + '\'' +
                            ", dob=" + dob +
                            ", genderType=" + genderType +
                            ", address='" + address + '\'' +
                            ", email='" + email + '\'' +
                            '}';
                }

    // setters and getters - Enscap
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
