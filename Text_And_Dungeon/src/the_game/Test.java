package the_game;
import java.util.Random;

import the_game.create.*;
import the_game.action.*;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		testEquals();
		
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
				Create.setMapID(2);
				
				// Changing hero's coordinates
				// Situation : near a boss
				Hero hero = CreateHero.createHero();
				hero.setX(41);
				hero.setY(43);
				
				// All entities
				int[][] walls = CreateWalls.placeWalls();
				Chest[] chests = CreateChests.placeChests();
				Teleport[] teleports = CreateTeleports.placeTeleports();
				Enemy[] enemies = CreateEnemies.spawnEnemies();
				Boss[] bosses = CreateBosses.spawBoss();
				
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
						SpecialAction.checkHeroLocation(hero, bosses);
						if (hero.isEnemyAround(enemies, bosses) == true) {
							inFight = true;
							Message.enterFight(hero);
						}
					}
					
					// Related to Fight Actions
					else { // inFight == true
						if (Create.getMapID() == 1 && hero.getSpecialLocation() == 1) {
							SpecialAction.hiddenBossFight(hero, bosses[1]);
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
				Entity entity4 = new Entity("Ent 3", "Random Entity");
				
				oracleVersusResult(true, entity1.equals(entity2));
				oracleVersusResult(false, entity1.equals(entity3));
				oracleVersusResult(false, entity3.equals(entity4));
				
					// Test for LivingEntity
				System.out.println(Message.ANSI_BLUE + "Test for LivingEntity" + Message.ANSI_RESET);
				
				LivingEntity livingEntity1 = new LivingEntity("LE 1", "Live Ent");
				LivingEntity livingEntity2 = new LivingEntity("LE 1", "Live Ent");
				LivingEntity livingEntity3 = new LivingEntity("LE 1", "Live Ent", 1, 4);
				LivingEntity livingEntity4 = new LivingEntity("LE 1", "Live Ent", 10, 11, 12, 13);
				LivingEntity livingEntity5 = new LivingEntity("LE 1", "Live Ent", 1, 4, 10, 11, 12, 13);
				
				oracleVersusResult(true, livingEntity1.equals(livingEntity2));
				oracleVersusResult(false, livingEntity1.equals(livingEntity3));
				oracleVersusResult(false, livingEntity3.equals(livingEntity5));
				oracleVersusResult(false, livingEntity1.equals(livingEntity4));
				oracleVersusResult(false, livingEntity4.equals(livingEntity5));
					
						// Test for Boss
				System.out.println(Message.ANSI_BLUE + "Test for Boss" + Message.ANSI_RESET);
				
				Boss boss1 = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 0, 6, 1, 300, 50, 30, 35);
				Boss boss2 = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 0, 6, 1, 300, 50, 30, 35);
				Boss boss3 = new Boss("Dragon Cirk", "Dungeon", "Guardian of the Crypt", 0, 6, 1, 300, 50, 30, 35);
				
				oracleVersusResult(true, boss1.equals(boss2));
				oracleVersusResult(false, boss1.equals(boss3));
				
						// Test for Enemy
				System.out.println(Message.ANSI_BLUE + "Test for Enemy" + Message.ANSI_RESET);
				
				Enemy enemy1 = new Enemy("Enemy 1", "EN", 100);
				Enemy enemy2 = new Enemy("Enemy 1", "EN", 100);
				Enemy enemy3 = new Enemy("Enemy 1", "EN", 10);
				
				oracleVersusResult(true, enemy1.equals(enemy2));
				oracleVersusResult(false, enemy1.equals(enemy3));
				
							// Test for Enemy objects with different classes
				System.out.println(Message.ANSI_BLUE + "Test for Enemy objects with different classes" + Message.ANSI_RESET);
				
				Monster monster1 = new Monster("Enemy 1", 100);
				EnemyWarrior enW1 = new EnemyWarrior("Enemy 1", 100);
				enW1.setType("Monster");
				
				oracleVersusResult(false, monster1.equals(enW1));
					
						// Test for Hero
				System.out.println(Message.ANSI_BLUE + "Test for Hero" + Message.ANSI_RESET);
				
				Hero hero1 = new Hero("Charles");
				LivingEntity liveE1 = new LivingEntity("Charles", "Hero");
				
				oracleVersusResult(false, hero1.equals(liveE1));
				
					// Test for Teleport
				System.out.println(Message.ANSI_BLUE + "Test for Teleport" + Message.ANSI_RESET);
				
				Teleport teleport1 = new Teleport("Waypoint", 1, 2, 3, 4);
				Teleport teleport2 = new Teleport("Waypoint", 1, 2, 3, 4);
				Teleport teleport3 = new Teleport("Waypoint", 1, 2, 4, 3);
				Teleport teleport4 = new Teleport("Waypoint", 2, 1, 3, 4);
				
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
				
				Chest chest1 = new Chest("Chest 1", 0, 0, weapon1);
				Chest chest2 = new Chest("Chest 1", 0, 0, weapon1);
				Chest chest3 = new Chest("Chest 1", 0, 0, weapon1, artifact1);
				
				oracleVersusResult(true, chest1.equals(chest2));
				oracleVersusResult(false, chest1.equals(chest3));

		
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
