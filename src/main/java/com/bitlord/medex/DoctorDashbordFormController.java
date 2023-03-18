package com.bitlord.medex;

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

public class DoctorDashbordFormController {

    public AnchorPane doctorDashboardContext;
    public Label lblDate;
    public Label lblTime;


    public void initialize() throws IOException { // initialize method
        // checkUser();
        initializeData();
    }

    private void initializeData() {

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

    }


    // check to user had assigned to the Cookie
    public void checkUser() throws IOException {

        if ( null == Cookie.selectedUser ) { // when user not get

            // redirect to Log in form
            Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
            stage.setScene( new Scene( FXMLLoader.load( getClass().getResource("/com/bitlord/medex/LoginForm.fxml"))));

        }

    }

}
