package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.UserDto;
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


    public void createAnAccountOnAction(ActionEvent actionEvent)  {

        String email = txtEmail.getText().trim().toLowerCase();
        /*for(UserDto dto:Database.userTable){
            if(dto.getEmail().equals(email.trim().toLowerCase())){
                new Alert(Alert.AlertType.WARNING,
                        "email is already exist!s").show();
                return;
            }
        }*/
        Optional<UserDto> selectedUser = Database.userTable.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
        if (selectedUser.isPresent()){
            new Alert(Alert.AlertType.WARNING,
                    "email is already exists!").show();
            return;
        }
        Database.userTable.add(
                new UserDto(txtFirstName.getText(),
                        txtLastName.getText(),
                        email,
                        txtPassword.getText(),
                        rBtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT)
        );
        new Alert(Alert.AlertType.CONFIRMATION,
                "Welcome!").show();

    }


    // already have account return to Login Form
    public void signinOnAction(ActionEvent actionEvent) throws IOException {


        Stage stage = (Stage) signupContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/LoginForm.fxml"))));


    }



}
