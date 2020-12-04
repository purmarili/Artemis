package Calendar;

public class Event {
	protected int day;
	private String description;
	private String location;
	
	public Event(int day, String description, String location) {
		this.day = day;
		this.description = description;
		this.location = location;
	}
	
	public int diff(int day) {
		return getDay() - day;
	}

	public int getDay() {
		return day;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

}
