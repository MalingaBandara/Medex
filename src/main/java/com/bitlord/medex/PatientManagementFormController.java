package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.PatientDto;
import com.bitlord.medex.enums.GenderType;
import com.bitlord.medex.tm.PatientTm;
import com.bitlord.medex.util.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PatientManagementFormController {
    public JFXTextField txtSerach;
    public TableView< PatientTm > tblPatients;
    public AnchorPane patientContext;

    public TableColumn colNic;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;


    public  void initialize () {
        loadAllData(""); // search

        // search text
        txtSerach.textProperty().addListener( ( observable, oldValue, newValue ) -> {
                loadAllData( newValue );
        } );

        //setdatabasevaluestotable
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("genderType"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }



    private void loadAllData(String s) {

        ObservableList <PatientTm> tmList = FXCollections.observableArrayList(); // object of PatientTm

        String searchText = "%" + s + "%";

        try {

            ResultSet set = CrudUtil.execute("SELECT * FROM patient WHERE email LIKE ? OR first_name LIKE ? OR last_name LIKE ?   ",
                    searchText, searchText, searchText); // search query

                while ( set.next() ) {

                    tmList.add ( new PatientTm(
                                                set.getString( 6 ), // Nic
                                                set.getString( 2 ), // first name
                                                set.getString(3 ),  // last name
                                                new SimpleDateFormat( "yyyy-MM-dd" ).format( set.getDate( 8 ) ), // dob
                                                set.getString( 9 ) == "MALE" ? GenderType.MALE : GenderType.FE_MALE, // gender
                                                set.getString( 7 ),    // address
                                                0,                 // age
                                                set.getString( 4 )     // email
                    ));

                }

            tblPatients.setItems( tmList );

        } catch ( SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }
}
