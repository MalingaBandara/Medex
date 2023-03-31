package com.bitlord.medex;

import com.bitlord.medex.tm.AllAppointmentTm;
import com.bitlord.medex.util.Cookie;
import com.bitlord.medex.util.CrudUtil;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentFormController {

    public AnchorPane appointmentsContex;
    public DatePicker txtDateFrom;
    public DatePicker txtDateTo;
    public JFXRadioButton rBtnPending;
    public ToggleGroup type;
    public JFXRadioButton rBtnCompleted;
    public TableView<AllAppointmentTm> tblAppointment;
    public TableColumn colId;
    public TableColumn colPatient;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAmount;
    public TableColumn colCheckState;
    public TableColumn colManage;
    public JFXRadioButton rBtnAll;

    String selectedDoctorId = ""; // set current doctor


    public void initialize() {
        loadDoctorData();
        loadAppointments();

        // set values in to Columns
        colId.setCellValueFactory( new PropertyValueFactory<>( "id" ));
        colAmount.setCellValueFactory( new PropertyValueFactory<>( "amount" ));
        colManage.setCellValueFactory( new PropertyValueFactory<>( "btn" ));
        colCheckState.setCellValueFactory( new PropertyValueFactory<>( "checkState" ));
        colDate.setCellValueFactory( new PropertyValueFactory<>( "date" ));
        colPatient.setCellValueFactory( new PropertyValueFactory<>( "patient" ));
        colTime.setCellValueFactory( new PropertyValueFactory<>( "time" ));


        // check radio button and filter according to it
        // Pending filter
        rBtnPending.selectedProperty().addListener( new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    loadAppointments();
                }
            }
        });

        // Completed filter
        rBtnCompleted.selectedProperty().addListener( new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    loadAppointments();
                }
            }
        });

        // All filter
        rBtnAll.selectedProperty().addListener( new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    loadAppointments();
                }
            }
        });

    }


    // get current doctor who log in to this system now
    private void loadDoctorData() {

        try {

            ResultSet set = CrudUtil.execute( "SELECT doctor_id FROM doctor WHERE email=?", Cookie.selectedUser.getEmail() ); // get patient_id using email

            if ( set.next() ) {

                selectedDoctorId = set.getString(1); // set patient id to global variable

            } else { // not patient
                // => redirect patient registration
                setUI( "PatientRegistrationForm" );

            }


        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }


    // load particular appointments data
    private void loadAppointments() {

        ObservableList<AllAppointmentTm> tmList = FXCollections.observableArrayList(  );

        // check from date & to date Select ?
        // all, completed, pending

        String sql = "SELECT a.*, p.first_name, p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND p.patient_id = a.patient_id";

        // filter by status
        if ( rBtnPending.isSelected() ) { // pending status
            sql = "SELECT a.*, p.first_name, p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND a.check_state=0 AND p.patient_id = a.patient_id";
        } else if ( rBtnCompleted.isSelected() ) { // completed status
            sql = "SELECT a.*, p.first_name, p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND a.check_state=1 AND p.patient_id = a.patient_id";
        }

        try {

            ResultSet set = CrudUtil.execute(sql, selectedDoctorId);

            while (set.next() ) {

                Button btn = new Button( "manage" ); // create a button to manage recode

                AllAppointmentTm tm = new AllAppointmentTm(
                        set.getString( 1 ),
                        set.getString( "first_name" ) + " " + set.getString("last_name" ),
                        set.getString( "date" ),
                        set.getString( "time" ),
                        set.getDouble( "amount" ),
                        set.getInt( "check_state" ) == 0 ? "Pending" : "Completed",
                        btn
                );

                tmList.add( tm ); // add data to Observable List which include All Appointment Tm values

            }

            tblAppointment.setItems( tmList ); // pass ObservableList data into table

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



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
