package com.bitlord.medex;

import com.bitlord.medex.dto.User;
import com.bitlord.medex.enums.GenderType;
import com.bitlord.medex.util.Cookie;
import com.bitlord.medex.util.CrudUtil;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRegistrationFormController {
    public AnchorPane patientRegistrationContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextArea txtAddress;
    public ToggleGroup gender;
   
    public JFXRadioButton rBtnmale;
    public DatePicker txtDob;


    public void initialize() {
        // load user data
        loadUserData();

    }

    private void loadUserData() {

        User selectedUser = Cookie.selectedUser;

        // set texts to text fields
        txtFirstName.setText( selectedUser.getFirstName() );
        txtLastName.setText( selectedUser.getLastName() );
        txtEmail.setText( selectedUser.getEmail() );

    }


    private String generatePatientId() throws SQLException, ClassNotFoundException { // genrate patient id

        // last element (id)
        ResultSet result =  CrudUtil.execute( "SELECT patient_id FROM patient ORDER BY patient_id DESC LIMIT 1" );  // if the primary key is a string don't use this method

        if (result.next()) {
            int lastId = Integer.parseInt( result.getString("patient_id").split("-")[1] );
            lastId++;
            return "P-" + lastId; // String builder, String buffer
        }

        return "P-1";

    }


    public void submitDataOnAtion(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {

            String patientId = generatePatientId();

            // insert values
            boolean isSave =  CrudUtil.execute( "INSERT INTO patient VALUES (?,?,?,?,?,?,?,?,?)" ,

                    patientId,
                    txtFirstName.getText(),
                    txtLastName.getText(),
                    txtEmail.getText(),
                    txtContact.getText(),
                    txtNic.getText(),
                    txtAddress.getText(),
                    txtDob.getValue(),
                    rBtnmale.isSelected() ? GenderType.MALE.name() : GenderType.FE_MALE.name()

            );

            if ( isSave ) {
                new Alert( Alert.AlertType.INFORMATION, "Welcome Patient..." ).show();
                setUI("PatientDashboardForm");
            }


        } catch ( SQLException | ClassNotFoundException | IOException e ) {
            e.printStackTrace();
        }

    }


    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) patientRegistrationContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }
}
