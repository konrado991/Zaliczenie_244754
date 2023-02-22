module SampleFX {

    requires javafx.fxml;
    requires javafx.controls;
    requires jackson.databind;
    requires java.sql;

//    exports sample to javafx.graphics;
    opens sample;
}