package com.bitlord.medex.dto;

import com.bitlord.medex.enums.GenderType;

public class DoctorDto {

    private String firstName;
    private String lastName;
    private String nic;
    private String contact;
    private String email;
    private String specializations;
    private String Address;
    private GenderType gender;

    // Constructor
        // full args Constructor
        public DoctorDto(String firstName, String lastName, String nic, String contact, String email, String specializations, String address, GenderType gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nic = nic;
            this.contact = contact;
            this.email = email;
            this.specializations = specializations;
            Address = address;
            this.gender = gender;
        }

        // no args Constructor
        public DoctorDto() {
        }


    // setters and getters - Enscap
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }
}
