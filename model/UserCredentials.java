package gr.aueb.cf.OOProjects.model;

/**
 * Defines a JavaBean class for login user's credentials.
 */
public class UserCredentials {
    private long id;
    private String username;
    private String password;


    /**
     * Default constructor.
     * Initializes an instance of {@link UserCredentials}
     * with default values.
     */
    public UserCredentials() {
    }


    /**
     * Overloaded constructor.
     * Initializes an instance of {@link UserCredentials}
     * with specific values.
     *
     * @param id            the user's id.
     * @param username      the user's username.
     * @param password      the user's password.
     */
    public UserCredentials(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
