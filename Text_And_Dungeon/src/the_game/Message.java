package the_game;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import the_game.create.Create;
/**
 * The class for all system outputs and inputs. Takes care of Player/Game interactions.
 * @author Camille Girodengo
 *
 */
public class Message {
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------COLORS--------------------------------- *
	 * -------------------------------------------------------------------- */
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------START MESSAGES------------------------- *
	 * -------------------------------------------------------------------- */
	
	public static void welcome() throws InterruptedException {
		System.out.print("Hello Player," + '\n');
		System.out.print("Just before you start your adventure in this this dungeon, here's some informations concerning the action system and the game." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print('\t' + "- For actions of the type \"Show\", \"Equip\" and \"Throw\", you must indicate the number associated with the item you want to select. This number can be found when looking at the inventory." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print('\t' + "- All actions can be typed in lower and upper case, the program can reconize the command in either case." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print('\t' + "- Be careful when you throw an item, it will be forever lost unless you restart the game" + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print('\t' + "- All artifacts and potions are randomly hidden in the chests of the map at each start of the game." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print('\t' + "- The hero gains a certain amount of EXP after defeating an enemy and can augment their stats through level uping." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print("That's all you need to know to play the game." + '\n');
		TimeUnit.SECONDS.sleep(1);
	}
	
	public static void mapChoice() {
		while(true) {
			System.out.print("Please choose a map : (enter map number)" + '\n');
			System.out.print('\t' + "1 : 20x20" + '\n');
			System.out.print('\t' + "2 : 50x50" + '\n');
			Scanner in = new Scanner(System.in);
			int mapNumberID = in.nextInt();
			if (mapNumberID > 0 && mapNumberID < 2 + 1) {
				Create.setMapID(mapNumberID);
				break;
			}
			else {
				Message.incorrectEntry();
			}
		}
	}
	
	public static void welcome2(char[][] map) {
		System.out.print("Here's the map to help you start :" + '\n' + '\n');
		Message.showMap(map);
		System.out.print("Have fun !" + '\n' + '\n');
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------PREDETERMINED MESSAGES------------------------ *
	 * -------------------------------------------------------------------- */
	
	public static void incorrectEntry() {
		System.out.print("Incorrect entry, please retry." + '\n');
	}
	public static void notRecognized(){
		System.out.print("Command not recognized" + '\n' + '\n');
	}
	public static void notExists(String entity){
		System.out.print(entity + " does not exist" + '\n' + '\n');
	}
	public static void notSpecified(String entity){
		System.out.print(entity + " not specified" + '\n' + '\n');
	}
	public static void attacks(LivingEntity attacker, LivingEntity attacked, int damage){
		System.out.print(attacker.getFullName() + " attacks " + attacked.getFullName() + ". " + '\n');
		if (damage == 1) {
			System.out.print("Glancing Blow. " + '\n');
		}
		System.out.print(attacked.getFullName() + " receives " + damage + " damage. Health Points remaining : ");
		if (attacked.getHP() < 0) {
			System.out.print(0);
		}
		else {
			System.out.print(attacked.getHP());
		}
		System.out.print(" HP." + '\n' + '\n');
	}
	public static void isKO(LivingEntity liveEntity) {
		System.out.print(liveEntity.getFullName() + " has been vanquished." + '\n' + '\n');
	}
	public static void moves(char direction, LivingEntity liveEntity) {
		System.out.printf(liveEntity.getFullName() + " moves ");
		if (direction == 'z') {
			System.out.printf("up.");
		}
		else if (direction == 's') {
			System.out.printf("down.");
		}
		else if (direction == 'q') {
			System.out.printf("to the left.");
		}
		else if (direction == 'd') {
			System.out.printf("to the right.");
		}
		else {
			System.out.printf("?.");
		}
		System.out.print('\n' + "New coordinates : x=" + liveEntity.getX() + " y=" + liveEntity.getY() + '\n' + '\n');
	}
	public static void showItem(Item item) {
		System.out.print(item.toString() + '\n' + '\n');
	}
	public static void showTeleport(Teleport teleport) {
		System.out.print(teleport.toString() + '\n' + '\n');
	}
	public static void showInventory(Hero hero) {
		System.out.print(hero.getInventory().toString() + '\n' + '\n');
	}
	public static void showHero(Hero hero) {
		System.out.print(hero.toString() + '\n' + '\n');
	}
	public static void getItem(Hero hero, Item item) {
		System.out.print(hero.getFullName() + " takes the item " + item.getName() + " of class " + item.getType() + "." + '\n' + '\n');
	}
	public static void cannotGetItem(Hero hero, Item item) {
		System.out.print(hero.getFullName() + "'s inventory is full. Cannot take " + item.getFullName() +"." +'\n' + '\n');
	}
	public static void throwItem(Hero hero, Item item) {
		System.out.print(hero.getFullName() + " throws the item " + item.getName() + "." + '\n' + '\n');
	}
	public static void cannotThrowItem(Hero hero, Item item) {
		System.out.print("Item " + item.getFullName() + " cannot be thrown for it is currently equipped to " + hero.getFullName() + "." + '\n' + '\n');
	}
	public static void equips(Hero hero, Item item) {
		System.out.print(hero.getFullName() + " equips " + item.getFullName() + "." + '\n' + '\n');
	}
	public static void unEquips(Hero hero, Item item) {
		System.out.print(hero.getFullName() + " unequips " + item.getFullName() + "." + '\n' + '\n');
	}
	public static void usesPotion(Hero hero, Potion potion, int hpRestored) {
		System.out.print(hero.getFullName() + " uses " + potion.getFullName() + ". " + hpRestored + " HP restored." + '\n' + '\n');
	}
	public static void openChest(Hero hero, Chest chest) {
		System.out.print(hero.getFullName() + " opens a " + chest.getType() + "." + '\n' + '\n');
	}
	public static void enterFight(Hero hero) {
		System.out.print(hero.getFullName() + " enters a fight." + '\n' + '\n');
	}
	public static void exitsFight(Hero hero) {
		System.out.print(hero.getFullName() + " exits the fight." + '\n' + '\n');
	}
	public static void notValid(String elementNotValid) {
		System.out.print(elementNotValid + " not valid. Please try another " + elementNotValid.toLowerCase() + "." + '\n' + '\n');
	}
	public static void nextLevel(Hero hero) {
		System.out.print(hero.getFullName() + " has reached level " + hero.getLevel() + "." + '\n' + '\n');
	}
	public static void checkEnemy(Enemy enemy) {
		System.out.print(enemy.toString() + '\n' + '\n');
	}
	public static void showBoss(Boss boss) {
		System.out.print(boss.toString() + '\n' + '\n');
	}
	public static void showMap(char[][] map) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j] == 'X' || map[i][j] == ' ') { // In Default color
					System.out.print(map[i][j]);
				}
				else if (map[i][j] == 'C') { // In Green
					System.out.print(ANSI_GREEN + map[i][j] + ANSI_RESET);
				}
				else if (map[i][j] == 'E') { // In Yellow
					System.out.print(ANSI_YELLOW + map[i][j] + ANSI_RESET);
				}
				else if (map[i][j] == 'B') { // In Red
					System.out.print(ANSI_RED + map[i][j] + ANSI_RESET);
				}
				else if (map[i][j] == 'H') { // In Light Blue
					System.out.print(ANSI_CYAN + map[i][j] + ANSI_RESET);
				}
				else if (map[i][j] == 'T') { // In Blue
					System.out.print(ANSI_BLUE + map[i][j] + ANSI_RESET);
				}
				System.out.print(" ");
			}
			System.out.print('\n');
		}
		System.out.print('\n');
	}
	public static void dungeonConquered(Hero hero) {
		System.out.print(hero.getFullName() + " conquered the dungeon !" + '\n' + '\n');
		System.out.print("YOU WIN" + '\n');
	}
	public static void notDungeonConquered(Hero hero) {
		System.out.print(hero.getFullName() + " was defeated inside the dungeon and could not conquer the dungeon..." + '\n');
		System.out.print("GAME OVER" + '\n');
	}
	public static void usesTeleport(Hero hero, Teleport teleport, int newNumTerminal) {
		System.out.print(hero.getFullName() + " uses " + teleport.getFullName() + "." + '\n');
		System.out.print(hero.getFullName() + " is now on Terminal " + newNumTerminal + " of " + teleport.getFullName() + ". ");
		System.out.print("New coordinates : (" + hero.getX() + ", " + hero.getY() + ")" + '\n');
	}
	
	
	/* -------------------------------------------------------------------- *
	 * --------------------------COMMANDS MESSAGES------------------------- *
	 * -------------------------------------------------------------------- */
	
	
	// Records the command and put it to lower case.
	// Does not support multiple spaces separation between words
	public static String[] registerCommand(int nbWords) {
		
		Scanner in = new Scanner(System.in);
		String action = in.nextLine();
		
		String[] command = action.split(" ", nbWords);
		for (int i = 0; i < command.length; ++i) {
			command[i] = command[i].toLowerCase();
		}
		System.out.print('\n');
//		in.close();
		return command;
	}
	
	
	public static void showActions(String[] actions, int nbActionsPerLine, int spacing) {
		System.out.print("Actions available :" + '\n');
		String space = " ";
		// For an aligned print of the actions
		int maxLetters = 8;
		for (String action : actions) {
			maxLetters = Math.max(maxLetters, action.length());
		}
		// Printing the actions
		int count = 0;
		for (String action : actions) {
			System.out.print("- " + action);
			++count;
			if (count != nbActionsPerLine) {
				System.out.print(space.repeat((maxLetters + 1) - action.length()%(maxLetters + 1)));
				System.out.print(space.repeat(spacing));
			}
			else {
				System.out.print('\n');
				count = 0;
			}
		}
		System.out.print('\n');
		System.out.print('\n');
		
	}
	
	public static String characterNaming() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please name your hero character : ");
		String name = in.nextLine();
		System.out.print('\n');
//		in.close();
		return name;
	}
	
	public static boolean confirmAction(String action) {
		boolean confirm;
		while (true) {
			System.out.print("Please confirm following action : \"" + action + "\" [yes]/[no]" + '\n');
			Scanner in = new Scanner(System.in);
			String answer = in.next().toLowerCase();
			if (answer.equals("yes")) {
				confirm = true;
				break;
			}
			else if (answer.equals("no")) {
				confirm = false;
				break;
			}
			else {
				Message.incorrectEntry();
			}
		}
		return confirm;
	}
	
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------SPECIAL MESSAGES------------------------- *
	 * -------------------------------------------------------------------- */

	public static void voidAttack(Hero hero, int voidAttackCount, Event event) throws InterruptedException {
		if (voidAttackCount < 3 && event.getIntermediaryEvents().get(0).isTriggered() == false) {
			System.out.print(hero.getFullName() + " attacks nothing ?" + '\n' + '\n');
			event.getIntermediaryEvents().get(0).triggerNextIntermediaryEvent(); // Trigger the (n-1) event in the intermediary event list of IE 0
			if (event.getIntermediaryEvents().get(0).canBeTriggered()) {
				event.triggerNextIntermediaryEvent(); // All IE of IE 0 have been triggered so IE 0 should be triggered
			}
		}
		else if (voidAttackCount == 3 && event.getIntermediaryEvents().get(1).isTriggered() == false) {
			System.out.print(hero.getFullName() + " attacks Nothing." + '\n' + '\n');
			if (event.getIntermediaryEvents().get(1).canBeTriggered()) {
				event.triggerNextIntermediaryEvent();
			}
		}
		else if (voidAttackCount == 4 && event.getIntermediaryEvents().get(2).isTriggered() == false) {
			System.out.print(hero.getFullName() + " attacks the Nothing." + '\n' + '\n');
			if (event.getIntermediaryEvents().get(2).canBeTriggered()) {
				event.triggerNextIntermediaryEvent();
			}
		}
		else if (voidAttackCount == 5 && event.getIntermediaryEvents().get(3).isTriggered() == false) {
			System.out.print(hero.getFullName() + " attacks the Unknown." + '\n' + '\n');
			if (event.getIntermediaryEvents().get(3).canBeTriggered()) {
				event.triggerNextIntermediaryEvent();
			}
		}
		else if (voidAttackCount == 6 && event.getIntermediaryEvents().get(4).isTriggered() == false) {
			System.out.print(hero.getFullName() + " attacks the void." + '\n' + '\n');
			
			for (int i = 0; i < 5; ++i) {
				TimeUnit.SECONDS.sleep(1);
				System.out.print(". ");
			}
			
			TimeUnit.SECONDS.sleep(2);
			
			System.out.print('\n' + "The  V O I D  reaches out..." + '\n' + '\n');
			
			TimeUnit.SECONDS.sleep(2);
			
			if (event.getIntermediaryEvents().get(4).canBeTriggered()) {
				event.triggerNextIntermediaryEvent();
			}
		}
	}
	
	public static void WarningEnemiesDownCount(int sumEnemiesDown, Enemy[] enemies, Boss[] bosses, Event event) throws InterruptedException {
		if (sumEnemiesDown == enemies.length / 4) {
			event.triggerNextIntermediaryEvent();
			System.out.println("The wind is starting to grow stronger.");
		}
		else if (sumEnemiesDown == enemies.length / 2) {
			event.triggerNextIntermediaryEvent();
			System.out.println("Menacing clouds are invading the sky.");
		}
		else if (sumEnemiesDown == enemies.length - (enemies.length / 4)) {
			event.triggerNextIntermediaryEvent();
			System.out.print("The surrondings are getting darker");
			for (int numPeriod = 0; numPeriod < 3; ++numPeriod) {
				System.out.print(".");
				TimeUnit.SECONDS.sleep(1);
			}
			System.out.print('\n');
			System.out.println("Seems like something is coming...");
		}
		else if (sumEnemiesDown == enemies.length) {
			event.triggerNextIntermediaryEvent();
			for (int numPeriod = 0; numPeriod < 10; ++numPeriod) {
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(500);
			}
			System.out.println('\n' + bosses[0].getFullName() + " has fled !");
			System.out.println("The true master of the place, " + bosses[1].getFullName() + " has appeared !");
		}
	}
	
	public static void voidEntry(Hero hero, Boss boss) throws InterruptedException {
		System.out.print(hero.getFullName() + " enters the void." + '\n');
		TimeUnit.SECONDS.sleep(2);
		System.out.print(boss.getName() + ", " + boss.getTitle() + " watches." + '\n' + '\n');
	}
	
	public static void bossPhaseActivation(Hero hero, Boss boss) {
		if (boss.getCurrentPhase() == 1) {
			System.out.print(hero.getFullName() + " faces " + boss.getFullName() + "." + '\n');
			System.out.print("A magical barrier appears." + '\n');
			System.out.print("The last Battle begins !" + '\n' + '\n');
		}
		else {
			System.out.print(boss.getFullName() + " still has some energy left ! Initialisation of phase " + boss.getCurrentPhase() + ".");
		}
	}
	
	public static void hiddenBossPhaseActivation(Hero hero, Boss boss) throws InterruptedException {
		if (Create.getMapID() == 1) {
			if (boss.getCurrentPhase() == 1) {
				System.out.print(hero.getFullName() + " faces " + boss.getFullName() + "." + '\n');
				System.out.print("The  -  last  -  Battle  -  begins !" + '\n' + '\n');
			}
			else if (boss.getCurrentPhase() == 2) {
				System.out.print(boss.getFullName() + " is down !" + '\n');
				System.out.print("Or is it really ? ");
				TimeUnit.SECONDS.sleep(3);
				for (int numPeriod = 0; numPeriod < 3; ++numPeriod) {
					System.out.print(".");
					TimeUnit.SECONDS.sleep(1);
				}
				TimeUnit.SECONDS.sleep(2);
				System.out.print(" " + boss.getName() + " is getting up !" + '\n');
				System.out.print(boss.getName() + " is still recovering from the assault ! Strike it down before it can get back to its full strength !" + '\n' + "Be brave Hero, this is the final push !" + '\n' + '\n');
			}
		}
		else if (Create.getMapID() == 2) {
			if (boss.getCurrentPhase() == 1) {
				System.out.print("UwU " + hero.getFullName() + " faces " + boss.getFullName() + ". UwU" + '\n');
				System.out.print("The last Battle begins ! >w<" + '\n' + '\n');
			}
		}
	}
	
	public static void antiVoidIncantation(Hero hero, Boss boss) throws InterruptedException {
		System.out.print(hero.getFullName() + " calls for the anti-void." + '\n');
		TimeUnit.SECONDS.sleep(1);
		System.out.print("A N T I - V O I D  answers the call." + '\n');
		System.out.print(boss.getName() + " ' stats are decreased !" + '\n');
		System.out.print(hero.getFullName() + " is fully healed." + '\n' + '\n');
	}
	
	public static void bossDefeated(Boss boss) {
		System.out.print(boss.getName() + " collapses. " + boss.getTitle() + " has been slayed." + '\n' + '\n');
	}
	
}
