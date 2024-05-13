module com.example.electricitybillapp {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.electricitybillapp to javafx.fxml;
    exports com.example.electricitybillapp;
}