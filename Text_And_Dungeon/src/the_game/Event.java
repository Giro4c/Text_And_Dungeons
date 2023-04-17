package the_game;

import java.util.ArrayList;

public class Event {

	private int id;
	private boolean isTriggered;
	private ArrayList<Event> intermediaryEvents = new ArrayList<Event>();
	
	public boolean isTriggered() {
		return isTriggered;
	}

	public void setTriggered(boolean isTriggered) {
		this.isTriggered = isTriggered;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Event> getIntermediaryEvents() {
		return intermediaryEvents;
	}

	



	public Event(int id) {
		super();
		this.id = id;
		this.isTriggered = false;
	}
	
	public Event(int id, int numIntermediaryEvents) {
		super();
		this.id = id;
		this.isTriggered = false;
		for (int eventID = 1; eventID <= numIntermediaryEvents; ++eventID) {
			intermediaryEvents.add(new Event(eventID));
		}
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return this.id == event.id;
	}
	
	
	public void clear() {
		this.isTriggered = false;
		if (this.intermediaryEvents.size() > 0) {
			for (Event event : this.intermediaryEvents) {
				event.clear();
			}
		}
	}
	
	public boolean canBeTriggered() {
		if (this.intermediaryEvents.size() > 0) {
			for (Event event : intermediaryEvents) {
				if (event.isTriggered == false) return false;
			}
		}
		return true;
	}
	
	public void triggerNextIntermediaryEvent() {
		if (this.intermediaryEvents.size() > 0) {
			for (Event event : intermediaryEvents) {
				if (event.isTriggered == false) {
					event.setTriggered(true);
					break;
				}
			}
		}
	}
	
}
