package the_game.action;

import the_game.Boss;
import the_game.Chest;
import the_game.create.Create;
import the_game.Enemy;
import the_game.EntityIdentity;
import the_game.Game;
import the_game.Hero;
import the_game.Message;
import the_game.Teleport;
import the_game.Wall;

public class PassiveAction {
	
	/* -------------------------------------------------------------------- *
	 * -------------------------PASSIVE ACTIONS---------------------------- *
	 * -------------------------------------------------------------------- */
		
	/**
	 * Create the String array containing all possible actions available when not in a fight.
	 * @param variablePActions a String array that contains all actions that are not final (like move actions and chest opening actions)
	 * @return a String array containing all the available actions outside a fight
	 * @see #evaluateAvailableActions(Hero, Wall[], Chest[], String[]) for changing passive actions
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
		String[] passiveActions = new String[10];
		passiveActions[0] = "Move Up";
		passiveActions[1] = "Move Down";
		passiveActions[2] = "Move Right";
		passiveActions[3] = "Move Left";
		passiveActions[4] = "Open Top Chest";
		passiveActions[5] = "Open Bottom Chest";
		passiveActions[6] = "Open Left Chest";
		passiveActions[7] = "Open Right Chest";
		passiveActions[8] = "Use Teleport";
		passiveActions[9] = "Show Teleport";
		
		return passiveActions;
	}
	
	/**
	 * Evaluate which passive actions are available depending on the hero's immediate surroundings
	 * @param hero the hero whose surroundings are checked
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array, mostly used to know where all the chests are in this case
	 * @param teleports a Teleport array, mostly used to know where all the teleports are in this case
	 * @param passiveActions a String array which contains all possibly changing passive actions
	 * @return a String array which contains all available changing passive actions
	 */
	public static String[] evaluateAvailableActions(Hero hero, Wall[] walls, Chest[] chests, Teleport[] teleports, String[] passiveActions) {
		String[] newPActions = passiveActions;
		EntityIdentity[] elemNearby = hero.verifySuroundings(walls, chests);
		EntityIdentity elemUnder = hero.checkUnder(teleports);
		// Verify if there is wall
		if (elemNearby[0].getEntity().getType() == "Wall") { // Up
			newPActions[0] = null;
			newPActions[4] = null;
		}
		if (elemNearby[1].getEntity().getType() == "Wall") { // Right
			newPActions[2] = null;
			newPActions[7] = null;
		}
		if (elemNearby[2].getEntity().getType() == "Wall") { // Down
			newPActions[1] = null;
			newPActions[5] = null;
		}
		if (elemNearby[3].getEntity().getType() == "Wall") { // Left
			newPActions[3] = null;
			newPActions[6] = null;
		}
		// Verify if there is Chest
		if (elemNearby[0].getEntity().getType() != "Chest") { // Up
			newPActions[4] = null;
		}
		else {
			newPActions[0] = null;
		}
		if (elemNearby[1].getEntity().getType() != "Chest") { // Right
			newPActions[7] = null;
		}
		else {
			newPActions[2] = null;
		}
		if (elemNearby[2].getEntity().getType() != "Chest") { // Down
			newPActions[5] = null;
		}
		else {
			newPActions[1] = null;
		}
		if (elemNearby[3].getEntity().getType() != "Chest") { // Left
			newPActions[6] = null;
		}
		else {
			newPActions[3] = null;
		}
		// Verify if there is a teleport where the hero is located
		if (elemUnder.getEntity().getType() != "Teleport") {
			newPActions[8] = null;
			newPActions[9] = null;
		}
		
		return newPActions;
	}
	
	/**
	 * Determines which action to execute outside of a fight depending on the command input
	 * @param command the String array which contains the command entered by the player
	 * @param hero the character controlled by the player
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array containing the informations on all the chest on the map
	 * @param teleports a Teleport array, mostly used to know where all the teleports are in this case
	 * @param enemies a Enemy array containing all hostile living entities that can be attacked by the hero outside of bosses. <strong>Used here for the "Show Map" action only.</strong>
	 * @param bosses a Boss array containing all hostile bosses entities that can be attacked by the hero. <em>Include known and hidden bosses.</em> <strong>Used here for the "Show Map" action only.</strong>
	 * @throws InterruptedException
	 */
	public static boolean executeCommand(String[] command, Hero hero, Wall[] walls, Chest[] chests, Teleport[] teleports, Enemy[] enemies, Boss[] bosses) throws InterruptedException {
		
		if (command[0].equals("inventory")) {
			Message.showInventory(hero);
			Game.lastValidCommand = command;
			return true;
		}
		
		
		else if (command[0].equals("hero") && command.length > 1 && command[1].equals("info")) {
			Message.showHero(hero);
			Game.lastValidCommand = command;
			return true;
		}
		
		
		else if (command[0].equals("move")) {
			if (command.length > 1) {
				if (command[1].equals("up") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Move Up") == true) {
					hero.move('z');
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("down") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Move Down") == true) {
					hero.move('s');
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("right") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Move Right") == true) {
					hero.move('d');
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("left") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Move Left") == true) {
					hero.move('q');
					Game.lastValidCommand = command;
					return true;
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
				if (command[1].equals("top") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Open Top Chest") == true) {
					hero.openChest(chests[hero.verifyDirection('z', walls, chests).getIndex()]);
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("bottom") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Open Bottom Chest") == true) {
					hero.openChest(chests[hero.verifyDirection('s', walls, chests).getIndex()]);
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("right") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Open Right Chest") == true) {
					hero.openChest(chests[hero.verifyDirection('d', walls, chests).getIndex()]);
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("left") && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Open Left Chest") == true) {
					hero.openChest(chests[hero.verifyDirection('q', walls, chests).getIndex()]);
					Game.lastValidCommand = command;
					return true;
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
					Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
				}
				else if (command[1].equals("weapon")) { // For weapons
					if (command.length < 3) {
						Message.notSpecified("Weapon");
					}
					else {
						int numWeapon = Integer.parseInt(command[2]);
						if (numWeapon != 0 && numWeapon <= hero.getInventory().getWeapons().length && hero.getInventory().getWeapons()[numWeapon - 1] != null) {
							Message.showItem(hero.getInventory().getWeapons()[numWeapon - 1]);
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else if (command[1].equals("teleport") == true && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Show Teleport") == true) {
					Message.showTeleport(teleports[hero.checkUnder(teleports).getIndex()]);
					Game.lastValidCommand = command;
					return true;
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
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
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
							Game.lastValidCommand = command;
							return true;
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
					Game.lastValidCommand = command;
					return true;
				}
				else if (command[1].equals("artifact")) { // For artifacts
					hero.unEquipArtifact();
					Game.lastValidCommand = command;
					return true;
				}
				else {
					Message.notRecognized();
				}
			}
			else {
				Message.notSpecified("Item type");
			}
		}
		
		else if (command[0].equals("use")) {
			if (command.length > 1) {
				if (command[1].equals("potion")) {
					if (command.length < 3) {
						Message.notSpecified("Potion");
					}
					else {
						int numPotion = Integer.parseInt(command[2]);
						if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
							hero.usePotion(hero.getInventory().getPotions()[numPotion - 1]);
							Game.lastValidCommand = command;
							return true;
						}
						else {
							Message.notExists("Potion");
						}
					}
				}
				else if (command[1].equals("teleport") == true && UtilsAction.isInStringArray(evaluateAvailableActions(hero, walls, chests, teleports, notFinalActions()), "Use Teleport") == true) {
					hero.useTeleport(teleports[hero.checkUnder(teleports).getIndex()]);
					Game.lastValidCommand = command;
					return true;
				}
			}
			
			else {
				Message.notSpecified("Usable Entity");
			}
		}
		
		else if (command[0].equals("attack") && Create.getMapID() == 1 && hero.getX() == 1 && hero.getY() == 15) {
			Game.lastValidCommand = command;
			return true;
		}
		
		else {
			Message.notRecognized();
		}
		
		Game.lastValidCommand = null;
		return true;
	}
	
	
}
