#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.service;

import ${package}.server.dto.CustomerBean;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * The type <code>AuthenticationService</code>.
 */
@Service
public class AuthenticationService {

    /**
     * Gets customer.
     *
     * @param userName the user name
     * @param password the password
     * @return the customer
     */
    public CustomerBean getCustomer(String userName, String password) {
        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        CustomerBean toReturn = new CustomerBean();
        toReturn.setFirstName("Scrooge");
        toReturn.setLastName("McDuck");
        toReturn.setConnectionId(new Date().toString());
        return toReturn;
    }

    /**
     * Logout customer.
     *
     * @param customer the customer
     */
    public void logoutCustomer(CustomerBean customer) {

    }
}
