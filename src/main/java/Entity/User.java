package Entity;
import DB.UserDAO;

public class User {
    private int UserID;
    private String firstName;
    private String lastName;
    private String email;
    private int role;
    private String password;


    public User(int UserID, String firstName, String lastName, String email, int role, String password) {  //BIRTHDAY ? AND GENDER MAYBE ?
        this.UserID = UserID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserId) {
        this.UserID = UserID;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }

    //BIRTHDAY AND GENDRE MAYBE DEPENDINGONTIME
}