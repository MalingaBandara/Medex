package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.UserDto;
import com.bitlord.medex.enums.AccountType;
import com.bitlord.medex.util.Cookie;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;
    public JFXRadioButton rBtnDoctor;
    public ToggleGroup accountType;
    public AnchorPane logingContext;

    public void signinOnAction(ActionEvent actionEvent) throws IOException {

        // get userName and password
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        // account type value set
        AccountType accountType = rBtnDoctor.isSelected()? AccountType.DOCTOR : AccountType.PATIENT;
        // if ( rBtnDoctor.isSelected() ) accountType = AccountType.DOCTOR;


            // find user in database
             for ( UserDto dto :Database.userTable ) {

                 if ( dto.getEmail().trim().toLowerCase().equals( email ) ) {                                // if email available

                     if ( dto.getPassword().equals( password ) ) { // if password correct

                         // check Account Type
                         if ( dto.getAccountType().equals( accountType ) ) {

                             // complete
                             new Alert( Alert.AlertType.CONFIRMATION, "Success!").show();

                                        // log in
                                        Cookie.selectedUser = dto;  // set cookie

                                                 Stage stage = (Stage) logingContext.getScene().getWindow();
                                                 stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/DoctorDashbordForm.fxml"))));

                             return;

                         }else {
                             // new Alert ( Alert.AlertType.WARNING, "We can't find your " + accountType + " Account" );
                             new Alert( Alert.AlertType.WARNING, String.format( "We can't find your %s Account", accountType.name() ) ).show();
                             return;
                         }

                     }else {                                       // the password incorrect then
                         new Alert( Alert.AlertType.WARNING, "Your Password is incorrect !" ).show();
                         return;
                     }

                 }

             }
        new Alert( Alert.AlertType.WARNING, String.format("We can't find an email %s", email) ).show();   // the email not available
    }

    // Signup Form Load
    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) logingContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/SignupForm.fxml"))));


    }
}
