import java.util.Random;
/**
 * A class which creates all that is necessary for the game : walls, chests, enemies, bosses, weapons, artifacts, potions, map.
 * Also includes the attributes of the map (dungeon) : width, length, map ID which are all accessible without a class instantiation.
 * @author Camille (HorsCo)
 *
 */
public class Create {
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Not used in this version of the game but can be used for future improvement and implementation of new maps
	 */
	private static int mapID = 1;
	
	/**
	 * Represents the length of the map (the number of lines).<br>
	 * Can only be modified inside of the class Create. Can however be read outside of it through get method.
	 */
	private static int mapLength = 20;
	/**
	 * Represents the width of the map (the number of columns).<br>
	 * Can only be modified inside of the class Create. Can however be read outside of it through get method.
	 */
	private static int mapWidth = 20;
	
	public static int getMapID() {
		return mapID;
	}

	public static void setMapID(int mapID) {
		Create.mapID = mapID;
		if (mapID == 1) {
			mapLength = 20;
			mapWidth = 20;
		}
		/* Can add other mapIDs. 
		 * If so, think to add if condition to all create methods to create the arrays associated with the map array instead of the default ones (default == 1)
		 */
		
	}

	public static int getMapLength() {
		return mapLength;
	}

	public static int getMapWidth() {
		return mapWidth;
	}


	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Create a Weapon array which contains all the weapons of the game
	 * @return a Weapon array which contains all the weapons of the game
	 */
	public static Weapon[] createWeapons() {
		Weapon[] weapons = new Weapon[15];
		String[] statsN = {"Attack"};
		int[] statsV = {3};
		weapons[0] = new Weapon("Iron Sword", statsN.clone(), statsV.clone());
		statsV[0] = 25;
		weapons[1] = new Weapon("Skyward Sword", statsN.clone(), statsV.clone());
		statsV[0] = 15;
		weapons[2] = new Weapon("WindCutter", statsN.clone(), statsV.clone());
		statsV[0] = 20;
		weapons[3] = new Weapon("Strange Katana", statsN.clone(), statsV.clone());
		statsN = new String[2];
		statsV = new int[2];
		statsN[0] = "Attack";
		statsN[1] = "Speed";
		statsV = new int[2];
		statsV[0] = 15;
		statsV[1] = 2;
		weapons[4] = new Weapon("Polar Star Bow", statsN.clone(), statsV.clone());
		statsV[0] = 7;
		statsV[1] = 15;
		weapons[5] = new Weapon("Lunar Bow", statsN.clone(), statsV.clone());
		statsV[0] = 8;
		statsV[1] = 8;
		weapons[6] = new Weapon("Hunter Bow ", statsN.clone(), statsV.clone());
		statsN[1] = "Defense";
		statsV[0] = 18;
		statsV[1] = 2;
		weapons[7] = new Weapon("Obsidian Twin Blades", statsN.clone(), statsV.clone());
		statsN = new String[3];
		statsV = new int[3];
		statsN[0] = "Attack";
		statsN[1] = "Defense";
		statsN[2] = "Speed";
		statsV[0] = 30;
		statsV[1] = -5;
		statsV[2] = -7;
		weapons[8] = new Weapon("Gold Hammer", statsN.clone(), statsV.clone());
		statsV[0] = 15;
		statsV[1] = -3;
		statsV[2] = 10;
		weapons[9] = new Weapon("Guardian Lance", statsN.clone(), statsV.clone());
		statsV[0] = 20;
		statsV[1] = -4;
		statsV[2] = -5;
		weapons[10] = new Weapon("Solar Claymore", statsN.clone(), statsV.clone());
		statsV[0] = 2;
		statsV[1] = 2;
		statsV[2] = 2;
		weapons[11] = new Weapon("Writting Pencil", statsN.clone(), statsV.clone());
		statsV[0] = 10;
		statsV[1] = 5;
		statsV[2] = -5;
		weapons[12] = new Weapon("Crystal Broadsword", statsN.clone(), statsV.clone());
		statsV[0] = 17;
		statsV[1] = -1;
		statsV[2] = 8;
		weapons[13] = new Weapon("Legendary Lance", statsN.clone(), statsV.clone());
		statsV[0] = 23;
		statsV[1] = -7;
		statsV[2] = -10;
		weapons[14] = new Weapon("Tenebrous Hammer", statsN.clone(), statsV.clone());
		
		return weapons;
	}
	
	/**
	 * Create a Artifact array which contains all the artifacts of the game
	 * @return a Artifact array which contains all the artifacts of the game
	 */
	public static Artifact[] createArtifacts() {
		Artifact[] artifacts = new Artifact[15];
		String[] statsN = {"HP"};
		int[] statsV = {30};
		artifacts[0] = new Artifact("Soul Stone", statsN.clone(), statsV.clone());
		statsN = new String[2];
		statsV = new int[2];
		statsN[1] = "Attack";
		statsN[0] = "Speed";
		statsV[0] = 5;
		statsV[1] = 5;
		artifacts[1] = new Artifact("WindBlume Feather", statsN.clone(), statsV.clone());
		statsV[0] = 6;
		statsV[1] = 6;
		artifacts[2] = new Artifact("Electroculus Crystal", statsN.clone(), statsV.clone());
		statsV[0] = 3;
		statsV[1] = 7;
		artifacts[3] = new Artifact("ThunderWrath SandClock", statsN.clone(), statsV.clone());
		statsN[1] = "HP";
		statsN[0] = "Defense";
		statsV[0] = 20;
		statsV[1] = 7;
		artifacts[4] = new Artifact("Guardian's Mask", statsN.clone(), statsV.clone());
		statsV[0] = 10;
		statsV[1] = 8;
		artifacts[5] = new Artifact("Gladiator Helmet", statsN.clone(), statsV.clone());
		statsV[0] = 20;
		statsV[1] = 8;
		artifacts[6] = new Artifact("Amulet of the Mysterious Golden Temples", statsN.clone(), statsV.clone());
		statsN[0] = "Attack";
		statsV[0] = 7;
		statsV[1] = 5;
		artifacts[7] = new Artifact("Ancient Manuscrit", statsN.clone(), statsV.clone());
		statsV[0] = 7;
		statsV[1] = 7;
		artifacts[8] = new Artifact("Power Stone", statsN.clone(), statsV.clone());
		statsN[1] = "Defense";
		statsN[0] = "Speed";
		statsV[0] = 8;
		statsV[1] = 2;
		artifacts[9] = new Artifact("Lost Relic of Meldafeh ", statsN.clone(), statsV.clone());
		statsN = new String[3];
		statsV = new int[3];
		statsN[0] = "HP";
		statsN[1] = "Attack";
		statsN[2] = "Defense";
		statsV[0] = 30;
		statsV[1] = 10;
		statsV[2] = -10;
		artifacts[10] = new Artifact("Anti-void Essence", statsN.clone(), statsV.clone());
		statsN = new String[4];
		statsV = new int[4];
		statsN[0] = "HP";
		statsN[1] = "Attack";
		statsN[2] = "Defense";
		statsN[3] = "Speed";
		statsV[0] = 10;
		statsV[1] = 5;
		statsV[2] = 4;
		statsV[3] = 6;
		artifacts[11] = new Artifact("Watching Eye of the Fallen Kingdom", statsN.clone(), statsV.clone());
		statsV[0] = 25;
		statsV[1] = 10;
		statsV[2] = 10;
		statsV[3] = 10;
		artifacts[12] = new Artifact("Incomplete Infinity Gautlet", statsN.clone(), statsV.clone());
		statsV[0] = 1;
		statsV[1] = 1;
		statsV[2] = 2;
		statsV[3] = 10;
		artifacts[13] = new Artifact("Chosen's Artifact", statsN.clone(), statsV.clone());
		statsV[0] = 5;
		statsV[1] = 5;
		statsV[2] = -5;
		statsV[3] = 2;
		artifacts[14] = new Artifact("Ruby Flower", statsN.clone(), statsV.clone());
		
		return artifacts;
	}
	
	/**
	 * Create a Potion array which contains all the potions of the game
	 * @return a Potion array which contains all the potions of the game
	 */
	public static Potion[] createPotions() {
		Potion[] potions = new Potion[15];
		String[] statsN = {"HP"};
		int[] statsV = {5};
		potions[0] = new Potion("Dubvious Water", statsN, statsV.clone());
		statsV[0] = 8;
		potions[1] = new Potion("Inferior Healing", statsN, statsV.clone());
		statsV[0] = 10;
		potions[2] = new Potion("Small Healing", statsN, statsV.clone());
		potions[3] = new Potion("Medicine Vial", statsN, statsV.clone());
		statsV[0] = 15;
		potions[4] = new Potion("Potion of Unknown Origin", statsN, statsV.clone());
		statsV[0] = 20;
		potions[5] = new Potion("Pure Lake Water", statsN, statsV.clone());
		potions[6] = new Potion("Medium Healing", statsN, statsV.clone());
		statsV[0] = 25;
		potions[7] = new Potion("Witch Brew", statsN, statsV.clone());
		statsV[0] = 30;
		potions[8] = new Potion("Azuroth's Tears", statsN, statsV.clone());
		potions[9] = new Potion("Almadyth's Tears", statsN, statsV.clone());
		potions[10] = new Potion("Avuleth's Tears", statsN, statsV.clone());
		statsV[0] = 35;
		potions[11] = new Potion("Superior Healing", statsN, statsV.clone());
		statsV[0] = 50;
		potions[12] = new Potion("Fairy in a Bottle", statsN, statsV.clone());
		statsV[0] = 75;
		potions[13] = new Potion("Godness' Blessing", statsN, statsV.clone());
		statsV[0] = 150;
		potions[14] = new Potion("Liquid Life", statsN, statsV.clone());
		
		return potions;
	}
	
	/**
	 * Create an array of int arrays which contains the location of all the walls of the map except the borders.
	 * @return a <code>int[][]</code> which contains the location of all the walls of the map except the borders
	 */
	public static int[][] placeWalls(){
		int[][] walls = new int[33][2];
		// All the walls that are not extremities :
		walls[0][0] = 1;
		walls[0][1] = 1;
		
		walls[1][0] = 1;
		walls[1][1] = 14;
		
		walls[2][0] = 1;
		walls[2][1] = 16;
		
		walls[3][0] = 5;
		walls[3][1] = 12;
		
		walls[4][0] = 5;
		walls[4][1] = 11;
		
		walls[5][0] = 5;
		walls[5][1] = 18;
		
		walls[6][0] = 6;
		walls[6][1] = 12;
		
		walls[7][0] = 6;
		walls[7][1] = 11;
		
		walls[8][0] = 6;
		walls[8][1] = 17;
		
		walls[9][0] = 7;
		walls[9][1] = 17;
		
		walls[10][0] = 8;
		walls[10][1] = 17;
		
		walls[11][0] = 9;
		walls[11][1] = 17;
		
		walls[12][0] = 10;
		walls[12][1] = 17;
		
		walls[13][0] = 11;
		walls[13][1] = 18;
		
		walls[14][0] = 12;
		walls[14][1] = 1;
		
		walls[15][0] = 12;
		walls[15][1] = 18;
		
		walls[16][0] = 13;
		walls[16][1] = 2;
		
		walls[17][0] = 14;
		walls[17][1] = 3;
		
		walls[18][0] = 14;
		walls[18][1] = 4;
		
		walls[19][0] = 14;
		walls[19][1] = 5;
		
		walls[20][0] = 14;
		walls[20][1] = 13;
		
		walls[21][0] = 15;
		walls[21][1] = 6;
		
		walls[22][0] = 15;
		walls[22][1] = 12;
		
		walls[23][0] = 15;
		walls[23][1] = 13;
		
		walls[24][0] = 16;
		walls[24][1] = 7;
		
		walls[25][0] = 16;
		walls[25][1] = 12;
		
		walls[26][0] = 16;
		walls[26][1] = 14;
		
		walls[27][0] = 17;
		walls[27][1] = 7;
		
		walls[28][0] = 17;
		walls[28][1] = 12;
		
		walls[29][0] = 17;
		walls[29][1] = 14;
		
		walls[30][0] = 18;
		walls[30][1] = 7;
		
		walls[31][0] = 18;
		walls[31][1] = 12;
		
		walls[32][0] = 18;
		walls[32][1] = 14;
		
		return walls;
	}
	
	/**
	 * Create a Chest array which contains all the chests of this map.<br>
	 * All artifacts and potions in the chests are random.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Chest array which contains all the chests of this map
	 */
	public static Chest[] placeChests() {
		Weapon[] weapons = createWeapons();
		Artifact[] artifacts = (Artifact[]) shuffleItemArray(createArtifacts());
		Potion[] potions = (Potion[]) shuffleItemArray(createPotions());
		Chest[] chests = new Chest[15];
		chests[0] = new Chest("Chest 1", 1, 6, weapons[8], artifacts[0], potions[0]);
		chests[1] = new Chest("Chest 2", 2, 18, weapons[12], artifacts[1], potions[1]);
		chests[2] = new Chest("Chest 3", 7, 11, weapons[13], artifacts[2], potions[2]);
		chests[3] = new Chest("Chest 4", 7, 12, weapons[10], artifacts[3], potions[3]);
		chests[4] = new Chest("Chest 5", 17, 18, weapons[1], artifacts[4], potions[4]);
		chests[5] = new Chest("Chest 6", 18, 8, weapons[3], artifacts[5], potions[5]);
		chests[6] = new Chest("Chest 7", 2, 14, weapons[0], artifacts[6], potions[6]);
		chests[7] = new Chest("Chest 8", 9, 7, weapons[14], artifacts[7], potions[7]);
		chests[8] = new Chest("Chest 9", 11, 6, weapons[4], artifacts[8], potions[8]);
		chests[9] = new Chest("Chest 10", 11, 17, weapons[5], artifacts[9], potions[9]);
		chests[10] = new Chest("Chest 11", 1, 10, weapons[2], artifacts[10], potions[10]);
		chests[11] = new Chest("Chest 12", 18, 10, weapons[7], artifacts[11], potions[11]);
		chests[12] = new Chest("Chest 13", 18, 11, weapons[6], artifacts[12], potions[12]);
		chests[13] = new Chest("Chest 14", 18, 15, weapons[9], artifacts[13], potions[13]);
		chests[14] = new Chest("Chest 15", 11, 14, weapons[11], artifacts[14], potions[14]);
		
		return chests;
	}
	
	/**
	 * Create a Boss array which contains all the bosses of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Boss array which contains all the bosses of this map
	 */
	public static Boss[] spawBoss() {
		Boss[] bosses = new Boss[2];
		bosses[0] = new Boss("Dragon Cirk", "dungeon", "Destroyer of the Holy Land", 6, 1, 300, 50, 30, 35);
		bosses[1] = new Boss("V O I D    E T E R N Y S", "Hidden", "Incarnation of the void", -1, -1, 500, 120, 60, 999); // Does not appear on the map unless engages in a fight
		return bosses;
	}
	
	/**
	 * Create a Enemy array which contains all the enemies of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Enemy array which contains all the enemies of this map
	 */
	public static Enemy[] spawnEnemies() {
		Enemy[] enemies = new Enemy[26];
		enemies[0] = new Monster("Monglr 1", 17, 17, 25, 20, 20, 15, 50);
		enemies[1] = new Monster("Monglr 2", 15, 10, 25, 20, 20, 15, 50);
		enemies[2] = new Monster("Slime 1", 14, 15, 10, 10, 10, 10, 30);
		enemies[3] = new Monster("Slime 2", 11, 4, 10, 10, 10, 10, 30);
		enemies[4] = new Monster("Altriss 1", 3, 3, 50, 30, 15, 30, 100);
		enemies[5] = new Monster("Altriss 2", 6, 3, 50, 30, 15, 30, 100);
		enemies[6] = new Monster("Altriss 3", 9, 3, 50, 30, 15, 30, 100);
		enemies[7] = new Monster("Typhru 1", 1, 5, 40, 23, 15, 30, 30);
		enemies[8] = new Monster("Typhru 2", 1, 7, 40, 23, 15, 30, 30);
		enemies[9] = new Monster("Typhru 3", 2, 6, 40, 23, 15, 30, 30);
		enemies[10] = new Monster("Talphru 1", 2, 5, 60, 30, 25, 30, 50);
		enemies[11] = new Monster("Talphru 2", 2, 7, 60, 30, 25, 30, 50);
		enemies[12] = new Monster("Slime 3", 3, 18, 10, 10, 10, 10, 30);
		enemies[13] = new Monster("Slime 4", 4, 16, 10, 10, 10, 10, 30);
		enemies[14] = new Monster("Slime 5", 4, 18, 10, 10, 10, 10, 30);
		enemies[15] = new Monster("Monglr 3", 14, 9, 25, 20, 20, 15, 50);
		enemies[16] = new Monster("Altriss 4", 15, 18, 50, 30, 15, 30, 100);
		enemies[17] = new Monster("Venna 1", 16, 8, 35, 20, 15, 22, 50);
		enemies[18] = new EnemyWarrior("Goliath", 8, 11, 80, 25, 15, 15, 65);
		enemies[19] = new EnemyWarrior("Gladius", 8, 12, 80, 25, 15, 15, 65);
		enemies[20] = new EnemyWarrior("Archibald", 7, 10, 100, 20, 30, 12, 65);
		enemies[21] = new EnemyWarrior("Maximilian", 7, 13, 100, 20, 30, 12, 65);
		enemies[22] = new EnemyWarrior("Lysandre", 7, 7, 80, 25, 15, 15, 65);
		enemies[23] = new EnemyWarrior("Cornelius", 8, 6, 100, 20, 30, 12, 65);
		enemies[24] = new EnemyWarrior("Agatha", 10, 14, 120, 40, 5, 35, 100);
		enemies[25] = new EnemyWarrior("Catherin", 12, 17, 120, 40, 5, 35, 100);
		
		return enemies;
	}
	
	/**
	 * Swaps two items in an item array
	 * @param items a Item array in which to switch the two items
	 * @param index1 the index of the first item
	 * @param index2 the index of the second item
	 */
	public static void swapItems(Item[] items, int index1, int index2) {
		Item container = items[index1];
		items[index1] = items[index2];
		items[index2] = container;
	}
	
	/**
	 * Shuffle an item array at random
	 * @param items the Item array to shuffle
	 * @return a shuffled Item array
	 */
	public static Item[] shuffleItemArray(Item[] items) {
		Random rand = new Random();
		int randIndex;
		for (int i = 0; i < items.length; ++i) {
			randIndex = rand.nextInt(items.length);
			swapItems(items, i, randIndex);
		}
		return items;
	}
	
	
/* -------------------------------------------------------------------- *
 * ---------------------------MAP CREATION----------------------------- *
 * -------------------------------------------------------------------- */
	
	/**
	 * Converts a char array into an array of char arrays
	 * @param map the char array to convert
	 * @param nbLines the length of the new array of char arrays
	 * @param nbColumns the length of the char arrays
	 * @return an array of char arrays
	 */
	private static char[][] convertCharArrayToCharArrayArray(char[] map, int nbLines, int nbColumns){
		char[][] newMap = new char[nbLines][nbColumns];
		int countLine = 0;
		int countColumn = 0;
		for (char c : map) {
			newMap[countLine][countColumn] = c;
			++countColumn;
			if (countColumn == nbColumns) {
				++countLine;
				countColumn = 0;
			}
		}
		return newMap;
	}
	
	/**
	 * Create a char array which contains the walls of the dungeon. Walls are 'X', free space is ' '.
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @return a char array which represents the map of the dungeon with walls added
	 */
	private static char[] addWallsMap(int[][] walls){
		char[] map = new char[mapLength * mapWidth];
		int count = 0;
		// For Wall Borders
		for (int i = 0; i < mapLength; ++i) {
			for (int j = 0; j < mapWidth; ++j) {
				map[count] = ' ';
				if (i == 0 || i == mapLength - 1) { // Top and Bottom borders
					map[count] = 'X';
				}
				else if (j == 0 || j == mapWidth -1) { // Left and Right borders
					map[count] = 'X';
				}
				++count;
			}
		}
		
		// For Other Walls
		for (int[] wall : walls ) {
			map[wall[1] * mapWidth + wall[0]] = 'X';
			
		}

		return map;
	}
	
	/**
	 * Create a char array which contains the chests of the dungeon. Chests are 'C', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @return a char array which represents the map of the dungeon with chests added
	 */
	private static char[] addChestsMap(char[] map, int[][] walls, Chest[] chests) {
		for (Chest chest : chests) {
			map[chest.getY() * mapWidth + chest.getX()] = 'C';
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the common enemies of the dungeon. Common enemies are 'E', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param enemies a Enemy array which contains the location of all the common enemies of the map
	 * @return a char array which represents the map of the dungeon with common enemies added
	 */
	private static char[] addEnemiesMap(char[] map, int[][] walls, Enemy[] enemies) {
		for (Enemy enemy : enemies) {
			if (enemy.getHP() > 0 && enemy.getY() >= 0 && enemy.getX() >= 0) { // in case an enemy has negative coordinates and should not be shown on the map
				map[enemy.getY() * mapWidth + enemy.getX()] = 'E';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the bosses of the dungeon. Bosses are 'B', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param bosses a Boss array which contains the location of all the bosses of the map
	 * @return a char array which represents the map of the dungeon with bosses added
	 */
	private static char[] addBossesMap(char[] map, int[][] walls, Boss[] bosses) {
		for (Boss boss : bosses) {
			if (boss.getY() >= 0 || boss.getX() >= 0) { // in case a boss has negative coordinates and should not be shown on the map
				map[boss.getY() * mapWidth + boss.getX()] = 'B';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the hero. The hero is 'H', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param hero the hero and their location on the map
	 * @return a char array which represents the map of the dungeon with the hero added
	 */
	private static char[] addHeroMap(char[] map, int[][] walls, Hero hero) {
		map[hero.getY() * mapWidth + hero.getX()] = 'H';
		return map;
	}
	
	/**
	 * Create an array of char arrays which represents the map with all the walls, chests, enemies, bosses and the hero.
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @param enemies a Enemy array which contains the location of all the common enemies of the map
	 * @param bosses a Boss array which contains the location of all the bosses of the map
	 * @param hero hero the hero and their location on the map
	 * @return an array of char arrays which represents the complete map of the dungeon
	 */
	public static char[][] createMap(int[][] walls, Chest[] chests, Enemy[] enemies, Boss[] bosses, Hero hero){
		// Map with only the walls
		char[] map = addWallsMap(walls);
		// Add the chests
		map = addChestsMap(map, walls, chests);
		// Add the enemies
		map = addEnemiesMap(map, walls, enemies);
		// Add the bosses
		map = addBossesMap(map, walls, bosses);
		// Add the hero
		map = addHeroMap(map, walls, hero);
		char[][] trueMap = Create.convertCharArrayToCharArrayArray(map, mapLength, mapWidth);
		
		return trueMap;
		
	}
	
}
