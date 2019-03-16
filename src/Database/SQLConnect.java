package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class SQLConnect {

    private SQLConnect() {

    }

    static SQLConnect getInstance() {
        return new SQLConnect();
    }

    private Connection connection = null;

    Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Data.sqlite");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
