package com.bitlord.medex;

import com.bitlord.medex.tm.DoctorComboView;
import com.bitlord.medex.util.Cookie;
import com.bitlord.medex.util.CrudUtil;
import com.bitlord.medex.util.IdGenerator;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class NewAppointmentFormController {
    public JFXTextField txtDate;
    public AnchorPane newAppoinmentContext;

    public JFXTextField txtTime;
    public JFXTextField txtAmount;
    public JFXTextArea txtMessage;
    public JFXComboBox<String> cmbDoctor;

    String selectedDoctorId = ""; // get doctor id
    String selectedPatientId = ""; // get patient id

    private ArrayList <DoctorComboView> viewList = new ArrayList<>();


    public void initialize() {

        seDoctorIds(); // load doctor name and ids in combo box
        setPatientData(); // get current patient who log in to this system now
    }

    private void setPatientData() {  // get current patient who log in to this system now

            try {

                ResultSet set = CrudUtil.execute( "SELECT patient_id FROM patient WHERE email=?", Cookie.selectedUser.getEmail() ); // get patient_id using email

                        if ( set.next() ) {

                                selectedPatientId = set.getString(1); // set patient id to global variable

                        } else { // not patient
                            // => redirect patient registration
                            setUI( "PatientRegistrationForm" );

                        }


            } catch (SQLException | ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

    }


    private void seDoctorIds() {

        try {

            ResultSet set = CrudUtil.execute("SELECT doctor_id,first_name,last_name FROM doctor"); // get doctors data

                ObservableList<String> obList = FXCollections.observableArrayList(); // list to add recodes

                        int index = 1; // to genarate doctor id

                        while (set.next() ) {

                                    DoctorComboView viewData = new DoctorComboView(index, set.getString(1),
                                                                set.getString(2) + " " + set.getString(3));

                                viewList.add( viewData );

                            obList.add( index + "." + viewData.getName() );

                        index ++;

                        }

                cmbDoctor.setItems( obList );

        } catch ( SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void submitDataOnAction(ActionEvent actionEvent) {

        String id = new IdGenerator().generateId("SELECT appointment_id FROM appointment ORDER BY appointment_id DESC LIMIT 1", "A");


        try {

            boolean isSaved = CrudUtil.execute( "INSERT INTO appointment VALUES(?,?,?,?,?,?,?)",
                    id,
                    txtDate.getText(),
                    txtTime.getText(),
                    Double.parseDouble( txtAmount.getText() ),
                    false,
                    selectedPatientId,
                    selectedDoctorId

            );

            if ( isSaved ) {
                new Alert( Alert.AlertType.INFORMATION, "Completed" ).show();
                setUI("PatientDashboardForm");
            }

        } catch (SQLException | ClassNotFoundException | IOException e ) {
            e.printStackTrace();
        }

    }


    public void seeAvailabilityOnAction(ActionEvent actionEvent) {

        Optional<DoctorComboView> selectedRecode = viewList.stream().filter(
                e -> e.getIndex() == Integer.parseInt(cmbDoctor.getValue()
                        .split("\\.")[0])).findFirst();

        if ( selectedRecode.isPresent() ) {
            // print
            selectedDoctorId = selectedRecode.get().getDocId(); // assign doctor id to global variable
            txtAmount.setText( String.valueOf( new Random().nextInt(1000) ) ); // generate random amount

        }else {
            System.out.println("Empty");
        }

    }


    public void backToHmeOnAction(ActionEvent actionEvent) throws IOException {
        setUI( "PatientDashboardForm" );
    }

    // method for redirect forms
    private void setUI ( String location ) throws IOException {

        Stage stage = (Stage) newAppoinmentContext.getScene().getWindow();

        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }
}
