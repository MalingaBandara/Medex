package com.bitlord.medex;


import com.bitlord.medex.enums.AccountType;
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
import java.sql.*;

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

            try {

                //  1 driver Load => dependency
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                //  2 Create a Connection
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/medex",
                        "root",
                        "spymali1021"
                );

                // 3 write a SQL
                String sql = " SELECT * FROM user WHERE CASE email =? AND account_type =? "; // query to get recode

                // 4 create statement
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString( 1, email );  // pass value to Query
                pstm.setString( 2, accountType.name() );  // pass value to Query
                ResultSet rst = pstm.executeQuery();

                    if ( rst.next() ) {
                                            // check password correction
                        if ( new PasswordConfig().decrypt(password, rst.getString( "password" )) ) {
                                 // check account type to redirect particular dashboard
                            if ( accountType.equals( AccountType.DOCTOR ) ) {
                                setUI( "DoctorDashbordForm" );
                                return;
                            }else {
                                setUI( "PatientDashboardForm" );
                                return;
                            }

                        }

                    }else {    // the email not available
                        new Alert( Alert.AlertType.WARNING,
                                String.format("We can't find an email %s", email) ).show();
                    }


            }catch ( SQLException | ClassNotFoundException e ) {
                e.printStackTrace();
            }

    }

    // Signup Form Load
    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {

        setUI( "SignupForm" );

    }


    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) logingContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }

}
