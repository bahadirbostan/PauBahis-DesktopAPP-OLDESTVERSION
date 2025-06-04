module com.example.pb_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.pb_01 to javafx.fxml;
    exports com.example.pb_01;
    exports com.example.pb_01.PaneControllers;
    opens com.example.pb_01.PaneControllers to javafx.fxml;
    exports com.example.pb_01.Bet;
    opens com.example.pb_01.Bet to javafx.fxml;
    exports com.example.pb_01.AdminPanel;
    opens com.example.pb_01.AdminPanel to javafx.fxml;
}