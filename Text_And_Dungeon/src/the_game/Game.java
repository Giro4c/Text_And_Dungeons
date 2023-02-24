package the_game;
/**
 * The main class of the game. Its execution triggers the start of the game.
 * @author Camille Girodengo
 *
 */
public class Game {
	
	public static void main(String[] args) throws InterruptedException {
		int[][] walls = Create.placeWalls();
//		--- Not necessary ----
//		Weapon[] weapons = Create.createWeapons();
//		Artifact[] artifacts = Create.createArtifacts();
//		Potion[] potions = Create.createPotions();
//		--- ------------- ----
		Chest[] chests = Create.placeChests();
		Enemy[] enemies = Create.spawnEnemies();
		Boss[] bosses = Create.spawBoss();
		
		Message.welcome();
		Hero hero = new Hero(Message.characterNaming(), 1, 15, 100, 30, 15, 20);
		// Start coordinates for hero : 1, 15
		Message.welcome2(Create.createMap(walls, chests, enemies, bosses, hero));
		
		boolean inFight = false;
		boolean isHeroTurn = true;
		
		while (true) {
			if (inFight == false) {
				Message.showActions(Action.passiveActions(Action.evaluateAvailablePassiveActions(hero, walls, chests, Action.notFinalPassiveActions())), 2, 7);
				System.out.print("What will you do ?" + '\n');
				String[] command = Message.registerCommand(4);
				Action.executePassiveCommand(command, hero, walls, chests, enemies, bosses);
				Action.checkHeroLocation(hero, bosses);
				if (hero.isEnemyAround(enemies, bosses) == true) {
					inFight = true;
					Message.enterFight(hero);
				}
			}
			else { // inFight == true
				if (hero.getSpecialLocation() == 1) {
					Action.specialBossFight(hero, bosses[1]);
					break;
				}
				Action.enemiesAttack(hero, enemies, bosses, hero.getSpeed() + 1, Action.maxSpeedEnemies(hero.whoIsAround(enemies, bosses), enemies, bosses));
				if (hero.getHP() <= 0) {
					break;
				}
				isHeroTurn = true;
				
				while (isHeroTurn == true) {
					Message.showActions(Action.fightActions(hero.whoIsAround(enemies, bosses)), 2, 7);
					System.out.print("What will you do ?" + '\n');
					String[] command = Message.registerCommand(3);
					isHeroTurn = Action.executeFightCommand(command, hero, walls, chests, enemies, bosses);
				}
				if (Action.isBossDown(bosses[0]) == true) {
					break;
				}
				if (hero.isEnemyAround(enemies, bosses) == false) {
					inFight = false;
					Message.exitsFight(hero);
					continue;
				}
				Action.enemiesAttack(hero, enemies, bosses, 0, hero.getSpeed());
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
