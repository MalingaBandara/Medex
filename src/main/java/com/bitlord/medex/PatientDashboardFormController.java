package com.bitlord.medex;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientDashboardFormController {


    public AnchorPane patientDashboardContext;
    public Label lblDate;
    public Label lblTime;

    public void navigateToNewAppointmentPage(ActionEvent actionEvent) throws IOException {

        setUI( "NewAppointmentForm" );

    }

    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) patientDashboardContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }


}
