package Controllers;

import Communications.USBSupport;
import Database.FetchData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField commandField;

    @FXML
    private TextArea outputField;

    @FXML
    private Label errorField;

    @FXML
    private Label NameField;

    private FetchData fetchData = new FetchData();
    private double x, y;
    private boolean flip = true;
    private Stage MainStage = new Stage();

    @FXML
    void clear_console() {
        outputField.clear();
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void connect(MouseEvent event) throws Exception {
        //Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/Layouts/ConnectOptions.fxml"))));
        stage.show();
        stage.setAlwaysOnTop(true);
    }

    @FXML
    void disconnect() {
        try {
            USBSupport.getConnectedPort().closePort();
            outputField.appendText("-> Disconnected" + "\n");
        } catch (Exception e) {
            outputField.appendText("-> " + e + "\n");
        }
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void microphone() {

    }

    @FXML
    void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void opacityChange(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (flip) {
            stage.setOpacity(0.2);
            flip = false;
        } else {
            stage.setOpacity(1.0);
            flip = true;
        }
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
        flip = true;
    }

    @FXML
    void send() {
        if (commandField.getText().isEmpty()) {
            errorField.setText("Field Empty !");
        } else {
            errorField.setText(" ");
            String Command = commandField.getText();
            outputField.appendText("-> " + Command + "\n");
        }
    }

    @FXML
    void settings() throws Exception {
        Stage Settings = new Stage();
        Settings.initStyle(StageStyle.TRANSPARENT);
        Settings.setScene(new Scene(FXMLLoader.load(getClass().getResource("/Layouts/Settings.fxml"))));
        Settings.show();
    }

    @FXML
    void vanish(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!flip) {
            stage.setOpacity(0.2);
        }
    }

    @FXML
    void visible(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!flip) {
            stage.setOpacity(1.0);
        }
    }

    public void start(Parent Layout) {
        MainStage.initStyle(StageStyle.TRANSPARENT);
        MainStage.setScene(new Scene(Layout));
        MainStage.setOpacity(fetchData.getOpacity());
        MainStage.setAlwaysOnTop(fetchData.getAlwaysOnTop());
        MainStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameField.setText("Hello " + fetchData.getName());
    }

}
