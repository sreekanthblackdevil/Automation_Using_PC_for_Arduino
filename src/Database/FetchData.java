package Database;

import java.sql.Connection;
import java.sql.SQLException;

public class FetchData {

    public String getName() {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserData").executeQuery().getString(3);
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getTheme() {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserStyles").executeQuery().getString(1);
        } catch (Exception e) {
            return null;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean getFirstTime() {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserData").executeQuery().getBoolean(1);
        } catch (Exception e) {
            return true;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean getTrayOption() {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserData").executeQuery().getBoolean(2);
        } catch (Exception e) {
            return false;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double getOpacity() {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserStyles").executeQuery().getDouble(2);
        } catch (Exception e) {
            return 1;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean getAlwaysOnTop(){
        Connection connection = SQLConnect.getInstance().connect();
        try {
            return connection.prepareStatement("SELECT * FROM UserData").executeQuery().getBoolean(4);
        } catch (Exception e) {
            return false;
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
