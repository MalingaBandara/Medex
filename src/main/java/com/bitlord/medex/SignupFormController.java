package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.User;
import com.bitlord.medex.enums.AccountType;
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
import java.util.Optional;

public class SignupFormController {
    public JFXTextField txtPassword;
    public JFXRadioButton rBtnDoctor;
    public ToggleGroup accountType;
    public AnchorPane signupContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;


    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {

            // assign user input values
            String email = txtEmail.getText().trim().toLowerCase();

               /* for ( UserDto dto : Database.userTable) {

                    if ( dto.getEmail().equals( email.trim().toLowerCase() ) ) {

                        new Alert( Alert.AlertType.WARNING,  "Email is Already exists!" ).show();
                        return;
                    }

                }*/

                // check user's email already exists  // (stream Like using for loop to search element)
                Optional<User> SelectedUser = Database.userTable.stream() // stream like a බටයක්, so when passing data thrw බටයකින් we can filter things
                        .filter( e -> e.getEmail().equals( email ) )
                        .findFirst();

             // Selected user email already exists in database what to do next
                if (SelectedUser.isPresent() ) {
                    new Alert( Alert.AlertType.WARNING,  "Email is Already exists!" ).show();
                    return;
                }


                // account creation
                Database.userTable.add(
                        new User(
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                email, txtPassword.getText(),
                                rBtnDoctor.isSelected() ? AccountType.DOCTOR : AccountType.PATIENT
                        )
                );

                        // show an alert to confirm  user registration
                        new Alert( Alert.AlertType.CONFIRMATION, "Wellcome!" ).show();

                // after user get registered redirect Login form
                setUi();

    }


    // already have account return to Login Form
    public void signinOnAction(ActionEvent actionEvent) throws IOException {
        setUi();
    }


    // method for redirect Login form
    private void setUi() throws IOException {

        Stage stage = (Stage) signupContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/LoginForm.fxml"))));

    }



}
