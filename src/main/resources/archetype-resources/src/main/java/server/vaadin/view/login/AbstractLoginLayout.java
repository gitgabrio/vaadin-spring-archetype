#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view.login;

import com.vaadin.ui.VerticalLayout;
import ${package}.server.service.AuthenticationService;
import ${package}.server.vaadin.eventbus.EventBus;


/**
 * The type <code>AbstractLoginLayout</code>.
 */
public abstract class AbstractLoginLayout extends VerticalLayout {

    /**
     * The <code>EventBus</code> eventBus.
     */
    protected EventBus eventBus;
    /**
     * The <code>AuthenticationService</code> authenticationService.
     */
    protected AuthenticationService authenticationService;


    /**
     * Instantiates a new <code>AbstractLoginLayout</code>.
     *
     * @param authenticationService the <code>AuthenticationService</code> authentication service
     */
    public AbstractLoginLayout(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    /**
     * Sets event bus.
     *
     * @param eventBus the event bus
     */
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
