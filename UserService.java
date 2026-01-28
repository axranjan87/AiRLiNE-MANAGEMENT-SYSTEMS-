import java.util.HashMap;

/**
 * UserService Class
 * Manages all user-related operations (registration, login, etc.)
 * Uses HashMap to store users with userId as key
 */
public class UserService {
    private HashMap<String, User> users;
    private int userCounter;

    /**
     * Constructor to initialize UserService
     */
    public UserService() {
        this.users = new HashMap<>();
        this.userCounter = 1000;
        initializeSampleUsers();
    }

    /**
     * Initialize sample users for demonstration
     */
    private void initializeSampleUsers() {
        users.put("USER1001", new User("USER1001", "Ayush Ranjan", "ayushranjan8757@gmail.com", "Ayush8757", "8757491266"));
        users.put("USER1002", new User("USER1002", "Shruti Kumari", "ar6455476@gmail.com", "Shruti8757", "8757491266"));
        users.put("USER1003", new User("USER1003", "Shivam Kumar", "shivamkumar8757@gmail.com", "Shivam8757", "6204780287"));
        users.put("USER1004", new User("USER1004", "Vikram Mahaseth", "vikrammahaseth8757@gmail.com", "Vikram8757", "9006963252"));
        users.put("USER1005", new User("USER1005", "Raman Thakur", "ramanthakur8757@gmail.com", "Raman8757", "7780052514"));
    }

    /**
     * Register a new user
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @param phoneNumber User's phone number
     * @return true if registration successful, false otherwise
     */
    public boolean registerUser(String name, String email, String password, String phoneNumber) {
        // Validate input
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return false;
        }
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ Email cannot be empty!");
            return false;
        }
        if (password == null || password.length() < 6) {
            System.out.println("❌ Password must be at least 6 characters long!");
            return false;
        }
        if (phoneNumber == null || phoneNumber.length() != 10) {
            System.out.println("❌ Phone number must be 10 digits!");
            return false;
        }

        // Check if email already exists
        for (User user : users.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("❌ Email already registered!");
                return false;
            }
        }

        // Create new user
        userCounter++;
        String userId = "USER" + userCounter;
        User newUser = new User(userId, name, email, password, phoneNumber);
        users.put(userId, newUser);
        System.out.println("✓ Registration successful! Your User ID: " + userId);
        return true;
    }

    /**
     * Authenticate user login
     * @param email User's email
     * @param password User's password
     * @return User object if login successful, null otherwise
     */
    public User loginUser(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ Email cannot be empty!");
            return null;
        }
        if (password == null || password.isEmpty()) {
            System.out.println("❌ Password cannot be empty!");
            return null;
        }

        for (User user : users.values()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println("✓ Login successful!");
                return user;
            }
        }
        System.out.println("❌ Invalid email or password!");
        return null;
    }

    /**
     * Get user by ID
     * @param userId ID of user to retrieve
     * @return User object if found, null otherwise
     */
    public User getUserById(String userId) {
        return users.get(userId);
    }

    /**
     * Update user information
     * @param userId ID of user to update
     * @param updatedUser Updated user object
     * @return true if update successful
     */
    public boolean updateUser(String userId, User updatedUser) {
        if (!users.containsKey(userId)) {
            System.out.println("❌ User not found!");
            return false;
        }
        users.put(userId, updatedUser);
        System.out.println("✓ User updated successfully!");
        return true;
    }

    /**
     * Check if user exists by ID
     * @param userId ID to check
     * @return true if user exists
     */
    public boolean userExists(String userId) {
        return users.containsKey(userId);
    }

    /**
     * Get total number of users
     * @return total number of users
     */
    public int getTotalUsers() {
        return users.size();
    }
}
