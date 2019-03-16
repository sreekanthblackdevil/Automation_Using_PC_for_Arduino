package BasicActivity;

import Database.FetchData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Startup {
    private FetchData fetchData = new FetchData();

    public Parent getLayout() throws Exception {//set Layout////////////////////////////
        System.out.println(fetchData.getTheme());
        System.out.println(fetchData.getFirstTime());
        Parent layout;
        if (fetchData.getFirstTime()) {
            layout = FXMLLoader.load(getClass().getResource("/Layouts/Startup.fxml"));
        } else {
            switch (fetchData.getTheme()) {
                case "Dark":
                    layout = FXMLLoader.load(getClass().getResource("/Layouts/DarkTheme.fxml"));
                    break;
                case "Light":
                    layout = FXMLLoader.load(getClass().getResource("/Layouts/LightTheme.fxml"));
                    break;
                default:
                    layout = FXMLLoader.load(getClass().getResource("/Layouts/Startup.fxml"));
            }
        }
        return layout;
    }
}
