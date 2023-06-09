package com.bitlord.medex;

import com.bitlord.medex.dto.User;
import com.bitlord.medex.enums.AccountType;
import com.bitlord.medex.util.CrudUtil;
import com.bitlord.medex.util.IdGenerator;
import com.bitlord.medex.util.PasswordConfig;
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
import java.sql.SQLException;


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

            User user = new User(txtFirstName.getText(),
                    txtLastName.getText(),
                    txtEmail.getText().trim().toLowerCase(),
                     new PasswordConfig().enctypt( txtPassword.getText() ) , //txtPassword.getText()
                    rBtnDoctor.isSelected() ? AccountType.DOCTOR : AccountType.PATIENT);


                // after user get registered redirect Login form
                setUi();

    //  *============================*
        try {
            String id = new IdGenerator().generateId( "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1", "U" );
                //  execute
                    boolean isSaved = CrudUtil.execute(
                            "INSERT INTO user VALUES ( ?, ?, ?, ?, ?, ?)",
                                id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getAccountType().name()
                    );

                    if (isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
                    }else {
                        new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                    }

                /*===============================*/


        } catch (ClassNotFoundException | SQLException e ) {
                        e.printStackTrace();
                    }

    //  *============================*

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
