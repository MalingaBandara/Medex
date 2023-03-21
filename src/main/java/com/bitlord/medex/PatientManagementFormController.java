package com.bitlord.medex;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class PatientManagementFormController {
    public JFXTextField txtSerach;
    public TableView tblPatients;
    public AnchorPane patientContext;
    public TableColumn colNic;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;

    public void backToHomeOnAction(ActionEvent actionEvent) {
    }
}
