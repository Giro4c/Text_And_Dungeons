package the_game.action;

import the_game.Boss;
import the_game.Chest;
import the_game.create.Create;
import the_game.Enemy;
import the_game.Hero;
import the_game.Message;

public class PassiveAction {
	
	/* -------------------------------------------------------------------- *
	 * -------------------------PASSIVE ACTIONS---------------------------- *
	 * -------------------------------------------------------------------- */
		
	/**
	 * Create the String array containing all possible actions available when not in a fight.
	 * @param variablePActions a String array that contains all actions that are not final (like move actions and chest opening actions)
	 * @return a String array containing all the available actions outside a fight
	 * @see #evaluateAvailableActions(Hero, int[][], Chest[], String[]) for changing passive actions
	 */
	public static String[] actions(String[] variablePActions) {
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
	public static String[] notFinalActions() {
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
	public static String[] evaluateAvailableActions(Hero hero, int[][] walls, Chest[] chests, String[] passiveActions) {
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
	public static void executeCommand(String[] command, Hero hero, int[][] walls, Chest[] chests, Enemy[] enemies, Boss[] bosses) throws InterruptedException {
		
		if (command[0].equals("inventory")) {
			Message.showInventory(hero);
		}
		
		
		else if (command[0].equals("hero") && command.length > 1 && command[1].equals("info")) {
			Message.showHero(hero);
		}
		
		
		else if (command[0].equals("move")) {
			if (command.length > 1) {
				if (command[1].equals("up") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Move Up") == true) {
					hero.move('z');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("down") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Move Down") == true) {
					hero.move('s');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("right") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Move Right") == true) {
					hero.move('d');
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("left") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Move Left") == true) {
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
				if (command[1].equals("top") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Open Top Chest") == true) {
					hero.openChest('z', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("bottom") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Open Bottom Chest") == true) {
					hero.openChest('s', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("right") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Open Right Chest") == true) {
					hero.openChest('d', chests);
					hero.setSpecialActionCount(0);
				}
				else if (command[1].equals("left") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, notFinalActions()), "Open Left Chest") == true) {
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
	
	
}
