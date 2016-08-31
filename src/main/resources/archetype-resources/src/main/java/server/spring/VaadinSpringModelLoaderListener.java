#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.spring;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;


/**
 * The type <code>VaadinSpringModelLoaderListener</code>.
 */
@WebListener
public class VaadinSpringModelLoaderListener extends ContextLoaderListener {

    /**
     * Context initialized.
     *
     * @param event the event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
    }
}
