module com.bitlord.medex {
    requires javafx.controls;
    requires javafx.fxml;
    //requires jfoenix;
    requires com.jfoenix;


    opens com.bitlord.medex to javafx.fxml;
    exports com.bitlord.medex;
}