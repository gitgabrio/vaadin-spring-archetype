#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.servlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.spring.server.SpringVaadinServlet;
import ${package}.server.vaadin.view.Main;

import javax.servlet.annotation.WebServlet;


/**
 * The type <code>VaadinSpringModelServlet</code>.
 */
@WebServlet(urlPatterns = "/*", name = "VaadinSpringModelServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = Main.class, productionMode = false)
public class VaadinSpringModelServlet extends SpringVaadinServlet {

}
