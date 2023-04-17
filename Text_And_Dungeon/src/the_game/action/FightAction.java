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

public class FightAction {

	/* -------------------------------------------------------------------- *
	 * ---------------------------FIGHT ACTIONS---------------------------- *
	 * -------------------------------------------------------------------- */

	/**
	 * Create a String array containing all available fight actions including those that changes depending on the name of the enemy. 
	 * @param enemiesNames the names of all the enemies right next to the hero
	 * @return a String array with all available fight actions
	 */
	public static String[] actions(EntityIdentity[] enemiesIDs) {
		int countEnemies = 0;
		for (EntityIdentity enemyID : enemiesIDs) {
			if (enemyID != null) {
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
		for (int i = 0, count = 1; i < enemiesIDs.length; ++i) {
			if (enemiesIDs[i] != null) {
				actions[10 + count] = "Attack " + enemiesIDs[i].getEntity().getName();
				++count;
				actions[10 + count] = "Check " + enemiesIDs[i].getEntity().getName();
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
	public static boolean executeCommand(String[] command, Hero hero, Wall[] walls, Chest[] chests, Teleport[] teleports, Enemy[] enemies, Boss[] bosses) {
		
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
		
		
		else if (command[0].equals("use") && command.length > 1 && command[1].equals("potion")) {
			if (command.length < 3) {
				Message.notSpecified("Potion");
			}
			else {
				int numPotion = Integer.parseInt(command[2]);
				if (numPotion != 0 && numPotion <= hero.getInventory().getPotions().length && hero.getInventory().getPotions()[numPotion - 1] != null) {
					hero.usePotion(hero.getInventory().getPotions()[numPotion - 1]);
					Game.lastValidCommand = command;
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
				for (EntityIdentity enemyAround : hero.whoIsAround(enemies, bosses)) {
					if (enemyAround != null && enemyAround.getEntity().getName().toLowerCase().equals(command[1])) {
						if (enemyAround.getEntity().getType().equals("Opposing Warrior") || enemyAround.getEntity().getType().equals("Monster")) {
							hero.attack(enemies[enemyAround.getIndex()]);
							Game.lastValidCommand = command;
							return false;
						}
						else if (enemyAround.getEntity().getType().contains("Boss")) {
							hero.attack(bosses[enemyAround.getIndex()]);
							Game.lastValidCommand = command;
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
				for (EntityIdentity enemyAround : hero.whoIsAround(enemies, bosses)) {
					if (enemyAround != null && enemyAround.getEntity().getName().toLowerCase().equals(command[1])) {
						if (enemyAround.getEntity().getType().equals("Opposing Warrior") || enemyAround.getEntity().getType().equals("Monster")) {
							Message.checkEnemy(enemies[enemyAround.getIndex()]);
							Game.lastValidCommand = command;
							return true;
						}
						else if (enemyAround.getEntity().getType().contains("Boss")) {
							Message.showBoss(bosses[enemyAround.getIndex()]);
							Game.lastValidCommand = command;
							return true;
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
					Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
					Game.lastValidCommand = command;
					return true;
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
							Game.lastValidCommand = command;
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
						Game.lastValidCommand = command;
						return false;
					}
					else {
						Message.notExists("Selected current Weapon");
					}
				}
				else if (command[1].equals("artifact")) { // For artifacts
					if (hero.getCurrentArtifact() != null) {
						hero.unEquipArtifact();
						Game.lastValidCommand = command;
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
		
		Game.lastValidCommand = command;
		return true;
	}
	
	/**
	 * Determines the maximum speed of the enemies around the hero
	 * @param enemiesNames the names of the enemies or bosses around the hero
	 * @param enemies an Enemy array of all the hostile entities of the map outside of bosses
	 * @param bosses a Boss array of all the bosses of the map
	 * @return the maximum speed of the enemies around the hero
	 */
	public static int maxSpeedEnemies(EntityIdentity[] enemiesIDs, Enemy[] enemies, Boss[] bosses) {
		int maxSpeed = 0;
		for (EntityIdentity enemyID : enemiesIDs) {
			if (enemyID != null) {
				if (enemyID.getEntity().getType().equals("Opposing Warrior") || enemyID.getEntity().getType().equals("Monster")) {
					maxSpeed = Math.max(maxSpeed, enemies[enemyID.getIndex()].getSpeed());
				}
				else if (enemyID.getEntity().getType().contains("Boss")) {
					maxSpeed = Math.max(maxSpeed, bosses[enemyID.getIndex()].getSpeed());
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
		for (EntityIdentity enemyID : hero.whoIsAround(enemies, bosses)) {
			if (enemyID != null) {
				if ((enemyID.getEntity().getType().equals("Opposing Warrior") || enemyID.getEntity().getType().equals("Monster")) && enemies[enemyID.getIndex()].getSpeed() >= minSpeed && enemies[enemyID.getIndex()].getSpeed() <= maxSpeed) {
					enemies[enemyID.getIndex()].attack(hero);
				}
				else if (enemyID.getEntity().getType().contains("Boss") && bosses[enemyID.getIndex()].getSpeed() >= minSpeed && bosses[enemyID.getIndex()].getSpeed() <= maxSpeed) {
					bosses[enemyID.getIndex()].attack(hero);
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
	
	
}
