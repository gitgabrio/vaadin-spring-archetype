#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import ${package}.server.dto.CustomerBean;
import ${package}.server.vaadin.event.CustomerLoginEvent;
import ${package}.server.vaadin.event.CustomerLogoutEvent;
import ${package}.server.vaadin.eventbus.EventBus;
import ${package}.server.vaadin.view.customer.CustomerScreen;
import ${package}.server.vaadin.view.login.LoginScreen;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


/**
 * The type <code>Main</code>.
 */
@Theme("mytheme")
@Widgetset("${package}.VaadinSpringModelWidgetset")
@SpringUI()
public class Main extends UI implements CustomerLoginEvent.CustomerLoginHandler, CustomerLogoutEvent.CustomerLogoutHandler {


    /**
     * The <code>EventBus</code> eventBus.
     */
    @Autowired
    private EventBus eventBus;


    /**
     * The LoginScreen.
     */
    @Autowired
    private LoginScreen loginScreen;

    /**
     * The CustomerScreen.
     */
    @Autowired
    private CustomerScreen customerScreen;

    /**
     * The <code>VerticalLayout</code> verticalLayout.
     */
    private final VerticalLayout verticalLayout = new VerticalLayout();

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        eventBus.addHandler(CustomerLoginEvent.class, this);
        eventBus.addHandler(CustomerLogoutEvent.class, this);
        loginScreen.setEventBus(eventBus);
        customerScreen.setEventBus(eventBus);
    }


    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLoginEvent event) {
        setCustomerScreen(event.getCustomer());
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLogoutEvent event) {
        setLoginScreen();
    }


    /**
     * Init.
     *
     * @param vaadinRequest the vaadin request
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("VaadinSpringModel");
        verticalLayout.setMargin(true);
        Label label = new Label("Vaadin Spring Model");
        verticalLayout.addComponent(label);
        setLoginScreen();
        setContent(verticalLayout);
    }


    /**
     * Sets login screen.
     */
    private void setLoginScreen() {
        verticalLayout.removeComponent(customerScreen);
        verticalLayout.addComponent(loginScreen);
    }

    /**
     * Sets customer screen.
     *
     * @param customer the customer
     */
    private void setCustomerScreen(CustomerBean customer) {
        verticalLayout.removeComponent(loginScreen);
        verticalLayout.addComponent(customerScreen);
        customerScreen.setCustomer(customer);
    }


}
