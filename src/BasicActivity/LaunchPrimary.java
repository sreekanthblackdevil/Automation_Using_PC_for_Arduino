package BasicActivity;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class LaunchPrimary{

    public static void launchPrimaryStage(Stage stage, Parent Theme){
        stage.setScene(new Scene(Theme));
    }


}
