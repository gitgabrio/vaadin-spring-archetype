#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dto;

import java.io.Serializable;


/**
 * The type <code>CustomerBean</code>.
 */
public class CustomerBean implements Serializable {

    /**
     * The First name.
     */
    private String firstName;
    /**
     * The Last name.
     */
    private String lastName;

    /**
     * The <code>String</code> connectionId.
     */
    private String connectionId;

    /**
     * Gets connectionId.
     *
     * @return the connectionId
     */
    public String getConnectionId() {
        return connectionId;
    }

    /**
     * Sets connectionId.
     *
     * @param connectionId the connectionId
     */
    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
