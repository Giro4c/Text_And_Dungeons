package the_game;

import the_game.action.*;

/**
 * The main class of the game. Its execution triggers the start of the game.
 * @author Camille Girodengo
 *
 */
public class Game {
	
	public static void main(String[] args) throws InterruptedException {
		
		Message.welcome();
		Message.mapChoice();
		
		Hero hero = Create.createHero();
		int[][] walls = Create.placeWalls();
//		--- Not necessary ----
//		Weapon[] weapons = Create.createWeapons();
//		Artifact[] artifacts = Create.createArtifacts();
//		Potion[] potions = Create.createPotions();
//		--- ------------- ----
		Chest[] chests = Create.placeChests();
		Enemy[] enemies = Create.spawnEnemies();
		Boss[] bosses = Create.spawBoss();
		
		Message.welcome2(Create.createMap(walls, chests, enemies, bosses, hero));
		
		boolean inFight = false;
		boolean isHeroTurn = true;
		
		while (true) {
			if (inFight == false) {
				Message.showActions(PassiveAction.passiveActions(PassiveAction.evaluateAvailablePassiveActions(hero, walls, chests, PassiveAction.notFinalPassiveActions())), 2, 7);
				System.out.print("What will you do ?" + '\n');
				String[] command = Message.registerCommand(4);
				PassiveAction.executePassiveCommand(command, hero, walls, chests, enemies, bosses);
				SpecialAction.checkHeroLocation(hero, bosses);
				if (hero.isEnemyAround(enemies, bosses) == true) {
					inFight = true;
					Message.enterFight(hero);
				}
			}
			else { // inFight == true
				if (hero.getSpecialLocation() == 1) {
					SpecialAction.specialBossFight(hero, bosses[1]);
					break;
				}
				FightAction.enemiesAttack(hero, enemies, bosses, hero.getSpeed() + 1, FightAction.maxSpeedEnemies(hero.whoIsAround(enemies, bosses), enemies, bosses));
				if (hero.getHP() <= 0) {
					break;
				}
				isHeroTurn = true;
				
				while (isHeroTurn == true) {
					Message.showActions(FightAction.fightActions(hero.whoIsAround(enemies, bosses)), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(3);
					isHeroTurn = FightAction.executeFightCommand(command, hero, walls, chests, enemies, bosses);
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

}
