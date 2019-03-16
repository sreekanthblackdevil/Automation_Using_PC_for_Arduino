
import BasicActivity.Startup;
import Controllers.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Startup startup = new Startup();
    private MainController mainController = new MainController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainController.start(startup.getLayout());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
