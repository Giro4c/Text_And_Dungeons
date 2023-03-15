package the_game.Deprecated_classes;

import the_game.Boss;
import the_game.Chest;
import the_game.Enemy;
import the_game.Entity;
import the_game.Hero;
import the_game.Message;

/**
 * A class which regroup all the possible actions in the game. Includes actions outside and during a fight.
 * @author Camille Girodengo
 * @deprecated Replaced by package action
 */
public class Action {

	/**
	 * Finds if a String equals another String in array of String
	 * @param arrayStr the String array in which a String must be found
	 * @param strToFind the String to find in an array
	 * @return true if the String is in the array
	 */
	public static boolean isInStringArray(String[] arrayStr, String strToFind) {
		for (String str : arrayStr) {
			if (str != null && str.equals(strToFind)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Finds the index of the searched entity based on its name.<br>
	 * Considers that each entity's name is unique (no entity have the same name)</p>
	 * @param entities the array of Entity to search in
	 * @param nameEntityToFind the entity name to find
	 * @return the index of the first entity whose name is the String in the parameters
	 */
	public static int findIndexEntity(Entity[] entities, String nameEntityToFind) {
		for (int i = 0; i < entities.length; ++i) {
			if (nameEntityToFind.equals(entities[i].getName())) {
				return i;
			}
		}
		return entities.length;
	}

	
	
/* -------------------------------------------------------------------- *
 * -------------------------PASSIVE ACTIONS---------------------------- *
 * -------------------------------------------------------------------- */
	
	/**
	 * Create the String array containing all possible actions available when not in a fight.
	 * @param variablePActions a String array that contains all actions that are not final (like move actions and chest opening actions)
	 * @return a String array containing all the available actions outside a fight
	 * @see #evaluateAvailablePassiveActions(Hero, int[][], Chest[], String[]) for changing passive actions
	 */
	public static String[] passiveActions(String[] variablePActions) {
		int countOtherPA = 0;
		for (String str : variablePActions) {
			if (str != null) {
				++countOtherPA;
			}
		}
		String[] actions = new String[14 + countOtherPA];
		actions[0] = "Inventory";
		actions[1] = "Hero Info";
		actions[2] = "Show Map";
		actions[3] = "Show Weapon";
		actions[4] = "Show Artifact";
		actions[5] = "Show Potion";
		actions[6] = "Throw Weapon";
		actions[7] = "Throw Artifact";
		actions[8] = "Throw Potion";
		actions[9] = "Equip Weapon";
		actions[10] = "Equip Artifact";
		actions[11] = "Unequip Weapon";
		actions[12] = "Unequip Artifact";
		actions[13] = "Use Potion";
		for (int i = 0, count = 1; i < variablePActions.length; ++i) {
			if (variablePActions[i] != null) {
				actions[13 + count] = variablePActions[i];
				++count;
			}
		}
		return actions;
	}
	
	/**
	 * Create a String array that contains all the actions that might not be available to the player depending on their surroundings
	 * @return a String array, the content never changes
	 */
	public static String[] notFinalPassiveActions() {
		String[] passiveActions = new String[8];
		passiveActions[0] = "Move Up";
		passiveActions[1] = "Move Down";
		passiveActions[2] = "Move Right";
		passiveActions[3] = "Move Left";
		passiveActions[4] = "Open Top Chest";
		passiveActions[5] = "Open Bottom Chest";
		passiveActions[6] = "Open Left Chest";
		passiveActions[7] = "Open Right Chest";
		
		return passiveActions;
	}
	
	/**
	 * Evaluate which passive actions are available depending on the hero's immediate surroundings
	 * @param hero the hero whose surroundings are checked
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array, mostly used to know where all the chests are in this case
	 * @param passiveActions a String array which contains all possibly changing passive actions
	 * @return a String array which contains all available changing passive actions
	 */
	public static String[] evaluateAvailablePassiveActions(Hero hero, int[][] walls, Chest[] chests, String[] passiveActions) {
		String[] newPActions = passiveActions;
		String[] elemNearby = hero.verifySuroundings(walls, chests);
		// Verify if there is wall
		if (elemNearby[0] == "Wall") { // Up
			newPActions[0] = null;
			newPActions[4] = null;
		}
		if (elemNearby[1] == "Wall") { // Right
			newPActions[2] = null;
			newPActions[7] = null;
		}
		if (elemNearby[2] == "Wall") { // Down
			newPActions[1] = null;
			newPActions[5] = null;
		}
		if (elemNearby[3] == "Wall") { // Left
			newPActions[3] = null;
			newPActions[6] = null;
		}
		// Verify if there is Chest
		if (elemNearby[0] != "Chest") { // Up
			newPActions[4] = null;
		}
		else {
			newPActions[0] = null;
		}
		if (elemNearby[1] != "Chest") { // Right
			newPActions[7] = null;
		}
		else {
			newPActions[2] = null;
		}
		if (elemNearby[2] != "Chest") { // Down
			newPActions[5] = null;
		}
		else {
			newPActions[1] = null;
		}
		if (elemNearby[3] != "Chest") { // Left
			newPActions[6] = null;
		}
		else {
			newPActions[3] = null;
		}
		
		return newPActions;
	}
	
	/**
	 * Determines which action to execute outside of a fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param hero the character controlled by the player
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array containing the informations on all the chest on the map
	 * @param enemies a Enemy array containing all hostile living entities that can be attacked by the hero outside of bosses. <strong>Used here for the "Show Map" action only.</strong>
	 * @param bosses a Boss array containing all hostile bosses entities that can be attacked by the hero. <em>Include known and hidden bosses.</em> <strong>Used here for the "Show Map" action only.</strong>
	 * @throws InterruptedException
	 */
	public static void executePassiveCommand(String[] command, Hero hero, int[][] walls, Chest[] chests, Enemy[] enemies, Boss[] bosses) throws InterruptedException {
		
		if (command[0].equals("inventory")) {
			Message.showInventory(hero);
		}
		
		
		else if (command[0].equals("hero") && command.length > 1 && command[1].equals("info")) {
			Message.showHero(hero);
		}
		
		
		else if (command[0].equals("move")) {
			if (command.length > 1) {
				if (command[1].equals("up") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Move Up") == true) {
					hero.move('z');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("down") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Move Down") == true) {
					hero.move('s');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("right") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Move Right") == true) {
					hero.move('d');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("left") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Move Left") == true) {
					hero.move('q');
					hero.setSpecialActionCount(0);
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Direction");
			}
		}
		
		
		else if (command[0].equals("open")) {
			if (command.length > 1) {
				if (command[1].equals("top") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Open Top Chest") == true) {
					hero.openChest('z', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("bottom") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Open Bottom Chest") == true) {
					hero.openChest('s', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("right") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Open Right Chest") == true) {
					hero.openChest('d', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("left") && isInStringArray(evaluateAvailablePassiveActions(hero, walls, chests, notFinalPassiveActions()), "Open Left Chest") == true) {
					hero.openChest('q', chests);
					hero.setSpecialActionCount(0);
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Entity type");
			}
		}
		
		
		else if (command[0].equals("show")) {
			if (command.length > 1) {
				if (command[1].equals("map")) {
					Message.showMap(Create.createMap(walls, chests, enemies, bosses, hero));
				}
				else if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							Message.showItem(hero.getInventory().getWeapons()[numWeapon - 1]);
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							Message.showItem(hero.getInventory().getArtifacts()[numArtifact - 1]);
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else if (command[1].equals("potion")) { // For potions
					if (command.length < 3) {
						Message.notSpecified("Potion");
					}
					else {
						int numPotion = Integer.parseInt(command[2]);
						if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
							Message.showItem(hero.getInventory().getPotions()[numPotion - 1]);
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (command[0].equals("throw")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							hero.throwWeapon(numWeapon - 1);
							hero.setSpecialActionCount(0);
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							hero.throwArtifact(numArtifact - 1);
							hero.setSpecialActionCount(0);
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else if (command[1].equals("potion")) { // For potions
					if (command.length < 3) {
						Message.notSpecified("Potion");
					}
					else {
						int numPotion = Integer.parseInt(command[2]);
						if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
							hero.throwPotion(numPotion - 1);
							hero.setSpecialActionCount(0);
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (command[0].equals("equip")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							hero.equipWeapon(hero.getInventory().getWeapons()[numWeapon - 1]);
							hero.setSpecialActionCount(0);
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							hero.equipArtifact(hero.getInventory().getArtifacts()[numArtifact - 1]);
							hero.setSpecialActionCount(0);
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		else if (command[0].equals("unequip")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					hero.unEquipWeapon();
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("artifact")) { // For artifacts
					hero.unEquipArtifact();
					hero.setSpecialActionCount(0);
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		else if (command[0].equals("use") && command.length > 1 && command[1].equals("potion")) {
			if (command.length < 3) {
				Message.notSpecified("Potion");
			}
			else {
				int numPotion = Integer.parseInt(command[2]);
				if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
					hero.usePotion(hero.getInventory().getPotions()[numPotion - 1]);
					hero.setSpecialActionCount(0);
				}
				else {
					Message.notExists("Potion");
				}
			}
		}
		
		
		else if (command[0].equals("attack") && hero.getX() == 1 && hero.getY() == 15) {
			hero.setSpecialActionCount(hero.getSpecialActionCount() + 1);
			Message.specialAttack(hero);
		}
		
		
		else {
			Message.notRecognized();
		}
	}
	
	/**
	 * Check if the hero is at a special location and modify bosses information depending on this information. Can be altered to include an Enemy and Chest array in the parameters if needed.
	 * @param hero the character controlled by the player
	 * @param bosses a Boss array containing all bosses entities and their informations including location, stats, name, title, etc... <em>Include known and hidden bosses.</em>
	 */
	public static void checkHeroLocation(Hero hero, Boss[] bosses) {
		if (hero.getSpecialLocation() == 1 ) {
			bosses[1].setX(16);
			bosses[1].setY(1);
		}
	}
	
	
	
/* -------------------------------------------------------------------- *
 * ---------------------------FIGHT ACTIONS---------------------------- *
 * -------------------------------------------------------------------- */
	
	/**
	 * Create a String array containing all available fight actions including those that changes depending on the name of the enemy. 
	 * @param enemiesNames the names of all the enemies right next to the hero
	 * @return a String array with all available fight actions
	 */
	public static String[] fightActions(String[] enemiesNames) {
		int countEnemies = 0;
		for (String enemyName : enemiesNames) {
			if (enemyName != null) {
				++countEnemies;
			}
		}
		String[] actions = new String[11 + countEnemies*2];
		actions[0] = "Inventory";
		actions[1] = "Hero Info";
		actions[2] = "Show Map";
		actions[3] = "Show Weapon";
		actions[4] = "Show Artifact";
		actions[5] = "Show Potion";
		actions[6] = "Equip Weapon";
		actions[7] = "Equip Artifact";
		actions[8] = "Unequip Weapon";
		actions[9] = "Unequip Artifact";
		actions[10] = "Use Potion";
		for (int i = 0, count = 1; i < enemiesNames.length; ++i) {
			if (enemiesNames[i] != null) {
				actions[10 + count] = "Attack " + enemiesNames[i];
				++count;
				actions[10 + count] = "Check " + enemiesNames[i];
				++count;
			}
		}
		return actions;
	}
	
	/**
	 * Determines which action to execute during a fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param hero the character controlled by the player
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array containing the informations on all the chest on the map. <strong>Used here for the "Show Map" action only.</strong>
	 * @param enemies a Enemy array containing all hostile living entities that can be attacked by the hero outside of bosses. 
	 * @param bosses a Boss array containing all hostile bosses entities that can be attacked by the hero. <em>Include known and hidden bosses.</em>
	 * @return Whether or not it still is the hero's turn or not
	 */
	public static boolean executeFightCommand(String[] command, Hero hero, int[][] walls, Chest[] chests, Enemy[] enemies, Boss[] bosses) {
		
		if (command[0].equals("inventory")) {
			Message.showInventory(hero);
		}
		
		
		else if (command[0].equals("hero") && command.length > 1 && command[1].equals("info")) {
			Message.showHero(hero);
		}
		
		
		else if (command[0].equals("use") && command.length > 1 && command[1].equals("potion")) {
			if (command.length < 3) {
				Message.notSpecified("Potion");
			}
			else {
				int numPotion = Integer.parseInt(command[2]);
				if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
					hero.usePotion(hero.getInventory().getPotions()[numPotion - 1]);
					return false;
				}
				else {
					Message.notExists("Potion");
				}
			}
		}
		
		
		else if (command[0].equals("attack")) {
			
			if (command.length > 1) {
				if (command.length > 2) { // If the name is composed of more than one word, reassemble the name in one String
					for (int i = 2; i < command.length; ++i) {
						command[1] = command[1] + " " + command[i];
					}
				}
				for (String enemyName : hero.whoIsAround(enemies, bosses)) {
					if (enemyName != null && enemyName.toLowerCase().equals(command[1])) {
						if (Action.findIndexEntity(enemies, enemyName) != enemies.length) {
							hero.attack(enemies[Action.findIndexEntity(enemies, enemyName)]);
							return false;
						}
						else if (Action.findIndexEntity(bosses, enemyName) != bosses.length) {
							hero.attack(bosses[Action.findIndexEntity(bosses, enemyName)]);
							return false;
						}
						else {
							Message.notValid("Enemy Name Input");
						}
					}
				}
			}
			else {
				Message.notSpecified("Enemy");
			}
		}
		
		
		else if (command[0].equals("check")) {
			
			if (command.length > 1) {
				if (command.length > 2) { // If the name is composed of more than one word, reassemble the name in one String
					for (int i = 2; i < command.length; ++i) {
						command[1] = command[1] + " " + command[i];
					}
				}
				for (String enemyName : hero.whoIsAround(enemies, bosses)) {
					if (enemyName != null && enemyName.toLowerCase().equals(command[1])) {
						if (Action.findIndexEntity(enemies, enemyName) != enemies.length) {
							Message.checkEnemy(enemies[Action.findIndexEntity(enemies, enemyName)]);
							break;
						}
						else if (Action.findIndexEntity(bosses, enemyName) != bosses.length) {
							Message.showBoss(bosses[Action.findIndexEntity(bosses, enemyName)]);
							break;
						}
						else {
							Message.notValid("Enemy Name Input");
						}
					}
				}
			}
			else {
				Message.notSpecified("Enemy");
			}
		}
		
		
		else if (command[0].equals("show")) {
			if (command.length > 1) {
				if (command[1].equals("map")) { // For map
					Message.showMap(Create.createMap(walls, chests, enemies, bosses, hero));
				}
				else if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							Message.showItem(hero.getInventory().getWeapons()[numWeapon - 1]);
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							Message.showItem(hero.getInventory().getArtifacts()[numArtifact - 1]);
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else if (command[1].equals("potion")) { // For potions
					if (command.length < 3) {
						Message.notSpecified("Potion");
					}
					else {
						int numPotion = Integer.parseInt(command[2]);
						if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
							Message.showItem(hero.getInventory().getPotions()[numPotion - 1]);
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (command[0].equals("equip")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							hero.equipWeapon(hero.getInventory().getWeapons()[numWeapon - 1]);
							return false;
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							hero.equipArtifact(hero.getInventory().getArtifacts()[numArtifact - 1]);
							return false;
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (command[0].equals("unequip")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (hero.getCurrentWeapon() != null) {
						hero.unEquipWeapon();
						return false;
					}
					else {
						Message.notExists("Selected current Weapon");
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (hero.getCurrentArtifact() != null) {
						hero.unEquipArtifact();
						return false;
					}
					else {
						Message.notExists("Selected current Weapon");
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else {
			Message.notRecognized();
		}
		
		return true;
	}
	
	/**
	 * Determines the maximum speed of the enemies around the hero
	 * @param enemiesNames the names of the enemies or bosses around the hero
	 * @param enemies an Enemy array of all the hostile entities of the map outside of bosses
	 * @param bosses a Boss array of all the bosses of the map
	 * @return the maximum speed of the enemies around the hero
	 */
	public static int maxSpeedEnemies(String[] enemiesNames, Enemy[] enemies, Boss[] bosses) {
		int maxSpeed = 0;
		for (String enemyName : enemiesNames) {
			if (enemyName != null) {
				if (Action.findIndexEntity(enemies, enemyName) != enemies.length) {
					maxSpeed = Math.max(maxSpeed, enemies[Action.findIndexEntity(enemies, enemyName)].getSpeed());
				}
				else if (Action.findIndexEntity(bosses, enemyName) != bosses.length) {
					maxSpeed = Math.max(maxSpeed, bosses[Action.findIndexEntity(bosses, enemyName)].getSpeed());
				}
			}
		}
		return maxSpeed;
	}
	
	/**
	 * A void to make all enemies in the hero's surrounding whose speed is in the interval <code>[minSpeed, maxSpeed]</code> attack.
	 * @param hero the character controlled by the player. Is the target of all attacks.
	 * @param enemies a Enemy array of all hostile entities outside of bosses that can attack the hero.
	 * @param bosses a Boss array of all hostile bosses that can attack the hero.
	 * @param minSpeed the minimum speed for an hostile entity to have to attack
	 * @param maxSpeed the maximum speed for an hostile entity to have to attack
	 */
	public static void enemiesAttack(Hero hero, Enemy[] enemies, Boss[] bosses, int minSpeed, int maxSpeed) {
		for (String enemyName : hero.whoIsAround(enemies, bosses)) {
			if (enemyName != null) {
				if (Action.findIndexEntity(enemies, enemyName) != enemies.length && enemies[Action.findIndexEntity(enemies, enemyName)].getSpeed() >= minSpeed && enemies[Action.findIndexEntity(enemies, enemyName)].getSpeed() <= maxSpeed) {
					enemies[Action.findIndexEntity(enemies, enemyName)].attack(hero);
				}
				else if (Action.findIndexEntity(bosses, enemyName) != bosses.length && bosses[Action.findIndexEntity(bosses, enemyName)].getSpeed() >= minSpeed && bosses[Action.findIndexEntity(bosses, enemyName)].getSpeed() <= maxSpeed) {
					bosses[Action.findIndexEntity(bosses, enemyName)].attack(hero);
				}
			}
		}
	}
	
	/**
	 * Verify if a known boss has been defeated or not
	 * @param boss the boss whose defeat must be confirmed
	 * @return a boolean. Returns true if the boss is down, false if the boss is still alive.
	 */
	public static boolean isBossDown(Boss boss) {
		if (boss.getHP() <= 0) {
			return true;
		}
		
		return false;
	}
	
	
	
/* -------------------------------------------------------------------- *
 * --------------------------SPECIAL ACTIONS--------------------------- *
 * -------------------------------------------------------------------- */
	
	/**
	 * The complete fight void of the fight between the hero and a special boss (Here the VOID boss fight). The name of the void can be changed if another special boss fight is made for a new boss.
	 * @param hero the character controlled by the player
	 * @param boss the special boss the hero is currently facing
	 * @throws InterruptedException
	 */
	public static void specialBossFight(Hero hero, Boss boss) throws InterruptedException {
		boolean isHeroTurn = false;
		int phase = 1;
		Message.specialBossFightEntryPhase1(hero, boss);
		while (true) {
			if (boss.getSpeed() > hero.getSpeed()) {
				boss.attack(hero);
				if (hero.getHP() <= 0) {
					break;
				}
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(Action.specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = Action.executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (Action.isBossDown(boss) == true) {
					initializePhase2(boss);
					phase = 2;
					break;
				}
			}
			else {
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(Action.specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = Action.executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (Action.isBossDown(boss) == true) {
					initializePhase2(boss);
					phase = 2;
					break;
				}
				boss.attack(hero);
				if (hero.getHP() <= 0) {
					break;
				}
			}
		}
		while (hero.getHP() > 0) {
			if (boss.getSpeed() > hero.getSpeed()) {
				boss.attack(hero);
				if (hero.getHP() <= 0) {
					break;
				}
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(Action.specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = Action.executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (Action.isBossDown(boss) == true) {
					break;
				}
			}
			else {
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(Action.specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = Action.executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (Action.isBossDown(boss) == true) {
					break;
				}
				boss.attack(hero);
				if (hero.getHP() <= 0) {
					break;
				}
			}
		}
		if (Action.isBossDown(boss) == true) {
			Message.bossDefeated(boss);
		}
		
	}
	
	/**
	 * Changes the stats of the special boss after the initialization of the second phase of the boss fight and call the Message void associated to it.
	 * @param boss the special boss whose stats are to change
	 * @throws InterruptedException 
	 */
	public static void initializePhase2(Boss boss) throws InterruptedException {
		boss.setHP(300);
		boss.setAtk(50);
		boss.setDef(30);
		boss.setSpeed(35);
		Message.specialBossFightEntryPhase2(boss);
	}
	
	/**
	 * Create a String array containing all available fight actions during the special boss fight depending on the boss type and the phase
	 * @param boss the special boss the hero is facing
	 * @param phase the current phase of the boss fight
	 * @return a String array containing all available special boss fight actions
	 */
	public static String[] specialFightActions(Boss boss, int phase) {
		String[] actions;
		if (phase == 1) {
			actions = new String[11];
			actions[10] = "Invoke anti-void";
		}
		else {
			actions = new String[10];
		}
		actions[0] = "Inventory";
		actions[1] = "Hero Info";
		actions[2] = "Show Weapon";
		actions[3] = "Show Artifact";
		actions[4] = "Show Potion";
		actions[5] = "Equip Weapon";
		actions[6] = "Equip Artifact";
		actions[7] = "Use Potion";
		actions[8] = "Attack " + boss.getType();
		actions[9] = "Check " + boss.getType();
		
		return actions;
	}
	
	/**
	/**
	 * Determines which action to execute during a special boss fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param hero the character controlled by the player
	 * @param boss the special Boss to fight
	 * @param phase the current phase of the special boss fight
	 * @return Whether or not it still is the hero's turn or not
	 * @throws InterruptedException
	 */
	public static boolean executeSpecialFightCommand(String[] command, Hero hero, Boss boss, int phase) throws InterruptedException {
	
		if (command[0].equals("inventory")) {
			Message.showInventory(hero);
		}
		
		
		else if (command[0].equals("hero") && command.length > 1 && command[1].equals("info")) {
			Message.showHero(hero);
		}
		
		
		else if (command[0].equals("use") && command.length > 1 && command[1].equals("potion")) {
			if (command.length < 3) {
				Message.notSpecified("Potion");
			}
			else {
				int numPotion = Integer.parseInt(command[2]);
				if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
					hero.usePotion(hero.getInventory().getPotions()[numPotion - 1]);
					return false;
				}
				else {
					Message.notExists("Potion");
				}
			}
		}
		
		
		else if (command[0].equals("attack")) {
			if (command.length > 1) {
				if (command.length > 2) { // If the name is composed of more than one word, reassemble the name in one String
					for (int i = 2; i < command.length; ++i) {
						command[1] = command[1] + " " + command[i];
					}
				}
				if (command[1].equals(boss.getType().toLowerCase())) {
					hero.attack(boss);
					return false;
				}
				else {
					Message.notValid("Enemy Type Input");
				}
			}
			else {
				Message.notSpecified("Enemy");
			}
			
		}
		
		
		else if (command[0].equals("check")) {
			if (command.length > 1) {
				if (command.length > 2) { // If the name is composed of more than one word, reassemble the name in one String
					for (int i = 2; i < command.length; ++i) {
						command[1] = command[1] + " " + command[i];
					}
				}
				if (command[1].equals(boss.getType().toLowerCase())) {
					Message.showBoss(boss);
				}
				else {
					Message.notValid("Enemy Type Input");
				}
			}
			else {
				Message.notSpecified("Enemy");
			}
		}
		
		
		else if (command[0].equals("show")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							Message.showItem(hero.getInventory().getWeapons()[numWeapon - 1]);
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							Message.showItem(hero.getInventory().getArtifacts()[numArtifact - 1]);
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else if (command[1].equals("potion")) { // For potions
					if (command.length < 3) {
						Message.notSpecified("Potion");
					}
					else {
						int numPotion = Integer.parseInt(command[2]);
						if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
							Message.showItem(hero.getInventory().getPotions()[numPotion - 1]);
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (command[0].equals("equip")) {
			if (command.length > 1) {
				if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							hero.equipWeapon(hero.getInventory().getWeapons()[numWeapon - 1]);
							return false;
						}
						else {
							Message.notExists("Weapon");
						}
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (command.length < 3) {
						Message.notSpecified("Artifact");
					}
					else {
						int numArtifact = Integer.parseInt(command[2]);
						if (numArtifact != 0 && numArtifact <= hero.getInventory().getArtifacts().length && hero.getInventory().getArtifacts()[numArtifact - 1] != null) {
							hero.equipArtifact(hero.getInventory().getArtifacts()[numArtifact - 1]);
							return false;
						}
						else {
							Message.notExists("Artifact");
						}
					}
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		
		else if (phase == 1 && command[0].equals("invoke") && command.length > 1 && command[1].equals("anti-void")) {
			boss.setHP(boss.getHP() - 125);
			hero.setHP(hero.getCurrentMaxHP());
			Message.antiVoidIncantation(hero, boss);
			return false;
		}
		
		
		else {
			Message.notRecognized();
		}
		
		return true;
		
	}
	
}
