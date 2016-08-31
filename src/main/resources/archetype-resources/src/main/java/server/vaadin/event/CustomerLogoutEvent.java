#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.event;


import ${package}.server.vaadin.handler.Handler;


/**
 * The type <code>CustomerLogoutEvent</code>.
 */
public class CustomerLogoutEvent extends Event<CustomerLogoutEvent.CustomerLogoutHandler> {


    /**
     * The interface <code>CustomerLogoutHandler</code>.
     */
    public interface CustomerLogoutHandler extends Handler {
        /**
         * Manage event.
         *
         * @param event the event
         */
        void manageEvent(CustomerLogoutEvent event);
    }


    /**
     * Instantiates a new <code>CustomerLogoutEvent</code>.
     */
    public CustomerLogoutEvent() {

    }

    /**
     * Dispatch.
     *
     * @param handler the handler
     */
    @Override
    public void dispatch(CustomerLogoutHandler handler) {
        handler.manageEvent(this);
    }
}