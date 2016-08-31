#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view.login;


import com.vaadin.ui.*;
import ${package}.server.dto.CustomerBean;
import ${package}.server.service.AuthenticationService;
import ${package}.server.vaadin.event.CustomerLoginEvent;

/**
 * The type <code>LoginView</code>.
 */
public class LoginView extends AbstractLoginLayout {

    /**
     * The User input.
     */
    private TextField userInput = new TextField();
    /**
     * The Password box.
     */
    private PasswordField passwordInput = new PasswordField();


    /**
     * Instantiates a new <code>LoginView</code>.
     *
     * @param authenticationService the <code>AuthenticationService</code> authentication service
     */
    public LoginView(AuthenticationService authenticationService) {
        super(authenticationService);
        addComponent(new Label("UserName"));
        addComponent(userInput);
        addComponent(new Label("Password"));
        addComponent(passwordInput);
        addComponent(getLoginButton());
    }


    /**
     * Gets login button.
     *
     * @return the login button
     */
    private Button getLoginButton() {
        Button toReturn = new Button("LOGIN");
        toReturn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                CustomerBean customer = authenticationService.getCustomer(userInput.getValue(), passwordInput.getValue());
                if (customer != null) {
                    eventBus.fireEvent(new CustomerLoginEvent(customer));
                }
            }
        });
        return toReturn;
    }



}