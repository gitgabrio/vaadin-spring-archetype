#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.eventbus;

import ${package}.server.vaadin.event.Event;
import ${package}.server.vaadin.handler.Handler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type <code>EventBus</code>.
 */
public class EventBus {

    /**
     * The <code>Map<Class, Set<AbstractHandler>></code> handlersMap.
     */
    private Map<Class, Set<Handler>> handlersMap = new HashMap<>();


    /**
     * Add handler.
     *
     * @param handler the handler
     */
    public void addHandler(Class eventType, Handler handler) {
        if (handlersMap.containsKey(eventType)) {
            handlersMap.get(eventType).add(handler);
        } else {
            Set<Handler> handlersSet = new HashSet<>();
            handlersSet.add(handler);
            handlersMap.put(eventType, handlersSet);
        }
    }

    /**
     * Remove handler.
     *
     * @param handler the handler
     */
    public void removeHandler(Class eventType, Handler handler) {
        if (handlersMap.containsKey(eventType)) {
            handlersMap.get(eventType).remove(handler);
        }
    }

    /**
     * Fire event.
     *
     * @param toFire the to fire
     */
    public void fireEvent(Event toFire) {
        Class eventType = toFire.getClass();
        if (handlersMap.containsKey(eventType)) {
            Set<Handler> handlers = handlersMap.get(eventType);
            for (Handler handler : handlers) {
                toFire.dispatch(handler);
            }
        }
    }

}