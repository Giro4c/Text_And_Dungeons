package the_game;

import java.util.ArrayList;

import the_game.create.Create;

public class Event {

	private static ArrayList<Event> currentEvents = startEvent();
	private static int voidAttackCount = 0;
	private static int SUM_ENEMIES = 0;
	
	private static int sumEnemiesDefeated = 0;
	
	private int id;
	private boolean alreadyTriggered;
	
	public Event(int id) {
		super();
		this.id = id;
		this.alreadyTriggered = false;
	}
	
	public Event(int id, boolean alreadyTriggered) {
		super();
		this.id = id;
		this.alreadyTriggered = alreadyTriggered;
	}

	
	public static int getSUM_ENEMIES() {
		return SUM_ENEMIES;
	}

	public static void setSUM_ENEMIES(int sUM_ENEMIES) {
		SUM_ENEMIES = sUM_ENEMIES;
	}

	
	public boolean isAlreadyTriggered() {
		return alreadyTriggered;
	}

	public void setAlreadyTriggered(boolean alreadyTriggered) {
		this.alreadyTriggered = alreadyTriggered;
	}

	public int getId() {
		return id;
	}

	public static int getSumEnemiesDefeated() {
		return sumEnemiesDefeated;
	}

	public static void setSumEnemiesDefeated(int sumEnemiesDefeated) {
		Event.sumEnemiesDefeated = sumEnemiesDefeated;
	}

	public static int getVoidAttackCount() {
		return voidAttackCount;
	}

	public static void setVoidAttackCount(int voidAttackCount) {
		Event.voidAttackCount = voidAttackCount;
	}

	public static ArrayList<Event> getCurrentEvents() {
		return currentEvents;
	}
	
	

	private static ArrayList<Event> startEvent() {
		ArrayList<Event> events = new ArrayList<Event>();
		events.add(new Event(0));
		
		return events;
	}
	
	public static void verifyIfEvent(Hero hero) throws InterruptedException {
		if (Create.getMapID() == 1) {
			if (currentEvents.indexOf(new Event(1)) == -1 && voidAttackCount > 0) {
				Message.voidAttack(hero);
				if (voidAttackCount == 6) {
					currentEvents.remove(new Event(0));
					currentEvents.add(new Event(1));
				}
			}
		}
		else if (Create.getMapID() == 2) {
			if (currentEvents.indexOf(new Event(2)) == -1 && hero.getX()==4 && hero.getY()==21) {
				currentEvents.add(new Event(2));
			}
		}
	}
	
	public static void triggerEvents(Hero hero, Boss[] bosses, Teleport[] teleports, int[] walls, Chest[] chests) {
		if (Create.getMapID() == 1) {
			for (Event event : currentEvents) {
				if (event.alreadyTriggered == false) {
					if (event.id == 1) {
						hero.setX(17);
						hero.setY(5);
						bosses[1].setX(16);
						bosses[1].setY(1);
					}
					event.alreadyTriggered = true;
				}
			}
		}
		else if (Create.getMapID() == 2) {
			for (Event event : currentEvents) {
				if (event.alreadyTriggered == false) {
					if (event.id == 2) {
						teleports[5].setxTerminal1(-1);
						teleports[5].setyTerminal1(-1);
					}
				}
			}
		}
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return this.id == event.id;
	}
	
}
