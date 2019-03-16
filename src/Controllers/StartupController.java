package Controllers;

import BasicActivity.LaunchPrimary;
import BasicActivity.Startup;
import Database.Update;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartupController {
    @FXML
    private TextField NameField;

    @FXML
    private RadioButton dark;
    @FXML
    private Label warning;

    @FXML
    private Label TextError;
    @FXML
    private RadioButton light;
    private double x, y;
    private Startup startup = new Startup();

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void typed() {
        TextError.setText("Hello " + NameField.getText());
    }

    @FXML
    void darkPressed() {
        dark.setSelected(true);
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void finish(MouseEvent event) throws Exception {
        Update update = new Update();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (light.isSelected() || dark.isSelected() && !(NameField.getText().isEmpty())) {
            Parent theme;
            if (dark.isSelected())
                theme = FXMLLoader.load(getClass().getResource("/Layouts/DarkTheme.fxml"));
            else theme = FXMLLoader.load(getClass().getResource("/Layouts/LightTheme.fxml"));
            update.setTheme(light.isSelected() ? "Light" : "Dark");
             update.setName(NameField.getText());
             update.setFirstTime(false);
            LaunchPrimary.launchPrimaryStage(stage, theme);
        } else {

            if (NameField.getText().isEmpty()) TextError.setText("Name Field is Empty !");
            else warning.setText("Select Theme !");
        }

    }

    @FXML
    void lightPressed() {
        light.setSelected(true);
    }

    @FXML
    void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void pressed(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        x = event.getSceneX();
        y = event.getSceneY();
        stage.setOpacity(0.7);
    }

    @FXML
    void released(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setOpacity(1.0);
    }
}
