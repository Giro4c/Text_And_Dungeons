package the_game;

import java.util.ArrayList;
import the_game.create.Create;

public class EventManager {

	private int voidAttackCount;
	private int sumEnemiesDown;
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	public EventManager() {
		super();
		this.voidAttackCount = 0;
		this.sumEnemiesDown = 0;
		if (Create.getMapID() == 1) {
			eventList.add(new Event(1, 5));
			eventList.get(0).getIntermediaryEvents().set(0, new Event(1, 2));
		}
		else if (Create.getMapID() == 2) {
			eventList.add(new Event(1));
			eventList.add(new Event(2, 4));
		}
	}

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

	public void verifyIfEventAndTrigger(Hero hero, Boss[] bosses, Teleport[] teleports, Wall[] walls, Chest[] chests, Enemy[] enemies) throws InterruptedException {
		this.checkVariables(hero, bosses, teleports, walls, chests, enemies);
		if (Create.getMapID() == 1) {
			if (eventList.get(0).isTriggered() == false && voidAttackCount > 0) {
				Message.voidAttack(hero, voidAttackCount, eventList.get(0));
				if (eventList.get(0).canBeTriggered() == true) { // All IE have been triggered so the void Event has to be triggered
					eventList.get(0).setTriggered(true);
					triggerEvent(1, hero, bosses, teleports, walls, chests, enemies);
				}
			}
		}
		else if (Create.getMapID() == 2) {
			// Event 1 : Appearance (true) / Disappearance (false) of the hidden cave
			if (eventList.get(0).isTriggered() == false) {
				if (hero.getX()==4 && hero.getY()==21) {
					eventList.get(0).setTriggered(true);
					triggerEvent(1, hero, bosses, teleports, walls, chests, enemies);
				}
			}
			else if (hero.getX()==11 && hero.getY()==24) {
				eventList.get(0).setTriggered(false);
				triggerEvent(1, hero, bosses, teleports, walls, chests, enemies);
			}
			
			// Event 2 : Appearance of the hidden boss
			if (eventList.get(1).isTriggered() == false) {
				Message.WarningEnemiesDownCount(sumEnemiesDown, enemies, bosses, eventList.get(1));
				if (eventList.get(1).canBeTriggered() == true) { // All IE have been triggered so the void Event has to be triggered
					eventList.get(1).setTriggered(true);
					triggerEvent(2, hero, bosses, teleports, walls, chests, enemies);
				}
			}
			
		}
	}
	
	public boolean triggerEvent(int eventID, Hero hero, Boss[] bosses, Teleport[] teleports, Wall[] walls, Chest[] chests, Enemy[] enemies) throws InterruptedException {
		if (Create.getMapID() == 1) {
			if (eventID == 1) {
				hero.setX(17);
				hero.setY(5);
				bosses[1].setVisible(true);
				Message.voidEntry(hero, bosses[1]);
				
				return true;
			}
		}
		else if (Create.getMapID() == 2) {
			if (eventID == 1) { // Shows or hide the visible entities in the hidden cave on the middle left of the map
				
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
			
			if (eventID == 2) {
				bosses[0].setVisible(false);
				bosses[1].setVisible(true);
			}
		}
		return false;
	}
	
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
