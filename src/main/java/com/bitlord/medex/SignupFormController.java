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

import java.sql.*;

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


    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException, ClassNotFoundException, SQLException {

        User user = new User(txtFirstName.getText(),
                txtLastName.getText(),
                txtEmail.getText().trim().toLowerCase(),
                txtPassword.getText(),
                rBtnDoctor.isSelected() ? AccountType.DOCTOR : AccountType.PATIENT);

        //  *============================*
        try {
                //  1 driver Load => dependency
                    Class.forName( "com.mysql.cj.jdbc.Driver" ); //com.mysql.jdbc.Driver

                //  2 Create a Connection
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/medex",
                            "root",
                            "symali1021"
                    );

                // 3 write a SQL
                    String sql = "INSERT INTO user VALUES (?,?,?,?,?,?)";

                // 4 create statement
                    PreparedStatement pstm = connection.prepareStatement(sql);
                    pstm.setInt(1,1001);
                    pstm.setString(2, user.getFirstName());
                    pstm.setString(3, user.getLastName());
                    pstm.setString(4, user.getEmail());
                    pstm.setString(5, user.getPassword());
                    pstm.setString(6, user.getAccountType().name());

                // 5 execute
                int isSaved = pstm.executeUpdate();

                if (isSaved>0){
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
                }else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }
                /*===============================*/

            } catch (ClassNotFoundException e) {
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
