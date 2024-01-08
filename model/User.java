package gr.aueb.cf.OOProjects.model;

/**
 * Defines a login {@link User}.
 * It includes {@link #id}, {@link #firstname}
 * and {@link #lastname} with mutator methods:
 * {@link #setId(long)}
 * {@link #setFirstname(String)}
 * {@link #setLastname(String)}.
 *
 * @since 0.1
 * @version 1.0
 * @author RenaMigdali
 */
public class User {
    private long id;
    private String firstname;
    private String lastname;


    /**
     * Default constructor.
     * Initializes a new {@link User}
     * with default values.
     */
    public User() {
    }


    /**
     * Overloaded constructor.
     * Initializes a new {@link User}
     * with specific values.
     *
     * @param id            the user's id.
     * @param firstname     the user's firstname.
     * @param lastname      the user's lastname.
     */
    public User(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    /**
     * Gets the {@link User} id.
     *
     * @return  the user's id.
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the {@link User} id.
     *
     * @param id    the user's id.
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the {@link User} firstname.
     *
     * @return      the user's firstname.
     */
    public String getFirstname() {
        return firstname;
    }


    /**
     * Sets the {@link User} firstname.
     *
     * @param firstname     the user's firstname.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    /**
     * Gets the {@link User} lastname.
     *
     * @return      the user's lastname.
     */
    public String getLastname() {
        return lastname;
    }


    /**
     * Sets the {@link User} lastname.
     *
     * @param lastname      the user's lastname.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
