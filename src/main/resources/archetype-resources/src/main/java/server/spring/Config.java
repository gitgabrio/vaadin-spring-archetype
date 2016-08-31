#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.spring;

import com.vaadin.spring.annotation.EnableVaadin;
import ${package}.server.service.AuthenticationService;
import ${package}.server.vaadin.eventbus.EventBus;
import ${package}.server.vaadin.view.login.LoginView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * The type <code>Config</code>.
 */
@Configuration
@EnableVaadin
@PropertySource("classpath:application.properties")
public class Config {


    /**
     * This is needed for @Value configuration to work properly
     *
     * @return property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Gets authentication service.
     *
     * @return the authentication service
     */
    @Bean
    public AuthenticationService getAuthenticationService() {
        return new AuthenticationService();
    }

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    @Bean
    @Scope("prototype")
    public EventBus getEventBus() {
        return new EventBus();
    }

    /**
     * Gets login view.
     *
     * @return the login view
     */
    @Bean
    @Scope("prototype")
    public LoginView getLoginView() {
        return new LoginView(getAuthenticationService());
    }

}
