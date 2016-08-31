#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.event;


import ${package}.server.dto.CustomerBean;
import ${package}.server.vaadin.handler.Handler;


/**
 * The type <code>CustomerLoginEvent</code>.
 */
public class CustomerLoginEvent extends Event<CustomerLoginEvent.CustomerLoginHandler> {


    /**
     * The interface <code>CustomerLoginHandler</code>.
     */
    public interface CustomerLoginHandler extends Handler {
        /**
         * Manage event.
         *
         * @param event the event
         */
        void manageEvent(CustomerLoginEvent event);
    }

    /**
     * The Customer.
     */
    private CustomerBean customer;


    /**
     * Instantiates a new <code>CustomerLoginEvent</code>.
     *
     * @param customer the <code>customer</code> customer
     */
    public CustomerLoginEvent(CustomerBean customer) {
        this.customer = customer;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public CustomerBean getCustomer() {
        return customer;
    }


    /**
     * Dispatch.
     *
     * @param handler the handler
     */
    @Override
    public void dispatch(CustomerLoginHandler handler) {
        handler.manageEvent(this);
    }
}