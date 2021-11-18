module com.berkan {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.berkan to javafx.fxml;
    exports com.berkan;
}