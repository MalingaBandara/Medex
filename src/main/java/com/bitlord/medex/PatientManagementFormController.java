package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.PatientDto;
import com.bitlord.medex.tm.PatientTm;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
        loadAllData(""); // search text
    }


    // search items
    private void loadAllData(String s) {

        s = s.toLowerCase(); // immutable
        ObservableList <PatientTm> tmList = FXCollections.observableArrayList();

        for (PatientDto dto: Database.patientTable ) {

            if (  dto.getFirstName().contains(s) || dto.getLastName().contains(s) || dto.getEmail().contains(s) ) {

                tmList.add( new PatientTm( dto.getNic(), dto.getFirstName(), dto.getLastName(), dto.getDob(), dto.getGenderType(), dto.getAddress(), 10, dto.getEmail()) );


            }

        }

        tblPatients.setItems( tmList );

    }

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }
}
