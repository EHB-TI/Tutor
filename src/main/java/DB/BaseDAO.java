package DB;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    private Connection conn = null;

    public BaseDAO(Connection c)
    {
        this.conn = c;
    }
    public BaseDAO(){};


    public Connection getConn()
    {
        try {
            if (conn == null || conn.isClosed())
                conn = DBSingleton.getInstance().getConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
