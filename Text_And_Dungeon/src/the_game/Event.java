package the_game;

import java.util.ArrayList;

/**
 * A class which represents an event in the game.  
 * An event can have different steps of activation which are represented through a list of other events which 
 * we call <strong>Intermediary Events</strong> or <strong>IEs</strong> for short.
 * @author Camille Girodengo
 *
 */
public class Event {

	/* *******************************************************************************
	 *                                   STATIC
	 * ******************************************************************************* */
	
	private static final Event EVENT_VOID = initializeFinalEvent(1);
	private static final Event EVENT_CAVE_VISIBILITY = initializeFinalEvent(2);
	private static final Event EVENT_ALL_ENEMIES_DOWN = initializeFinalEvent(3);
	
	public static Event getEventVoid() {
		return EVENT_VOID;
	}

	public static Event getEventCaveVisibility() {
		return EVENT_CAVE_VISIBILITY;
	}

	public static Event getEventAllEnemiesDown() {
		return EVENT_ALL_ENEMIES_DOWN;
	}
	
	private static Event initializeFinalEvent(int id) {
		Event finalEvent = new Event(0);
		if (id == 1) {
			finalEvent = new Event(1, 5);
			finalEvent.intermediaryEvents.set(0, new Event(1, 2));
		}
		else if (id == 2) {
			finalEvent = new Event(1);
		}
		else if (id == 3) {
			finalEvent = new Event(2, 4);
		}
		return finalEvent;
	}
	
	/* *******************************************************************************
	 *                                   DYNAMIC
	 * ******************************************************************************* */
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */

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
	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */

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
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */

	@Override
	public String toString() {
		String eventStr = "Event: ID=" + this.id + ", ";
		if (this.isTriggered == true) {
			eventStr = eventStr + "is triggered.";
		}
		else {
			eventStr = eventStr + "has yet to be triggered.";
		}
		if (this.intermediaryEvents.size() != 0) {
			eventStr = eventStr + '\n' + "Intermediary Events :";
			for (Event event : this.intermediaryEvents) {
				eventStr = eventStr + '\n' + '\t' + "- " + event.toString();
			}
		}
		return eventStr;
	}
	
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        if (this.id == event.id && this.isTriggered == event.isTriggered) {
	        if (this.intermediaryEvents.size() == 0) {
	        	if (event.intermediaryEvents.size() == 0) return true;
	        }
	        else if (this.intermediaryEvents.size() == event.intermediaryEvents.size()){
	        	for (int indexIEvent = 0; indexIEvent < this.intermediaryEvents.size(); ++indexIEvent) {
	        		if (this.intermediaryEvents.get(indexIEvent).equals(event.intermediaryEvents.get(indexIEvent)) == false) return false;
	        	}
	        	return true;
	        }
        }
        return false;
	}
	
	/**
	 * Verify if the event has the same Intermediary Event structure as another Event
	 * @param event the Event with whom this event's structure will be compared with
	 * @return <code>true</code> if both events have the same IE structure, <code>false</code> if they don't.
	 */
	public boolean equalsStructure(Event event) {
		if (this.intermediaryEvents.size() == event.intermediaryEvents.size()){
			if (this.intermediaryEvents.size() == 0) return true;
			for (int indexIEvent = 0; indexIEvent < this.intermediaryEvents.size(); ++indexIEvent) {
        		if (this.intermediaryEvents.get(indexIEvent).equalsStructure(event.intermediaryEvents.get(indexIEvent)) == false) return false;
        	}
        	return true;
        }
		return false;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Set <code>isTriggered</code> variable to <code>false</code> for the event itself and the intermediary events it contains.
	 */
	public void clear() {
		this.isTriggered = false;
		if (this.intermediaryEvents.size() > 0) {
			for (Event event : this.intermediaryEvents) {
				event.clear();
			}
		}
	}
	
	/**
	 * Verify if the event meet the required conditions to be triggered.
	 * @return <code>true</code> if all IE are triggered, <code>false</code> if not.
	 */
	public boolean canBeTriggered() {
		if (this.intermediaryEvents.size() > 0) {
			for (Event event : intermediaryEvents) {
				if (event.isTriggered == false) return false;
			}
		}
		return true;
	}
	
	/**
	 * Set isTriggered attribute to true for the first IE not already triggered (isTriggered == false).
	 * If all IE are already triggered, nothing happens.
	 */
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
