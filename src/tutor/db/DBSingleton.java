package tutor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
    private static DBSingleton instance = null;
    private Connection conn = null;
    private DBSingleton(){}

    public static DBSingleton getInstance()
    {
        if (instance == null)
        {
            instance = new DBSingleton();
        }
        return instance;
    }

    public Connection getConn()
    {
        try {
            if (conn == null || conn.isClosed()){
                conn = DriverManager.getConnection("jdbc:mysql://", "", "");// NOG VRAGEN !
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
