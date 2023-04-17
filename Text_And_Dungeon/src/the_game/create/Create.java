package the_game.create;

import the_game.Boss;
import the_game.Chest;
import the_game.Enemy;
import the_game.Hero;
import the_game.Teleport;
import the_game.Wall;

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
		else if (mapID == 2) {
			mapLength = 50;
			mapWidth = 50;
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
	 * @param walls a Wall array which contains the location of all walls of the map except the borders.
	 * @return a char array which represents the map of the dungeon with walls added
	 */
	private static char[] addWallsMap(Wall[] walls){
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
		for (/*Wall wall : walls*/ int i = 0; i < walls.length; ++i) {
			if (walls[i].isVisible() == true) {
				map[walls[i].getY() * mapWidth + walls[i].getX()] = 'X';
			}
		}

		return map;
	}
	
	/**
	 * Create a char array which contains the chests of the dungeon. Chests are 'C', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @return a char array which represents the map of the dungeon with chests added
	 */
	private static char[] addChestsMap(char[] map, Chest[] chests) {
		if (chests == null) {
			return map;
		}
		
		for (Chest chest : chests) {
			if (chest.isVisible() == true) {
				map[chest.getY() * mapWidth + chest.getX()] = 'C';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the teleports of the dungeon. Teleports are 'T', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param teleports a Teleport array which contains the location of all the teleports of the map
	 * @return a char array which represents the map of the dungeon with chests added
	 */
	private static char[] addTeleportsMap(char[] map, Teleport[] teleports) {
		if (teleports == null) {
			return map;
		}
		
		for (Teleport teleport : teleports) {
			if (teleport.getTerminal1().isVisible() == true) {
				map[teleport.getTerminal1().getY() * mapWidth + teleport.getTerminal1().getX()] = 'T';
			}
			if (teleport.getTerminal2().isVisible() == true) {
				map[teleport.getTerminal2().getY() * mapWidth + teleport.getTerminal2().getX()] = 'T';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the common enemies of the dungeon. Common enemies are 'E', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param enemies a Enemy array which contains the location of all the common enemies of the map
	 * @return a char array which represents the map of the dungeon with common enemies added
	 */
	private static char[] addEnemiesMap(char[] map, Enemy[] enemies) {
		if (enemies == null) {
			return map;
		}
		
		for (Enemy enemy : enemies) {
			if (enemy.isVisible() == true && enemy.getHP() > 0) { // in case an enemy is already defeated and should not be on the map.
				map[enemy.getY() * mapWidth + enemy.getX()] = 'E';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the bosses of the dungeon. Bosses are 'B', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param bosses a Boss array which contains the location of all the bosses of the map
	 * @return a char array which represents the map of the dungeon with bosses added
	 */
	private static char[] addBossesMap(char[] map, Boss[] bosses) {
		if (bosses == null) {
			return map;
		}
		
		for (Boss boss : bosses) {
			if (boss.isVisible()) { // in case a boss should not be shown on the map
				map[boss.getY() * mapWidth + boss.getX()] = 'B';
			}
		}
		return map;
	}
	
	/**
	 * Create a char array which contains the hero. The hero is 'H', free space depends on the char array.
	 * @param map the char array which represent the map
	 * @param hero the hero and their location on the map
	 * @return a char array which represents the map of the dungeon with the hero added
	 */
	private static char[] addHeroMap(char[] map, Hero hero) {
		if (hero == null) {
			return map;
		}
		if (hero.isVisible() == true) {
			map[hero.getY() * mapWidth + hero.getX()] = 'H';
		}
		return map;
	}
	
	/**
	 * Create an array of char arrays which represents the map with all the walls, chests, enemies, bosses and the hero.
	 * @param walls a Wall array which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @param enemies a Enemy array which contains the location of all the common enemies of the map
	 * @param bosses a Boss array which contains the location of all the bosses of the map
	 * @param hero hero the hero and their location on the map
	 * @return an array of char arrays which represents the complete map of the dungeon
	 */
	public static char[][] createMap(Wall[] walls, Chest[] chests, Teleport[] teleports, Enemy[] enemies, Boss[] bosses, Hero hero){
		// Map with only the walls
		char[] map = addWallsMap(walls);
		// Add the chests
		map = addChestsMap(map, chests);
		// Add the chests
		map = addTeleportsMap(map, teleports);
		// Add the enemies
		map = addEnemiesMap(map, enemies);
		// Add the bosses
		map = addBossesMap(map, bosses);
		// Add the hero
		map = addHeroMap(map, hero);
		char[][] trueMap = Create.convertCharArrayToCharArrayArray(map, mapLength, mapWidth);
		
		return trueMap;
		
	}

	
	
}
