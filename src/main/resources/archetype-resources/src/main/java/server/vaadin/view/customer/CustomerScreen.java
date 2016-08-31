#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view.customer;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import ${package}.server.dto.CustomerBean;
import ${package}.server.service.AuthenticationService;
import ${package}.server.vaadin.event.CustomerLogoutEvent;
import ${package}.server.vaadin.view.AbstractScreen;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The type <code>CustomerScreen</code>.
 */
@UIScope
@SpringView(name = "CustomerScreen")
public class CustomerScreen extends AbstractScreen {

    /**
     * The <code>AuthenticationService</code> authenticationService.
     */
    private AuthenticationService authenticationService;

    /**
     * The User input.
     */
    private TextField firstName = new TextField();
    /**
     * The Password box.
     */
    private TextField lastName = new TextField();

    private Label popupLabel = new Label();

    private PopupView loginPopupView;

    /**
     * The <code>CustomerBean</code> customer.
     */
    private CustomerBean customer;




    /**
     * Instantiates a new <code>CustomerScreen</code>.
     *
     * @param authenticationService the <code>authenticationService</code> authentication service
     */
    @Autowired
    public CustomerScreen(AuthenticationService authenticationService)  {
        this.authenticationService = authenticationService;
        VerticalLayout firstNameLayout = new VerticalLayout();
        firstNameLayout.addComponent(new Label("First Name"));
        firstNameLayout.addComponent(firstName);
        addComponent(firstNameLayout);
        VerticalLayout lastNameLayout = new VerticalLayout();
        lastNameLayout.addComponent(new Label("Last Name"));
        lastNameLayout.addComponent(lastName);
        addComponent(lastNameLayout);
        addComponent(getLogoutButton());
        loginPopupView = getLoginPopupView();
        addComponent(loginPopupView);
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
        firstName.setValue(customer.getFirstName());
        lastName.setValue(customer.getLastName());
        popupLabel.setValue("Connection ID : " + customer.getConnectionId());
        loginPopupView.setPopupVisible(true);
    }

    /**
     * This view is navigated to.
     * <p/>
     * This method is always called before the view is shown on screen.
     * {@link ViewChangeEvent${symbol_pound}getParameters() event.getParameters()} may contain
     * extra parameters relevant to the view.
     *
     * @param event ViewChangeEvent representing the view change that is              occurring. {@link ViewChangeEvent${symbol_pound}getNewView()
     *              event.getNewView()} returns <code>this</code>.
     */
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    /**
     * Gets logout button.
     *
     * @return the logout button
     */
    private Button getLogoutButton() {
        Button toReturn = new Button("LOGOUT");
        toReturn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                authenticationService.logoutCustomer(customer);
                eventBus.fireEvent(new CustomerLogoutEvent());
            }
        });
        return toReturn;
    }

    /**
     * Gets login popup panel.
     *
     * @return the login popup panel
     */
    private PopupView getLoginPopupView() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(popupLabel);
        final PopupView toReturn = new PopupView(null, verticalLayout);
        Button button = new Button("Close");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                toReturn.setPopupVisible(false);
            }
        });
        verticalLayout.addComponent(button);
        return toReturn;
    }

}
