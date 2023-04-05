package the_game;
import java.util.Random;

import the_game.create.*;
import the_game.action.*;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		// Map to test
		Create.setMapID(2);
		
		// Changing hero's coordinates
		// Situation : next to a teleport
		Hero hero = CreateHero.createHero();
		hero.setX(10);
		hero.setY(13);
		
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
