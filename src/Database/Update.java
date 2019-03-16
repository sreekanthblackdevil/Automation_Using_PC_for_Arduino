package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    public void setName(String Name) {
        Connection connection = SQLConnect.getInstance().connect();
        try {
           PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UserData SET name = ?");
            preparedStatement.setString(1, Name);
            int i = preparedStatement.executeUpdate();
            if (i == 1)
                System.out.println("Name Success");
            else System.out.println("Name failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFirstTime(boolean data) {
        Connection connection = SQLConnect.getInstance().connect();
        try {
           PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UserData SET FirstTime = ?");
            preparedStatement.setBoolean(1, data);
            int i = preparedStatement.executeUpdate();
            if (i == 1)
                System.out.println("FT Success");
            else System.out.println("FT failed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTrayOption(boolean data) {
        Connection connection = SQLConnect.getInstance().connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UserData SET TrayOption = ?");
            preparedStatement.setBoolean(1, data);
            int i = preparedStatement.executeUpdate();
            if (i == 1)
                System.out.println("ST Success");
            else System.out.println("ST failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void setTheme(String data)  {
        Connection connection = SQLConnect.getInstance().connect();
        String query = "UPDATE UserStyles SET Theme = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, data);
            int i = 0;
            try {
                i = preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            if (i == 1)
                System.out.println("Theme Success");
            else System.out.println("Theme failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void setOpacity(double data){
        Connection connection = SQLConnect.getInstance().connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UserStyles SET Opacity = ?");
            preparedStatement.setDouble(1, data);
            int i = preparedStatement.executeUpdate();
            if (i == 1)
                System.out.println("Op Success");
            else System.out.println("OP failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
