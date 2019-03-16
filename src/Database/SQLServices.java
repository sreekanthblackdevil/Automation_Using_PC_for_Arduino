package Database;

import java.sql.Connection;

public class SQLServices {

    public static Connection Connect() throws Exception {
        return SQLConnect.getInstance().connect();
    }

    Connection connection() {
        try {///SQL Connection//////////////////////////////
            System.out.println("Connected");
            return SQLConnect.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect the database !");
            return null;
        }
    }
}
