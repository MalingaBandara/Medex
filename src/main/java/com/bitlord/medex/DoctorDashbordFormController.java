package com.bitlord.medex;

import com.bitlord.medex.util.Cookie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorDashbordFormController {

    public AnchorPane doctorDashboardContext;



    public void initialize() throws IOException { // initialize method
        checkUser();
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
