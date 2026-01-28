/**
 * User Model Class
 * Represents a user/customer in the airline management system
 */
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    /**
     * Constructor to initialize a User object
     */
    public User(String userId, String name, String email, String password, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Display user information
     */
    @Override
    public String toString() {
        return "User ID: " + userId + 
               " | Name: " + name + 
               " | Email: " + email + 
               " | Phone: " + phoneNumber;
    }
}
