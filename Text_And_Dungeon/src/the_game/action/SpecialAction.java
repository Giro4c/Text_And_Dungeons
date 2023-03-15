package the_game.action;

import the_game.Boss;
import the_game.Hero;
import the_game.Message;

public class SpecialAction {
	
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
					Message.showActions(specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (FightAction.isBossDown(boss) == true) {
					initializePhase2(boss);
					phase = 2;
					break;
				}
			}
			else {
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (FightAction.isBossDown(boss) == true) {
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
					Message.showActions(specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (FightAction.isBossDown(boss) == true) {
					break;
				}
			}
			else {
				isHeroTurn = true;
				while (isHeroTurn == true) {
					Message.showActions(specialFightActions(boss, phase), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(4);
					isHeroTurn = executeSpecialFightCommand(command, hero, boss, phase);
				}
				if (FightAction.isBossDown(boss) == true) {
					break;
				}
				boss.attack(hero);
				if (hero.getHP() <= 0) {
					break;
				}
			}
		}
		if (FightAction.isBossDown(boss) == true) {
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
