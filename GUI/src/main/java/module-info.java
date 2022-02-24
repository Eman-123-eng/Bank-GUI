module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.gui.adding;
    opens com.example.gui.adding to javafx.fxml;
    exports com.example.gui.editing;
    opens com.example.gui.editing to javafx.fxml;
    exports com.example.gui.deleting;
    opens com.example.gui.deleting to javafx.fxml;
}