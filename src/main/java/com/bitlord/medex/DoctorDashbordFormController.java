package com.bitlord.medex;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.DoctorDto;
import com.bitlord.medex.util.Cookie;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class DoctorDashbordFormController {

    public AnchorPane doctorDashboardContext;
    public Label lblDate;
    public Label lblTime;


    public void initialize() throws IOException { // initialize method
        // checkUser();
        initializeData();
    }

    private void initializeData() throws IOException {

        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        String today  = simpleDateFormat.format(date);
        lblDate.setText( today );*/
        lblDate.setText( new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() ) ); // set date to the date label

        Timeline timeline = new Timeline(  // timeline animation object
                    new KeyFrame ( Duration.seconds(0), // create new keyframe object

                                    e -> {
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "hh:mm:ss" ); // set time format
                                        lblTime.setText( LocalTime.now().format( dtf ) ); // set local time to label with format custom format of dtf
                                    }

                                )
                            ,
                            new KeyFrame( Duration.seconds( 1) ) // change time animation by one second
                );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play(); // start timeline

        //---------------
        // Check doctor account (to be implemented)
        checkDoctorData();



    }

    // Check doctor account (to be implemented)
    private void checkDoctorData() throws IOException {

        Optional<DoctorDto> selectedDoctor = Database.doctorTable.stream()
                .filter(e -> e.getEmail().equals("malinga@gmail.com"))
                .findFirst();

        if ( ! selectedDoctor.isPresent() ) {
            // open a new window -->
            setUi( "DoctorRegistrationForm" );

        }
    }


    // check to user had assigned to the Cookie
    public void checkUser() throws IOException {

        if ( null == Cookie.selectedUser ) { // when user not get

            // redirect to Log in form
            setUi( "LoginForm" );

        }

    }

    // redirect to form
    private void setUi (String location) throws IOException {

        Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
        stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/"+ location +".fxml"))));

    }

}
