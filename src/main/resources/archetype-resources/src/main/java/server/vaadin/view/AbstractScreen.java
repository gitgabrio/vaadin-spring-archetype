#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import ${package}.server.vaadin.eventbus.EventBus;


/**
 * The type <code>AbstractScreen</code>.
 */
public abstract class AbstractScreen extends HorizontalLayout implements View {

    /**
     * The <code>EventBus</code> eventBus.
     */
    protected EventBus eventBus;

    /**
     * Sets event bus.
     *
     * @param eventBus the event bus
     */
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

}
