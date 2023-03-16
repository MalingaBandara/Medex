package com.bitlord.medex;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupFormController {
    public JFXTextField txtPassword;
    public JFXRadioButton rBtnDoctor;
    public ToggleGroup accountType;
    public AnchorPane signupContext;


    public void createAnAccountOnAction(ActionEvent actionEvent)  {

    }


    // already have account return to Login Form
    public void signinOnAction(ActionEvent actionEvent) throws IOException {


        Stage stage = (Stage) signupContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/LoginForm.fxml"))));


    }



}
