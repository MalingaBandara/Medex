module com.bitlord.medex {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires jbcrypt;


    opens com.bitlord.medex to javafx.fxml;

    opens com.bitlord.medex.tm to javafx.base;

    exports com.bitlord.medex;
}