package com.bitlord.medex;

import com.bitlord.medex.util.Cookie;
import com.bitlord.medex.util.CrudUtil;
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
import java.sql.ResultSet;
import java.sql.SQLException;

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

    String selectedDoctorId = "";


    public void initialize() {
        loadDoctorData();
        loadAppointments();
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

        // check from date & to date Select ?
        // all, completed, pending

        String sql = "SELECT a.*, p.first_name, p.last_name FROM appointment a JOIN patient p ON a.doctor_id=? AND p.patient_id = a.patient_id";

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
