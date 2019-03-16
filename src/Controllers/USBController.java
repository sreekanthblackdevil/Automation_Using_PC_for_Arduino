package Controllers;

import Communications.USBSupport;
import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class USBController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label connectionStatus;
    private double x, y;

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void connect(MouseEvent event) {
        ObservableList<Integer> ListInput = listView.getSelectionModel().getSelectedIndices();
        boolean status = USBSupport.Connect(ListInput);
        connectionStatus.setText(status ? "Connected" : "Failed to Connect");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void refresh() {
        listView.getItems().clear();
        for (SerialPort ports : USBSupport.listPorts())
            listView.getItems().addAll(ports.getDescriptivePortName());
        listView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
    }

}
