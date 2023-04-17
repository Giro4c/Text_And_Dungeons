package the_game;
import java.util.Random;

import the_game.create.*;
import the_game.enemyWarrior_classes.Valky;
import the_game.monster_classes.Slime;
import the_game.action.*;

/**
 * An executable class for new functionalities testing
 * @author Camille Girodengo
 *
 */
public class Test {

	public static String[] lastValidCommand = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		Test.testEquals();
		
	}
	
	private static void replaceWallCreationInstructionsByNewOnes(int numMap) {
		Create.setMapID(numMap);
		int[][] walls = new int[0][2];
		String instruction;
		int prevLine = -1;
		int newIndex = 0;
		for(int indexWall = 0; indexWall < walls.length; ++indexWall) {
			if (walls[indexWall][1] == -1 || walls[indexWall][0] == -1) continue;
			if(walls[indexWall][1] != prevLine) {
				prevLine = walls[indexWall][1];
				System.out.println("// ------------------------------ " + prevLine);
			}
			instruction = "walls[" + newIndex + "] = new Wall(" + walls[indexWall][0] + ", " + walls[indexWall][1] + ", true);";
			System.out.println(instruction);
			++newIndex;
		}
		System.out.println("The size of the array is : " + newIndex);
	}
	
	private static void testEvent2Map2() throws InterruptedException {
		
		Create.setMapID(2);
		Hero hero = CreateHero.createHero();
		Wall[] walls = CreateWalls.placeWalls();
		Chest[] chests = CreateChests.placeChests();
		Teleport[] teleports = CreateTeleports.placeTeleports();
		Enemy[] enemies = CreateEnemies.spawnEnemies();
		Boss[] bosses = CreateBosses.spawBoss();
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
		EventManager eventManager = new EventManager();
		
		for (Enemy enemy : enemies) {
			enemy.setHP(1);
		}
		int indexNewEnemyDown = 0;
		Test.lastValidCommand = new String[2];
		Test.lastValidCommand[0] = "attack";
		
		// Test for IE 0 of Event 2
//		while (indexNewEnemyDown < enemies.length / 4) {
//			hero.attack(enemies[indexNewEnemyDown]);
//			Test.lastValidCommand[1] = enemies[indexNewEnemyDown].getName().toLowerCase();
//			eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
//			System.out.println("------------------- " + eventManager.getSumEnemiesDown() + " -------------------");
//			++indexNewEnemyDown;
//		}
		
		// Test for IE 1 of Event 2
//		while (indexNewEnemyDown < enemies.length / 2) {
//			hero.attack(enemies[indexNewEnemyDown]);
//			Test.lastValidCommand[1] = enemies[indexNewEnemyDown].getName().toLowerCase();
//			eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
//			System.out.println("------------------- " + eventManager.getSumEnemiesDown() + " -------------------");
//			++indexNewEnemyDown;
//		}
		
		// Test for IE 2 of Event 2
//		while (indexNewEnemyDown < enemies.length - (enemies.length / 4)) {
//			hero.attack(enemies[indexNewEnemyDown]);
//			Test.lastValidCommand[1] = enemies[indexNewEnemyDown].getName().toLowerCase();
//			eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
//			System.out.println("------------------- " + eventManager.getSumEnemiesDown() + " -------------------");
//			++indexNewEnemyDown;
//		}
		
		// Test for IE 3 of Event 2
		while (indexNewEnemyDown < enemies.length) {
			hero.attack(enemies[indexNewEnemyDown]);
			Test.lastValidCommand[1] = enemies[indexNewEnemyDown].getName().toLowerCase();
			eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
			System.out.println("------------------- " + eventManager.getSumEnemiesDown() + " -------------------");
			++indexNewEnemyDown;
		}
		
		
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
		Message.showHero(hero);
		
	}
	
	private static void testEvent1Map2() throws InterruptedException {
		
		Create.setMapID(2);
		Hero hero = CreateHero.createHero();
		Wall[] walls = CreateWalls.placeWalls();
		Chest[] chests = CreateChests.placeChests();
		Teleport[] teleports = CreateTeleports.placeTeleports();
		Enemy[] enemies = CreateEnemies.spawnEnemies();
		Boss[] bosses = CreateBosses.spawBoss();
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
		EventManager eventManager = new EventManager();
		
		hero.setX(4);
		hero.setY(21);
		eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
		hero.setX(11);
		hero.setY(24);
		eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
	}
	
	private static void oracleVersusResult(boolean oracle, boolean result) {
		System.out.println("Result expected : " + oracle);
		System.out.println("Result obtained : " + result);
		if (oracle == result) {
			System.out.println(Message.ANSI_GREEN + "Correct." + Message.ANSI_RESET);
		}
		else {
			System.out.println(Message.ANSI_RED + "Incorrect." + Message.ANSI_RESET);
		}
		System.out.println();
	}
	
	private static void testGame() throws InterruptedException {
		
		// Map to test
		Create.setMapID(1);
		
		// Changing hero's coordinates
		Hero hero = CreateHero.createHero();
		hero.setDef(999);
		
		// All entities
		Wall[] walls = CreateWalls.placeWalls();
		Chest[] chests = CreateChests.placeChests();
		Teleport[] teleports = CreateTeleports.placeTeleports();
		Enemy[] enemies = CreateEnemies.spawnEnemies();
		Boss[] bosses = CreateBosses.spawBoss();
		
		// Declaring EventManager
		EventManager eventManager = new EventManager();
		
		// Show the map
		Message.showMap(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
		boolean inFight = false;
		boolean isHeroTurn = true;
		
		while (true) {
			// Related to Passive Actions
			if (inFight == false) {
				Message.showActions(PassiveAction.actions(PassiveAction.evaluateAvailableActions(hero, walls, chests, teleports, PassiveAction.notFinalActions())), 2, 7);
				System.out.print("What will you do ?" + '\n');
				String[] command = Message.registerCommand(4);
				PassiveAction.executeCommand(command, hero, walls, chests, teleports, enemies, bosses);
				
				if (hero.isEnemyAround(enemies, bosses) == true) {
					inFight = true;
					Message.enterFight(hero);
				}
			}
			
			// Related to Fight Actions
			else { // inFight == true
				if (hero.isBossAround(bosses) != -1) {
					SpecialAction.bossFight(hero, bosses[hero.isBossAround(bosses)]);
					break;
				}
				FightAction.enemiesAttack(hero, enemies, bosses, hero.getSpeed() + 1, FightAction.maxSpeedEnemies(hero.whoIsAround(enemies, bosses), enemies, bosses));
				if (hero.getHP() <= 0) {
					break;
				}
				isHeroTurn = true;
				
				while (isHeroTurn == true) {
					Message.showActions(FightAction.actions(hero.whoIsAround(enemies, bosses)), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(3);
					isHeroTurn = FightAction.executeCommand(command, hero, walls, chests, teleports, enemies, bosses);
				}
				if (FightAction.isBossDown(bosses[0]) == true) {
					break;
				}
				if (hero.isEnemyAround(enemies, bosses) == false) {
					inFight = false;
					Message.exitsFight(hero);
					continue;
				}
				FightAction.enemiesAttack(hero, enemies, bosses, 0, hero.getSpeed());
				if (hero.getHP() <= 0) {
					break;
				}
			
			}
			
			eventManager.verifyIfEventAndTrigger(hero, bosses, teleports, walls, chests, enemies);
			
		}
		
		if (hero.getHP() > 0) {
			Message.dungeonConquered(hero);
		}
		else {
			Message.notDungeonConquered(hero);
		}
		
	}
	
	private static void testEquals() {
		
		// Test for Entity
		System.out.println(Message.ANSI_BLUE + "Test for Entity" + Message.ANSI_RESET);
		
		Entity entity1 = new Entity("Ent 1", "Entity");
		Entity entity2 = new Entity("Ent 1", "Entity");
		Entity entity3 = new Entity("Ent 3", "Entity");
		Entity entity4 = new Entity("Ent 1", "Random Entity");
		
		oracleVersusResult(true, entity1.equals(entity2));
		oracleVersusResult(false, entity1.equals(entity3));
		oracleVersusResult(false, entity1.equals(entity4));
		
			// Test for VisibleEntity
		System.out.println(Message.ANSI_BLUE + "Test for VisibleEntity" + Message.ANSI_RESET);
		
		VisibleEntity visibleEntity1 = new VisibleEntity("VE 1", "Vis Ent", 1, 5, true);
		VisibleEntity visibleEntity2 = new VisibleEntity("VE 1", "Vis Ent", 1, 5, true);
		VisibleEntity visibleEntity3 = new VisibleEntity("VE 1", "Vis Ent", 5, 5, true);
		VisibleEntity visibleEntity4 = new VisibleEntity("VE 1", "Vis Ent", 1, 1, true);
		VisibleEntity visibleEntity5 = new VisibleEntity("VE 1", "Vis Ent", 1, 5, false);
		
		oracleVersusResult(true, visibleEntity1.equals(visibleEntity2));
		oracleVersusResult(false, visibleEntity1.equals(visibleEntity3));
		oracleVersusResult(false, visibleEntity1.equals(visibleEntity4));
		oracleVersusResult(false, visibleEntity1.equals(visibleEntity5));
		
			// Test for LivingEntity
		System.out.println(Message.ANSI_BLUE + "Test for LivingEntity" + Message.ANSI_RESET);
		
		LivingEntity livingEntity1 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 10, 11, 12, 13);
		LivingEntity livingEntity2 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 10, 11, 12, 13);
		LivingEntity livingEntity3 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 1, 11, 12, 13);
		LivingEntity livingEntity4 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 10, 1, 12, 13);
		LivingEntity livingEntity5 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 10, 11, 1, 13);
		LivingEntity livingEntity6 = new LivingEntity("LE 1", "Live Ent", 1, 4, true, 10, 11, 12, 1);
		
		oracleVersusResult(true, livingEntity1.equals(livingEntity2));
		oracleVersusResult(false, livingEntity1.equals(livingEntity3));
		oracleVersusResult(false, livingEntity1.equals(livingEntity4));
		oracleVersusResult(false, livingEntity1.equals(livingEntity5));
		oracleVersusResult(false, livingEntity1.equals(livingEntity6));
			
				// Test for Boss
		System.out.println(Message.ANSI_BLUE + "Test for Boss" + Message.ANSI_RESET);
		
		Boss boss1 = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 1, 6, 1, true, 300, 50, 30, 35);
		Boss boss2 = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 1, 6, 1, true, 300, 50, 30, 35);
		Boss boss3 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss3.setPhaseStats(2, 300, 50, 30, 35);
		Boss boss8 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss8.setPhaseStats(2, 300, 50, 30, 35);
		Boss boss4 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss4.setPhaseStats(2, 1, 50, 30, 35);
		Boss boss5 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss5.setPhaseStats(2, 300, 1, 30, 35);
		Boss boss6 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss6.setPhaseStats(2, 300, 50, 1, 35);
		Boss boss7 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss7.setPhaseStats(2, 300, 50, 30, 1);
		Boss boss9 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 2, 6, 1, true, 300, 50, 30, 35);
		boss9.setPhaseStats(2, 300, 50, 30, 35);
		boss9.setCurrentPhase(2);
		
		oracleVersusResult(true, boss1.equals(boss2));
		oracleVersusResult(false, boss1.equals(boss3));
		oracleVersusResult(true, boss3.equals(boss8));
		oracleVersusResult(false, boss3.equals(boss4));
		oracleVersusResult(false, boss3.equals(boss5));
		oracleVersusResult(false, boss3.equals(boss6));
		oracleVersusResult(false, boss3.equals(boss7));
		oracleVersusResult(false, boss3.equals(boss9));
		
				// Test for Enemy
		System.out.println(Message.ANSI_BLUE + "Test for Enemy" + Message.ANSI_RESET);
		
		Enemy enemy1 = new Enemy("Enemy 1", "EN", 1, 1, true, 100);
		Enemy enemy2 = new Enemy("Enemy 1", "EN", 1, 1, true, 100);
		Enemy enemy3 = new Enemy("Enemy 1", "EN", 1, 1, true, 10);
		
		oracleVersusResult(true, enemy1.equals(enemy2));
		oracleVersusResult(false, enemy1.equals(enemy3));
		
					// Test for Enemy objects with different classes
		System.out.println(Message.ANSI_BLUE + "Test for Enemy objects with different classes" + Message.ANSI_RESET);
		
		Monster monster1 = new Slime(1, 1, 1, true);
		EnemyWarrior enW1 = new Valky("Slime 1", 1, 1, true);
		enW1.setType("Monster");
		
		oracleVersusResult(false, monster1.equals(enW1));
			
			// Test for Teleport
		System.out.println(Message.ANSI_BLUE + "Test for Teleport" + Message.ANSI_RESET);
		
		Teleport teleport1 = new Teleport("Waypoint", 1, 2, 3, 4, true);
		Teleport teleport2 = new Teleport("Waypoint", 1, 2, 3, 4, true);
		Teleport teleport3 = new Teleport("Waypoint", 1, 2, 4, 3, false);
		Teleport teleport4 = new Teleport("Waypoint", 2, 1, true, 3, 4, false);
		
		oracleVersusResult(true, teleport1.equals(teleport2));
		oracleVersusResult(false, teleport1.equals(teleport3));
		oracleVersusResult(false, teleport1.equals(teleport4));
			
			// Test for Item
		System.out.println(Message.ANSI_BLUE + "Test for Item" + Message.ANSI_RESET);
		
		int[] statsV = {4, 5};
		String[] statsN = {"Attack", "Speed"};
		Item item1 = new Item("Item1", "Item", statsN.clone(), statsV.clone());
		Item item2 = new Item("Item1", "Item", statsN.clone(), statsV.clone());
		statsV[1] = 1;
		Item item3 = new Item("Item1", "Item", statsN.clone(), statsV.clone());
		statsN[1] = "Defense";
		Item item4 = new Item("Item1", "Item", statsN.clone(), statsV.clone());
		
		oracleVersusResult(true, item1.equals(item2));
		oracleVersusResult(false, item1.equals(item3));
		oracleVersusResult(false, item3.equals(item4));
		
			// Test for Chest
		System.out.println(Message.ANSI_BLUE + "Test for Chest" + Message.ANSI_RESET);
		
		String[] statsNW = {"Attack"};
		int[] statsVW = {3};
		Weapon weapon1 = new Weapon("Iron Sword", statsNW.clone(), statsVW.clone());
		String[] statsNA = {"HP"};
		int[] statsVA = {30};
		Artifact artifact1 = new Artifact("Soul Stone", statsNA.clone(), statsVA.clone());
		String[] statsNP = {"HP"};
		int[] statsVP = {15};
		Potion potion1 = new Potion("Heal", statsNP.clone(), statsVP.clone());
		
		Chest chest1 = new Chest("Chest 1", 0, 0, true, weapon1, null, null);
		Chest chest2 = new Chest("Chest 1", 0, 0, true, weapon1, null, null);
		Chest chest3 = new Chest("Chest 1", 0, 0, true, weapon1, artifact1, null);
		Chest chest4 = new Chest("Chest 1", 0, 0, true, weapon1, artifact1, potion1);
		
		oracleVersusResult(true, chest1.equals(chest2));
		oracleVersusResult(false, chest1.equals(chest3));
		oracleVersusResult(false, chest1.equals(chest4));
		oracleVersusResult(false, chest3.equals(chest4));
		
			// Test for Inventory
		System.out.println(Message.ANSI_BLUE + "Test for Inventory" + Message.ANSI_RESET);
		
		Inventory inventory1 = new Inventory();
		Inventory inventory2 = new Inventory();
		Inventory inventory3 = new Inventory();
		inventory3.setWeapon(1, weapon1);
		Inventory inventory3Bis = new Inventory();
		inventory3Bis.setWeapon(1, weapon1);
		Inventory inventory4 = new Inventory();
		inventory4.setArtifact(1, artifact1);
		Inventory inventory5 = new Inventory();
		inventory5.setPotion(1, potion1);
		Inventory inventory6 = new Inventory();
		inventory6.setWeapon(1, weapon1);
		inventory6.setArtifact(1, artifact1);
		inventory6.setPotion(1, potion1);
			
		oracleVersusResult(true, inventory1.equals(inventory2));
		oracleVersusResult(true, inventory3.equals(inventory3Bis));
		oracleVersusResult(false, inventory1.equals(inventory6));
		oracleVersusResult(false, inventory6.equals(inventory3));
		oracleVersusResult(false, inventory6.equals(inventory4));
		oracleVersusResult(false, inventory6.equals(inventory5));
		
			// Test for Hero
		System.out.println(Message.ANSI_BLUE + "Test for Hero" + Message.ANSI_RESET);
		
		Hero hero1 = new Hero("Charles", 0, 0, true);
		Hero hero2 = new Hero("Charles", 0, 0, true);
		Hero hero3 = new Hero("Charles", 0, 0, true);
		hero3.setCurrentWeapon(weapon1);
		Hero hero4 = new Hero("Charles", 0, 0, true);
		hero4.setCurrentArtifact(artifact1);
		
		oracleVersusResult(true, hero1.equals(hero2));
		oracleVersusResult(false, hero1.equals(hero3));

		
	}
	
	private static void swapInt(int[] intArray, int index1, int index2) {
		int container = intArray[index1];
		intArray[index1] = intArray[index2];
		intArray[index2] = container;
	}
	
	private static int[] shuffleIntArray(int[] intArray) {
		Random rand = new Random();
		int randIndex;
		for (int i = 0; i < intArray.length; ++i) {
			randIndex = rand.nextInt(intArray.length);
			swapInt(intArray, i, randIndex);
		}
		return intArray;
	}
	
	private static void showIntArray(int[] intArray) {
		for(int intVal : intArray) {
			System.out.print(intVal);
			System.out.print('\n');
		}
	}

	private static void stock() {
		
	}
	
}
