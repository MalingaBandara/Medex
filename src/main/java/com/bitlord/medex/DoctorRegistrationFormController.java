package com.bitlord.medex;

import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.util.Cookie;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

public class DoctorRegistrationFormController {
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextArea txtAddress;
    public JFXRadioButton rBtnmale;
    public ToggleGroup gender;
    public JFXTextField txtSpecializations;


    public void initialize() {
        // load user data
        loadUserData();
    }

    private void loadUserData() {

        UserDto selectedUser = Cookie.selectedUser;

        // set texts to text fields
        txtFirstName.setText( selectedUser.getFirstName() );
        txtLastName.setText( selectedUser.getLastName() );
        txtEmail.setText( selectedUser.getEmail() );

    }

    public void submitDataOnAtion(ActionEvent actionEvent) { // 50:58

    }
}
