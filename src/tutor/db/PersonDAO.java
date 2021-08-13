package tutor.db;

import tutor.entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

public class PersonDAO extends BaseDAO {
    public PersonDAO() {
    }

    public boolean createUser(User p) {
        if (p.checkEmailForUser(p.getEmail()) == false) {
            System.out.println(p.getEmail() + "is already used, try another one");
            return false;
        }
        if (p.checkEmailForUser(p.getEmail())) {
            try (Connection c = getConn()) {
                PreparedStatement s = c.prepareStatement("insert into USERS values ()"); // DATABASE NOG MAKEN
                s.setString(, p.getFirstName()); // INDEX NOG INVOEREN NA DB CREATIE
                s.setString(, p.getLastName());
                s.setString(, p.getEmail());
                s.setString(, p.getPassword());
                s.setInt(, p.getRole());
                int result = s.executeUpdate();
                if (result > 0)
                    return true;
                else
                    return false;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public boolean createTutor(User p) {

        try (Connection c = getConn()) {
            PreparedStatement s = c.prepareStatement("insert into  values ()"); //NOG AANVULLEN
            s.setString(, p.getFirstName()); //NOG INVULLEN
            s.setString(, p.getLastName());
            s.setString(, p.getEmail());
            s.setString(, p.getPassword());
            s.setInt(, p.getRole());
            int result = s.executeUpdate();
            if (result > 0)
                return true;
            else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private User getUserResults(ResultSet results) {
        User p = null;
        try {
            //p = new User();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    private User getTutorResults(ResultSet results) {
        User p = null;
        try {
           // p = new User();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public User getUserByEMail(String email) {
        User p = null;
        try (Connection c = getConn()) {
            PreparedStatement s = c.prepareStatement("");//invullen
            s.setString(,);//invullen
            ResultSet results = s.executeQuery();
            if (results.next()) {
                p = getUserResults(results);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean updateUser(int id, User p) {
        //String sql = "UPDATE USERS SET
               // " WHERE id = ?";

        try (Connection c = getConn()) {
            PreparedStatement s = c.prepareStatement("");
            s.setString(, p.getFirstName());
            s.setString(, p.getLastName());
            s.setString(, p.getEmail());
            s.setString(, p.getPassword());
            s.setInt(, p.getRole());
            s.setInt(, id);
            int result = s.executeUpdate();
            if (result > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUserById(int userId) {
        try (Connection conn = getConn()) {
            PreparedStatement s = conn.prepareStatement("DELETE from USERS where userid = ?"); // DB nog invullen;
            s.setInt(1, userId);
            int result = s.executeUpdate();
            if (result > 0)
                return true;
            else return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}