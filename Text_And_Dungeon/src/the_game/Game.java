package the_game;

import the_game.action.*;
import the_game.create.*;


/**
 * The main class of the game. Its execution triggers the start of the game.
 * @author Camille Girodengo
 *
 */
public class Game {
	
	public static String[] lastValidCommand = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		Message.welcome();
		Message.mapChoice();
		
		// All entities
		Hero hero = CreateHero.createHero();
		Wall[] walls = CreateWalls.placeWalls();
		Chest[] chests = CreateChests.placeChests();
		Teleport[] teleports = CreateTeleports.placeTeleports();
		Enemy[] enemies = CreateEnemies.spawnEnemies();
		Boss[] bosses = CreateBosses.spawBoss();
		
		// Declaring EventManager
		EventManager eventManager = new EventManager();
		
		Message.welcome2(Create.createMap(walls, chests, teleports, enemies, bosses, hero));
		
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

}
