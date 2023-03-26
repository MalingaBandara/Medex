package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.dto.User;
import com.bitlord.medex.enums.GenderType;
import com.bitlord.medex.util.Cookie;
import com.bitlord.medex.util.CrudUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        User selectedUser = Cookie.selectedUser;

        // set texts to text fields
        txtFirstName.setText( selectedUser.getFirstName() );
        txtLastName.setText( selectedUser.getLastName() );
        txtEmail.setText( selectedUser.getEmail() );

    }

    private String generateDoctorId() throws SQLException, ClassNotFoundException { // genrate doctor id

        // last element (id)
        ResultSet result =  CrudUtil.execute( "SELECT doctor_id FROM doctor ODER BY doctor_id DESC LIMIT 1" );  // if the primary key is a string don't use this method

        // unsigned, cast, subscribe
        if ( result.next() ) {

            String selectedId = result.getString(1);// D-1**
            String[] splitData = selectedId.split("-"); // string  tokenizer, String  format
            String splitId = splitData[1];
            int id = Integer.parseInt( splitId ); // unboxing
            id++;
            return "D-" + id;

        }else { // this mean the table have no data so start id form begin
            return "D-1";
        }

    }

    public void submitDataOnAtion(ActionEvent actionEvent) {

        try {

            String docId = generateDoctorId();

            // insert values
           boolean isSave =  CrudUtil.execute( "INSERT INTO doctor VALUES (?,?,?,?,?,?,?,?)" ,

                                        docId,
                                        txtFirstName.getText(),
                                        txtLastName.getText(),
                                        txtContact.getText(),
                                        txtEmail.getText(),
                                        txtSpecializations.getText(),
                                        txtAddress.getText(),
                                        rBtnmale.isSelected()? GenderType.MALE : GenderType.Fe_MALE

                        );

           if ( isSave ) {
               new Alert( Alert.AlertType.INFORMATION, "Welcome Doctor..." ).show();
               setUI("DoctorDashbordForm");
           }


        } catch ( SQLException | ClassNotFoundException | IOException e ) {
            e.printStackTrace();
        }


    }

    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) doctorRegistrationContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }

}
