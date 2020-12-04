package Calendar;

public class InfiniteRepeatEvent extends Event {
	private int period;
	
	public InfiniteRepeatEvent(int day, String description, String location, int period) {
		super(day,description,location);
		this.period = period;
	}
	
	@Override
	public int diff(int day) {
		if(day < getDay())
			return super.diff(day);
		return (super.diff(day) % period + period) % period;
	}
	
	public int getPeriod() {
		return period;
	}
	
}
