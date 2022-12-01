module com.example.dictionary11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionary11 to javafx.fxml;
    exports com.example.dictionary11;
}