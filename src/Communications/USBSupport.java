package Communications;

import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.ObservableList;

public class USBSupport {
    private static SerialPort ConnectedPort = null;

    public static SerialPort getConnectedPort() {
        return ConnectedPort;
    }

    public static boolean Connect(ObservableList<Integer> ListInput) {
        ObservableList<Integer> sample;
        (sample = ListInput).toArray();
        SerialPort port[] = listPorts();
        System.out.println(ListInput);
        for (int i = 0; i < port.length; i++) {
            for (int index : sample)
                if (i == index) {
                    ConnectedPort = port[i];
                    System.out.println("True" + i);
                    try {
                        port[i].openPort();
                    } catch (Exception e) {
                        return false;
                    }
                }
        }
        return ConnectedPort.isOpen();
    }

    public static SerialPort[] listPorts() {
        return SerialPort.getCommPorts();
    }
}
