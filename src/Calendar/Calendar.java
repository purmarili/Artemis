package Calendar;

public class Calendar {
    EventList head;

    public void addNewEvent(Event event) {
    	if(head == null)
    		head = new EventList(event);
    	else
    		head = head.add(event);
    }

    public Event[] eventsAt(int day) {
    	if(head == null)
    		return new Event[0];
    	
    	int count = 0;
    	for(EventList curr = head; curr != null; curr = curr.getNext()) {
    		if(curr.getEvent().diff(day) == 0)
    			count++;
    	}
    	
    	Event[] result = new Event[count];
    	int index = 0;
    	for(EventList curr = head; curr != null; curr = curr.getNext())
    		if(curr.getEvent().diff(day) == 0) {
    			result[index] = curr.getEvent();
    			index++;
    		}
    		
    	return result;
    }

    public Event nextEvent(int day) {
        return null;
    }

}
