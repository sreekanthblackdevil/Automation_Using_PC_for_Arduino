package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SettingsController {
    @FXML
    private ToggleButton AutoConnectOption;

    @FXML
    private CheckBox trayOption;
    @FXML
    private Slider SeekBar;
    @FXML
    private CheckBox alwaysOnTop;
    private double x, y;
    @FXML
    private SplitMenuButton themeOp;

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void autoConn() {
        AutoConnectOption.setText(AutoConnectOption.getText().equals("ON") ? "OFF" : "ON");
    }

    @FXML
    void opacityAdjust(MouseEvent event) {

    }

    @FXML
    void opacitySet(MouseEvent event) {

    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void save(MouseEvent event) {

    }

    @FXML
    void selectDark(ActionEvent event) {
        themeOp.setText("Dark");
    }

    @FXML
    void selectLight(ActionEvent event) {
        themeOp.setText("Light");
    }

}
