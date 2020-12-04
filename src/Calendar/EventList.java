package Calendar;

public class EventList {
	private Event event;
	private EventList next;
	
	public EventList(Event event) {
		this.event = event;
		this.next = null;
	}
	
	public EventList add(Event event) {
		EventList newElement = new EventList(event);
		newElement.next = this;
		return newElement;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public EventList getNext() {
		return next;
	}
	
}
