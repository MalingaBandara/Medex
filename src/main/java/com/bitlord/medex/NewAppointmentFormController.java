package com.bitlord.medex;

import com.bitlord.medex.util.CrudUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewAppointmentFormController {
    public JFXTextField txtDate;
    public AnchorPane newAppoinmentContext;
    public JFXComboBox<String> cmbDoctor;
    public JFXTextField txtTime;
    public JFXTextField txtAmount;
    public JFXTextArea txtMessage;

    public void initialie() {
        seDoctorIds();
    }

    private void seDoctorIds() {

        try {

                ResultSet set = CrudUtil.execute("SELECT doctor_id,first_name,last_name FROM doctor"); // get doctors data

                    ObservableList<String> obList = FXCollections.observableArrayList(); // list to add recodes

                        while (set.next() ) {
                                obList.add(set.getString( 1) );
                        }

                cmbDoctor.setItems( obList );

        } catch ( SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void seeAvailabilityOnAction(ActionEvent actionEvent) {
    }

    public void submitDataOnAction(ActionEvent actionEvent) {

    }

    public void backToHmeOnAction(ActionEvent actionEvent) {

    }
}
