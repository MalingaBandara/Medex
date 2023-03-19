package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.GenderType;
import com.bitlord.medex.util.Cookie;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    public AnchorPane doctorRegistrationContext;
    public JFXButton btnSubmit;


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

    public void submitDataOnAtion(ActionEvent actionEvent) {

        // ----------------- NIC Field Validate
        // NIC conflict check
        if ( Database.doctorTable.stream().filter( e->  e.getNic().equals( txtNic.getText().trim() )  ).findFirst().isPresent() ) {

            new Alert( Alert.AlertType.WARNING, "NIC Conflict" ).show();

            // disable submit button
            btnSubmit.setDisable( true );
            return;
        }
        // -----------------


        // recode data
        DoctorDto doctorDto = new DoctorDto(
                txtFirstName.getText().trim(),
                txtLastName.getText().trim(),
                txtNic.getText().trim(),
                txtContact.getText().trim(),
                txtEmail.getText().trim(),
                txtSpecializations.getText().trim(),
                txtAddress.getText().trim(),
                rBtnmale.isSelected()? GenderType.MALE : GenderType.Fe_MALE
        );

        // pass recode data to database
        Database.doctorTable.add( doctorDto );

        // close window
        Stage stage = (Stage) doctorRegistrationContext.getScene().getWindow();
        stage.close();

    }
}
