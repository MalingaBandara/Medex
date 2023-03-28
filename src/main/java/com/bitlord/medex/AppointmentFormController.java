package com.bitlord.medex;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentFormController {

    public AnchorPane appointmentsContex;
    public DatePicker txtDateFrom;
    public DatePicker txtDateTo;
    public JFXRadioButton rBtnPending;
    public ToggleGroup type;
    public JFXRadioButton rBtnCompleted;
    public TableView tblAppointment;
    public TableColumn colId;
    public TableColumn colPatient;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAmount;
    public TableColumn colCheckState;
    public TableColumn colManage;


    public void searchDataOnAction(ActionEvent actionEvent) {
    }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUI( "DoctorDashbordForm" );
    }

    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) appointmentsContex.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }
}
