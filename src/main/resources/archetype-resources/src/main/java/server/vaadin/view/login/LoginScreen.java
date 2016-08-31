#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view.login;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import ${package}.server.vaadin.eventbus.EventBus;
import ${package}.server.vaadin.view.AbstractScreen;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type <code>LoginScreen</code>.
 */
@UIScope
@SpringView(name = "LoginScreen")
public class LoginScreen extends AbstractScreen {

    /**
     * The <code>LoginView</code> loginView.
     */
    private LoginView loginView;

    /**
     * Instantiates a new <code>LoginScreen</code>.
     *
     * @param loginView the <code>LoginView</code> login view
     */
    @Autowired
    public LoginScreen(LoginView loginView)  {
        this.loginView = loginView;
        addComponent(loginView);
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
     * Sets event bus.
     *
     * @param eventBus the event bus
     */
    @Override
    public void setEventBus(EventBus eventBus) {
        super.setEventBus(eventBus);
        loginView.setEventBus(eventBus);
    }
}
