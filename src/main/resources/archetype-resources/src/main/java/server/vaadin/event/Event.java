#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.vaadin.event;

import ${package}.server.vaadin.handler.Handler;

/**
 * Base Event object.
 *
 * @param <H> interface implemented by handlers of this kind of event
 */
public abstract class Event<H extends Handler> {


  /**
   * Instantiates a new <code>Event</code>.
   */
  protected Event() {
  }


  /**
   * This is a method used primarily for debugging. It gives a string
   * representation of the event details. This does not override the toString
   * method because the compiler cannot always optimize toString out correctly.
   * Event types should override as desired.
   *
   * @return a string representing the event's specifics.
   */
  public String toDebugString() {
    String name = this.getClass().getName();
    name = name.substring(name.lastIndexOf(".") + 1);
    return "event: " + name + ":";
  }

  /**
   * The toString() for abstract event is overridden to avoid accidently
   * including class literals in the compiled output. Use {@link Event}
   * ${symbol_pound}toDebugString to get more information about the event.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "An event type";
  }


  /**
   * Dispatch.
   *
   * @param handler the handler
   */
  public abstract void dispatch(H handler);


}