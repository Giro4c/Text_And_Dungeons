package the_game;

import java.util.ArrayList;
import the_game.create.Create;

public class EventManager {

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public EventManager() {
		super();
		this.voidAttackCount = 0;
		this.sumEnemiesDown = 0;
		if (Create.getMapID() == 1) {
			eventList.add(Event.getEventVoid());
		}
		else if (Create.getMapID() == 2) {
			eventList.add(Event.getEventCaveVisibility());
			eventList.add(Event.getEventAllEnemiesDown());
		}
	}

	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int voidAttackCount;
	private int sumEnemiesDown;
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	
	public int getVoidAttackCount() {
		return voidAttackCount;
	}

	public void setVoidAttackCount(int voidAttackCount) {
		this.voidAttackCount = voidAttackCount;
	}

	public int getSumEnemiesDown() {
		return sumEnemiesDown;
	}

	public void setSumEnemiesDown(int sumEnemiesDown) {
		this.sumEnemiesDown = sumEnemiesDown;
	}

	public ArrayList<Event> getEventList() {
		return eventList;
	} 

	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Verify all events that could possibly be activated or deactivated and execute the necessary actions by checking the state of various variables.
	 * @param hero the playable character of the game
	 * @param bosses a Boss array which contains all the bosses of the current map
	 * @param teleports a Teleport array which contains all the teleports of the current map and their terminals
	 * @param walls a Wall array which contains all the walls of the current map
	 * @param chests a Chest array which contains all the chests of the current map
	 * @param enemies a Enemy array which contains all the enemies of the current map
	 * @throws InterruptedException
	 */
	public void verifyIfEventAndTrigger(Hero hero, Boss[] bosses, Teleport[] teleports, Wall[] walls, Chest[] chests, Enemy[] enemies) throws InterruptedException {
		this.checkVariables(hero, bosses, teleports, walls, chests, enemies);
		
		for (Event event : this.eventList) {
			if (event.getId() == Event.getEventVoid().getId()) { // Void Event
				if (event.isTriggered() == false && voidAttackCount > 0) {
					Message.voidAttack(hero, voidAttackCount, event);
					if (event.canBeTriggered() == true) { // All IE have been triggered so the void Event has to be triggered
						event.setTriggered(true);
						triggerEvent( Event.getEventVoid().getId(), hero, bosses, teleports, walls, chests, enemies);
					}
				}
			}
			else if (event.getId() == Event.getEventCaveVisibility().getId()) { // Appearance / Disappearance of a hidden cave
				if (Create.getMapID() == 2) {
					if (event.isTriggered() == false) {
						if (hero.getX()==4 && hero.getY()==21) {
							eventList.get(0).setTriggered(true);
							triggerEvent(Event.getEventCaveVisibility().getId(), hero, bosses, teleports, walls, chests, enemies);
						}
					}
					else if (hero.getX()==11 && hero.getY()==24) {
						eventList.get(0).setTriggered(false);
						triggerEvent(Event.getEventCaveVisibility().getId(), hero, bosses, teleports, walls, chests, enemies);
					}
				}
			}
			else if (event.getId() == Event.getEventAllEnemiesDown().getId()) { // Event related to the situation: "all enemies down"
				if (event.isTriggered() == false) {
					Message.WarningEnemiesDownCount(sumEnemiesDown, enemies, bosses, event);
					if (event.canBeTriggered() == true) { // All IE have been triggered so the hidden Event has to be triggered
						event.setTriggered(true);
						triggerEvent(Event.getEventAllEnemiesDown().getId(), hero, bosses, teleports, walls, chests, enemies);
					}
				}
			}
			
		}
		
	}
	
	/**
	 * The function dedicated to the instructions to execute when a specific event is triggered.
	 * @param eventID the ID of the main event that has been triggered
	 * @param hero the playable character of the game
	 * @param bosses a Boss array which contains all the bosses of the current map
	 * @param teleports a Teleport array which contains all the teleports of the current map and their terminals
	 * @param walls a Wall array which contains all the walls of the current map
	 * @param chests a Chest array which contains all the chests of the current map
	 * @param enemies a Enemy array which contains all the enemies of the current map
	 * @return Returns true if the event's ID is recognized by the function and all instructions have been executed. Returns false if the function doesn't recognize the ID.
	 * @throws InterruptedException
	 */
	public boolean triggerEvent(int eventID, Hero hero, Boss[] bosses, Teleport[] teleports, Wall[] walls, Chest[] chests, Enemy[] enemies) throws InterruptedException {
		if (eventID == Event.getEventVoid().getId()) {
			if (Create.getMapID() == 1) {
				hero.setX(17);
				hero.setY(5);
				bosses[1].setVisible(true);
				Message.voidEntry(hero, bosses[1]);
				
				return true;
			}
		}
		else if (eventID == Event.getEventCaveVisibility().getId()) {
			if (Create.getMapID() == 2) { // Shows or hide the visible entities in the hidden cave on the middle left of the map
				
				// Show/Hide teleport terminal
				teleports[5].getTerminal1().setVisible(!teleports[5].getTerminal1().isVisible());
				// Show/Hide chests
				chests[10].setVisible(!chests[10].isVisible());
				chests[11].setVisible(!chests[11].isVisible());
				// Show/Hide Enemies
				enemies[84].setVisible(!enemies[84].isVisible());
				enemies[85].setVisible(!enemies[85].isVisible());
				enemies[86].setVisible(!enemies[86].isVisible());
				// Show/Hide walls
				walls[86].setVisible(!walls[86].isVisible());
				walls[87].setVisible(!walls[87].isVisible());
				walls[88].setVisible(!walls[88].isVisible());
				walls[89].setVisible(!walls[89].isVisible());
				walls[90].setVisible(!walls[90].isVisible());
				walls[91].setVisible(!walls[91].isVisible());
				walls[92].setVisible(!walls[92].isVisible());
				walls[95].setVisible(!walls[95].isVisible());
				walls[96].setVisible(!walls[96].isVisible());
				walls[97].setVisible(!walls[97].isVisible());
				walls[98].setVisible(!walls[98].isVisible());
				walls[99].setVisible(!walls[99].isVisible());
				walls[103].setVisible(!walls[103].isVisible());
				walls[104].setVisible(!walls[104].isVisible());
				walls[108].setVisible(!walls[108].isVisible());
				walls[109].setVisible(!walls[109].isVisible());
				walls[110].setVisible(!walls[110].isVisible());
				walls[111].setVisible(!walls[111].isVisible());
				walls[112].setVisible(!walls[112].isVisible());
				walls[113].setVisible(!walls[113].isVisible());
				walls[114].setVisible(!walls[114].isVisible());
				walls[119].setVisible(!walls[119].isVisible());
				walls[120].setVisible(!walls[120].isVisible());
				walls[121].setVisible(!walls[121].isVisible());
				walls[122].setVisible(!walls[122].isVisible());
				walls[123].setVisible(!walls[123].isVisible());
				
				return true;
			}
			
		}
		else if (eventID == Event.getEventAllEnemiesDown().getId()) {
			if (Create.getMapID() == 2) {
				bosses[0].setVisible(false);
				bosses[1].setVisible(true);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A procedure to update event related variables such as voidAttackCout and sumEnemiesDown. The updates depend on the last valid command typed by the player and the map currently played.
	 * @param hero the playable character of the game
	 * @param bosses a Boss array which contains all the bosses of the current map
	 * @param teleports a Teleport array which contains all the teleports of the current map and their terminals
	 * @param walls a Wall array which contains all the walls of the current map
	 * @param chests a Chest array which contains all the chests of the current map
	 * @param enemies a Enemy array which contains all the enemies of the current map
	 */
	private void checkVariables(Hero hero, Boss[] bosses, Teleport[] teleports, Wall[] walls, Chest[] chests, Enemy[] enemies) {
		if (Create.getMapID() == 1) {
			if (Test.lastValidCommand == null || Test.lastValidCommand.length == 0) {
				this.voidAttackCount = 0;
				this.eventList.get(0).clear();
			}
			else if (hero.getX() == 1 && hero.getY() == 15 && Test.lastValidCommand[0].equals("attack")) {
				++this.voidAttackCount;
			}
			else {
				this.voidAttackCount = 0;
				this.eventList.get(0).clear();
			}
		}
		
		if (Create.getMapID() == 2) {
			if (Test.lastValidCommand != null && Test.lastValidCommand.length > 1) {
				for (Enemy enemy : enemies) {
					if (enemy != null && enemy.getName().toLowerCase().equals(Test.lastValidCommand[1])
							&& (enemy.getType().equals("Opposing Warrior") || enemy.getType().equals("Monster"))
							&& enemy.getHP() <= 0) {
						++this.sumEnemiesDown;
						break;
					}
				}
						
			}
		}
	}
	
}
