module com.example.morpion_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.morpion_ to javafx.fxml;
    exports com.example.morpion_;
}