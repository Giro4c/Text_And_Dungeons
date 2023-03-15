package the_game.Deprecated_classes;
import java.util.Random;

import the_game.Artifact;
import the_game.Boss;
import the_game.Chest;
import the_game.Enemy;
import the_game.Hero;
import the_game.Item;
import the_game.Message;
import the_game.Potion;
import the_game.Weapon;
import the_game.enemyWarrior_classes.*;
import the_game.monster_classes.*;

/**
 * A class which creates all that is necessary for the game : walls, chests, enemies, bosses, weapons, artifacts, potions, map.
 * Also includes the attributes of the map (dungeon) : width, length, map ID which are all accessible without a class instantiation.
 * @author Camille Girodengo
 * @deprecated Replaced by package create
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
	
	public static Hero createHero() {
		Hero hero = new Hero(Message.characterNaming(), 100, 30, 15, 20);
		if (mapID == 1) {
			// Start coordinates for hero : 1, 15
			hero.setX(1);
			hero.setY(15);
		}
		else if (mapID == 2) {
			// Start coordinates for hero : 4, 11
			hero.setX(4);
			hero.setY(11);
		}
		return hero;
	}
	
	/**
	 * Create an array of int arrays which contains the location of all the walls of the map except the borders.
	 * @return a <code>int[][]</code> which contains the location of all the walls of the map except the borders
	 */
	public static int[][] placeWalls(){
		if (mapID == 1) {
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
		else if (mapID == 2) {
			int[][] walls = new int[325][2];
			// All the walls that are not extremities :
			// ------------------------------ 1
			walls[0][0] = 5;
			walls[0][1] = 1;
			
			walls[1][0] = 6;
			walls[1][1] = 1;
			
			walls[2][0] = 7;
			walls[2][1] = 1;
			
			walls[3][0] = 20;
			walls[3][1] = 1;
			
			walls[4][0] = 22;
			walls[4][1] = 1;
			
			walls[5][0] = 28;
			walls[5][1] = 1;
			
			walls[6][0] = 29;
			walls[6][1] = 1;
			// ------------------------------ 2
			walls[7][0] = 4;
			walls[7][1] = 2;
			
			walls[8][0] = 21;
			walls[8][1] = 2;
			
			walls[9][0] = 30;
			walls[9][1] = 2;
			// ------------------------------ 3
			walls[10][0] = 3;
			walls[10][1] = 3;
			
			walls[11][0] = 30;
			walls[11][1] = 3;
			
			walls[12][0] = 31;
			walls[12][1] = 3;
			// ------------------------------ 4
			walls[13][0] = 3;
			walls[13][1] = 4;
			
			walls[14][0] = 19;
			walls[14][1] = 4;
			
			walls[15][0] = 20;
			walls[15][1] = 4;
			
			walls[16][0] = 21;
			walls[16][1] = 4;
			
			walls[17][0] = 32;
			walls[17][1] = 4;
			
			walls[18][0] = 33;
			walls[18][1] = 4;
			
			walls[19][0] = 34;
			walls[19][1] = 4;
			
			walls[20][0] = 35;
			walls[20][1] = 4;
			
			walls[21][0] = 36;
			walls[21][1] = 4;
			// ------------------------------ 5
			walls[22][0] = 4;
			walls[22][1] = 5;
			
			walls[23][0] = 5;
			walls[23][1] = 5;
			
			walls[24][0] = 19;
			walls[24][1] = 5;
			
			walls[25][0] = 21;
			walls[25][1] = 5;
			
			walls[26][0] = 37;
			walls[26][1] = 5;
			// ------------------------------ 6
			walls[27][0] = 6;
			walls[27][1] = 6;
			
			walls[28][0] = 7;
			walls[28][1] = 6;
			
			walls[29][0] = 8;
			walls[29][1] = 6;
			
			walls[30][0] = 9;
			walls[30][1] = 6;
			
			walls[31][0] = 10;
			walls[31][1] = 6;
			
			walls[32][0] = 11;
			walls[32][1] = 6;
			
			walls[33][0] = 12;
			walls[33][1] = 6;
			
			walls[34][0] = 13;
			walls[34][1] = 6;
			
			walls[35][0] = 14;
			walls[35][1] = 6;
			
			walls[36][0] = 19;
			walls[36][1] = 6;
			
			walls[37][0] = 20;
			walls[37][1] = 6;
			
			walls[38][0] = 27;
			walls[38][1] = 6;
			// ------------------------------ 7
			walls[39][0] = 2;
			walls[39][1] = 7;
			
			walls[40][0] = 3;
			walls[40][1] = 7;
			
			walls[41][0] = 4;
			walls[41][1] = 7;
			
			walls[42][0] = 5;
			walls[42][1] = 7;
			
			walls[43][0] = 6;
			walls[43][1] = 7;
			
			walls[44][0] = 7;
			walls[44][1] = 7;
			
			walls[45][0] = 8;
			walls[45][1] = 7;
			
			walls[46][0] = 36;
			walls[46][1] = 7;
			// ------------------------------ 8
			walls[47][0] = 1;
			walls[47][1] = 8;
			
			walls[48][0] = 37;
			walls[48][1] = 8;
			// ------------------------------ 9
			walls[49][0] = 1;
			walls[49][1] = 9;
			
			walls[50][0] = 26;
			walls[50][1] = 9;
			
			walls[51][0] = 27;
			walls[51][1] = 9;
			
			walls[52][0] = 37;
			walls[52][1] = 9;
			// ------------------------------ 10
			walls[53][0] = 2;
			walls[53][1] = 10;
			
			walls[54][0] = 36;
			walls[54][1] = 10;
			// ------------------------------ 11
			walls[55][0] = 3;
			walls[55][1] = 11;
			
			walls[56][0] = 36;
			walls[56][1] = 11;
			// ------------------------------ 12
			walls[57][0] = 4;
			walls[57][1] = 12;
			
			walls[58][0] = 12;
			walls[58][1] = 12;
			
			walls[59][0] = 13;
			walls[59][1] = 12;
			
			walls[60][0] = 37;
			walls[60][1] = 12;
			
			walls[61][0] = 38;
			walls[61][1] = 12;
			
			walls[62][0] = 39;
			walls[62][1] = 12;
			
			walls[63][0] = 40;
			walls[63][1] = 12;
			// ------------------------------ 13
			walls[64][0] = 5;
			walls[64][1] = 13;
			
			walls[65][0] = 12;
			walls[65][1] = 13;
			
			walls[66][0] = 41;
			walls[66][1] = 13;
			
			walls[67][0] = 42;
			walls[67][1] = 13;
			
			walls[68][0] = 43;
			walls[68][1] = 13;
			// ------------------------------ 14
			walls[69][0] = 5;
			walls[69][1] = 14;
			
			walls[70][0] = 44;
			walls[70][1] = 14;
			// ------------------------------ 15
			walls[71][0] = 6;
			walls[71][1] = 15;
			
			walls[72][0] = 44;
			walls[72][1] = 15;
			// ------------------------------ 16
			walls[73][0] = 7;
			walls[73][1] = 16;
			
			walls[74][0] = 8;
			walls[74][1] = 16;
			
			walls[75][0] = 9;
			walls[75][1] = 16;
			
			walls[76][0] = 29;
			walls[76][1] = 16;
			
			walls[77][0] = 30;
			walls[77][1] = 16;
			
			walls[78][0] = 44;
			walls[78][1] = 16;
			// ------------------------------ 17
			walls[79][0] = 10;
			walls[79][1] = 17;
			
			walls[80][0] = 11;
			walls[80][1] = 17;
			
			walls[81][0] = 12;
			walls[81][1] = 17;
			
			walls[82][0] = 13;
			walls[82][1] = 17;
			
			walls[83][0] = 29;
			walls[83][1] = 17;
			
			walls[84][0] = 30;
			walls[84][1] = 17;
			
			walls[85][0] = 44;
			walls[85][1] = 17;
			// ------------------------------ 18
			walls[86][0] = 5;
			walls[86][1] = 18;
			
			walls[87][0] = 6;
			walls[87][1] = 18;
			
			walls[88][0] = 7;
			walls[88][1] = 18;
			
			walls[89][0] = 8;
			walls[89][1] = 18;
			
			walls[90][0] = 9;
			walls[90][1] = 18;
			
			walls[91][0] = 10;
			walls[91][1] = 18;
			
			walls[92][0] = 11;
			walls[92][1] = 18;
			
			walls[93][0] = 14;
			walls[93][1] = 18;
			
			walls[94][0] = 45;
			walls[94][1] = 18;
			// ------------------------------ 19
			walls[95][0] = 2;
			walls[95][1] = 19;
			
			walls[96][0] = 3;
			walls[96][1] = 19;
			
			walls[97][0] = 4;
			walls[97][1] = 19;
			
			walls[98][0] = 12;
			walls[98][1] = 19;
			
			walls[99][0] = 13;
			walls[99][1] = 19;
			
			walls[100][0] = 15;
			walls[100][1] = 19;
			
			walls[101][0] = 16;
			walls[101][1] = 19;
			
			walls[102][0] = 46;
			walls[102][1] = 19;
			// ------------------------------ 20
			walls[103][0] = 1;
			walls[103][1] = 20;
			
			walls[104][0] = 14;
			walls[104][1] = 20;
			
			walls[105][0] = 17;
			walls[105][1] = 20;
			
			walls[106][0] = 24;
			walls[106][1] = 20;
			
			walls[107][0] = 47;
			walls[107][1] = 20;
			// ------------------------------ 21
			walls[108][0] = 2;
			walls[108][1] = 21;
			
			walls[109][0] = 8;
			walls[109][1] = 21;
			
			walls[110][0] = 9;
			walls[110][1] = 21;
			
			walls[111][0] = 10;
			walls[111][1] = 21;
			
			walls[112][0] = 11;
			walls[112][1] = 21;
			
			walls[113][0] = 12;
			walls[113][1] = 21;
			
			walls[114][0] = 13;
			walls[114][1] = 21;
			
			walls[115][0] = 18;
			walls[115][1] = 21;
			
			walls[116][0] = 19;
			walls[116][1] = 21;
			
			walls[117][0] = 37;
			walls[117][1] = 21;
			
			walls[118][0] = 48;
			walls[118][1] = 21;
			// ------------------------------ 22
			walls[119][0] = 3;
			walls[119][1] = 22;
			
			walls[120][0] = 4;
			walls[120][1] = 22;
			
			walls[121][0] = 5;
			walls[121][1] = 22;
			
			walls[122][0] = 6;
			walls[122][1] = 22;
			
			walls[123][0] = 7;
			walls[123][1] = 22;
			
			walls[124][0] = 8;
			walls[124][1] = 22;
			
			walls[125][0] = 20;
			walls[125][1] = 22;
			
			walls[126][0] = 37;
			walls[126][1] = 22;
			
			walls[127][0] = 48;
			walls[127][1] = 22;
			// ------------------------------ 23
			walls[128][0] = 10;
			walls[128][1] = 23;
			
			walls[129][0] = 11;
			walls[129][1] = 23;
			
			walls[130][0] = 12;
			walls[130][1] = 23;
			
			walls[131][0] = 21;
			walls[131][1] = 23;
			
			walls[132][0] = 38;
			walls[132][1] = 23;
			
			walls[133][0] = 39;
			walls[133][1] = 23;
			// ------------------------------ 24
			walls[134][0] = 9;
			walls[134][1] = 24;
			
			walls[135][0] = 13;
			walls[135][1] = 24;
			
			walls[136][0] = 21;
			walls[136][1] = 24;
			// ------------------------------ 25
			walls[137][0] = 1;
			walls[137][1] = 25;
			
			walls[138][0] = 2;
			walls[138][1] = 25;
			
			walls[139][0] = 8;
			walls[139][1] = 25;
			
			walls[140][0] = 13;
			walls[140][1] = 25;
			
			walls[141][0] = 21;
			walls[141][1] = 25;
			// ------------------------------ 26
			walls[142][0] = 3;
			walls[142][1] = 26;
			
			walls[143][0] = 7;
			walls[143][1] = 26;
			
			walls[144][0] = 10;
			walls[144][1] = 26;
			
			walls[145][0] = 11;
			walls[145][1] = 26;
			
			walls[146][0] = 14;
			walls[146][1] = 26;
			
			walls[147][0] = 15;
			walls[147][1] = 26;
			
			walls[148][0] = 21;
			walls[148][1] = 26;
			// ------------------------------ 27
			walls[149][0] = 4;
			walls[149][1] = 27;
			
			walls[150][0] = 5;
			walls[150][1] = 27;
			
			walls[151][0] = 6;
			walls[151][1] = 27;
			
			walls[152][0] = 9;
			walls[152][1] = 27;
			
			walls[153][0] = 12;
			walls[153][1] = 27;
			
			walls[154][0] = 16;
			walls[154][1] = 27;
			
			walls[155][0] = 17;
			walls[155][1] = 27;
			
			walls[156][0] = 20;
			walls[156][1] = 27;
			// ------------------------------ 28
			walls[157][0] = 9;
			walls[157][1] = 28;
			
			walls[158][0] = 13;
			walls[158][1] = 28;
			
			walls[159][0] = 18;
			walls[159][1] = 28;
			
			walls[160][0] = 19;
			walls[160][1] = 28;
			
			walls[161][0] = 38;
			walls[161][1] = 28;
			
			walls[162][0] = 39;
			walls[162][1] = 28;
			
			walls[163][0] = 40;
			walls[163][1] = 28;
			
			walls[164][0] = 41;
			walls[164][1] = 28;
			
			walls[165][0] = 42;
			walls[165][1] = 28;
			
			walls[166][0] = 43;
			walls[166][1] = 28;
			
			walls[167][0] = 44;
			walls[167][1] = 28;
			// ------------------------------ 29
			walls[168][0] = 8;
			walls[168][1] = 29;
			
			walls[169][0] = 13;
			walls[169][1] = 29;
			
			walls[170][0] = 40;
			walls[170][1] = 29;
			
			walls[171][0] = 41;
			walls[171][1] = 29;
			
			walls[172][0] = 44;
			walls[172][1] = 29;
			// ------------------------------ 30
			walls[173][0] = 9;
			walls[173][1] = 30;
			
			walls[174][0] = 14;
			walls[174][1] = 30;
			
			walls[175][0] = 42;
			walls[175][1] = 30;
			
			walls[176][0] = 43;
			walls[176][1] = 30;
			
			walls[177][0] = 44;
			walls[177][1] = 30;
			
			walls[178][0] = 45;
			walls[178][1] = 30;
			
			walls[179][0] = 46;
			walls[179][1] = 30;
			// ------------------------------ 31
			walls[180][0] = 10;
			walls[180][1] = 31;
			
			walls[181][0] = 14;
			walls[181][1] = 31;
			
			walls[182][0] = 23;
			walls[182][1] = 31;
			
			walls[183][0] = 24;
			walls[183][1] = 31;
			// ------------------------------ 32
			walls[184][0] = 11;
			walls[184][1] = 32;
			
			walls[185][0] = 12;
			walls[185][1] = 32;
			
			walls[186][0] = 13;
			walls[186][1] = 32;
			
			walls[187][0] = 22;
			walls[187][1] = 32;
			
			walls[188][0] = 25;
			walls[188][1] = 32;
			
			walls[189][0] = 47;
			walls[189][1] = 32;
			
			walls[190][0] = 48;
			walls[190][1] = 32;
			// ------------------------------ 33
			walls[191][0] = 23;
			walls[191][1] = 33;
			
			walls[192][0] = 24;
			walls[192][1] = 33;
			
			walls[193][0] = 43;
			walls[193][1] = 33;
			
			walls[194][0] = 44;
			walls[194][1] = 33;
			
			walls[195][0] = 45;
			walls[195][1] = 33;
			
			walls[196][0] = 46;
			walls[196][1] = 33;
			// ------------------------------ 34
			walls[197][0] = 5;
			walls[197][1] = 34;
			
			walls[198][0] = 36;
			walls[198][1] = 34;
			
			walls[199][0] = 37;
			walls[199][1] = 34;
			
			walls[200][0] = 38;
			walls[200][1] = 34;
			
			walls[201][0] = 39;
			walls[201][1] = 34;
			
			walls[202][0] = 40;
			walls[202][1] = 34;
			
			walls[203][0] = 41;
			walls[203][1] = 34;
			
			walls[204][0] = 42;
			walls[204][1] = 34;
			// ------------------------------ 35
			walls[205][0] = 4;
			walls[205][1] = 35;
			
			walls[206][0] = 34;
			walls[206][1] = 35;
			
			walls[207][0] = 35;
			walls[207][1] = 35;
			
			walls[208][0] = 36;
			walls[208][1] = 35;
			// ------------------------------ 36
			walls[209][0] = 30;
			walls[209][1] = 36;
			
			walls[210][0] = 31;
			walls[210][1] = 36;
			
			walls[211][0] = 37;
			walls[211][1] = 36;
			// ------------------------------ 37
			walls[212][0] = 15;
			walls[212][1] = 37;
			
			walls[213][0] = 29;
			walls[213][1] = 37;
			
			walls[214][0] = 32;
			walls[214][1] = 37;
			
			walls[215][0] = 33;
			walls[215][1] = 37;
			
			walls[216][0] = 37;
			walls[216][1] = 37;
			// ------------------------------ 38
			walls[217][0] = 26;
			walls[217][1] = 38;
			
			walls[218][0] = 27;
			walls[218][1] = 38;
			
			walls[219][0] = 28;
			walls[219][1] = 38;
			
			walls[220][0] = 34;
			walls[220][1] = 38;
			
			walls[221][0] = 35;
			walls[221][1] = 38;
			
			walls[222][0] = 36;
			walls[222][1] = 38;
			// ------------------------------ 39
			walls[223][0] = 1;
			walls[223][1] = 39;
			
			walls[224][0] = 2;
			walls[224][1] = 39;
			
			walls[225][0] = 3;
			walls[225][1] = 39;
			
			walls[226][0] = 12;
			walls[226][1] = 39;
			
			walls[227][0] = 29;
			walls[227][1] = 39;
			
			walls[228][0] = 30;
			walls[228][1] = 39;
			
			walls[229][0] = 31;
			walls[229][1] = 39;
			
			walls[230][0] = 32;
			walls[230][1] = 39;
			
			walls[231][0] = 33;
			walls[231][1] = 39;
			
			walls[232][0] = 34;
			walls[232][1] = 39;
			
			walls[233][0] = 35;
			walls[233][1] = 39;
			
			walls[234][0] = 36;
			walls[234][1] = 39;
			
			walls[235][0] = 37;
			walls[235][1] = 39;
			
			walls[236][0] = 38;
			walls[236][1] = 39;
			
			walls[237][0] = 39;
			walls[237][1] = 39;
			// ------------------------------ 40
			walls[238][0] = 4;
			walls[238][1] = 40;
			
			walls[239][0] = 5;
			walls[239][1] = 40;
			
			walls[240][0] = 21;
			walls[240][1] = 40;
			
			walls[241][0] = 22;
			walls[241][1] = 40;
			
			walls[242][0] = 23;
			walls[242][1] = 40;
			
			walls[243][0] = 24;
			walls[243][1] = 40;
			
			walls[244][0] = 40;
			walls[244][1] = 40;
			
			walls[245][0] = 41;
			walls[245][1] = 40;
			
			walls[246][0] = 42;
			walls[246][1] = 40;
			
			walls[247][0] = 43;
			walls[247][1] = 40;
			
			walls[248][0] = 44;
			walls[248][1] = 40;
			// ------------------------------ 41
			walls[249][0] = 6;
			walls[249][1] = 41;
			
			walls[250][0] = 7;
			walls[250][1] = 41;
			
			walls[251][0] = 23;
			walls[251][1] = 41;
			
			walls[252][0] = 25;
			walls[252][1] = 41;
			
			walls[253][0] = 26;
			walls[253][1] = 41;
			
			walls[254][0] = 27;
			walls[254][1] = 41;
			
			walls[255][0] = 45;
			walls[255][1] = 41;
			
			walls[256][0] = 46;
			walls[256][1] = 41;
			// ------------------------------ 42
			walls[257][0] = 8;
			walls[257][1] = 42;
			
			walls[258][0] = 9;
			walls[258][1] = 42;
			
			walls[259][0] = 20;
			walls[259][1] = 42;
			
			walls[260][0] = 24;
			walls[260][1] = 42;
			
			walls[261][0] = 25;
			walls[261][1] = 42;
			
			walls[262][0] = 28;
			walls[262][1] = 42;
			
			walls[263][0] = 29;
			walls[263][1] = 42;
			
			walls[264][0] = 30;
			walls[264][1] = 42;
			
			walls[265][0] = 31;
			walls[265][1] = 42;
			
			walls[266][0] = 47;
			walls[266][1] = 42;
			// ------------------------------ 43
			walls[267][0] = 6;
			walls[267][1] = 43;
			
			walls[268][0] = 7;
			walls[268][1] = 43;
			
			walls[269][0] = 19;
			walls[269][1] = 43;
			
			walls[270][0] = 20;
			walls[270][1] = 43;
			
			walls[271][0] = 26;
			walls[271][1] = 43;
			
			walls[272][0] = 27;
			walls[272][1] = 43;
			
			walls[273][0] = 28;
			walls[273][1] = 43;
			
			walls[274][0] = 32;
			walls[274][1] = 43;
			
			walls[275][0] = 47;
			walls[275][1] = 43;
			// ------------------------------ 44
			walls[276][0] = 3;
			walls[276][1] = 44;
			
			walls[277][0] = 4;
			walls[277][1] = 44;
			
			walls[278][0] = 5;
			walls[278][1] = 44;
			
			walls[279][0] = 18;
			walls[279][1] = 44;
			
			walls[280][0] = 19;
			walls[280][1] = 44;
			
			walls[281][0] = 29;
			walls[281][1] = 44;
			
			walls[282][0] = 32;
			walls[282][1] = 44;
			
			walls[283][0] = 46;
			walls[283][1] = 44;
			// ------------------------------ 45
			walls[284][0] = 1;
			walls[284][1] = 45;
			
			walls[285][0] = 2;
			walls[285][1] = 45;
			
			walls[286][0] = 6;
			walls[286][1] = 45;
			
			walls[287][0] = 30;
			walls[287][1] = 45;
			
			walls[288][0] = 33;
			walls[288][1] = 45;
			
			walls[289][0] = 34;
			walls[289][1] = 45;
			
			walls[290][0] = 47;
			walls[290][1] = 45;
			// ------------------------------ 46
			walls[291][0] = 14;
			walls[291][1] = 46;
			
			walls[292][0] = 15;
			walls[292][1] = 46;
			
			walls[293][0] = 16;
			walls[293][1] = 46;
			
			walls[294][0] = 17;
			walls[294][1] = 46;
			
			walls[295][0] = 18;
			walls[295][1] = 46;
			
			walls[296][0] = 31;
			walls[296][1] = 46;
			
			walls[297][0] = 35;
			walls[297][1] = 46;
			
			walls[298][0] = 44;
			walls[298][1] = 46;
			
			walls[299][0] = 45;
			walls[299][1] = 46;
			
			walls[300][0] = 46;
			walls[300][1] = 46;
			// ------------------------------ 47
			walls[301][0] = 1;
			walls[301][1] = 47;
			
			walls[302][0] = 12;
			walls[302][1] = 47;
			
			walls[303][0] = 13;
			walls[303][1] = 47;
			
			walls[304][0] = 19;
			walls[304][1] = 47;
			
			walls[305][0] = 20;
			walls[305][1] = 47;
			
			walls[306][0] = 31;
			walls[306][1] = 47;
			
			walls[307][0] = 36;
			walls[307][1] = 47;
			
			walls[308][0] = 37;
			walls[308][1] = 47;
			
			walls[309][0] = 38;
			walls[309][1] = 47;
			
			walls[310][0] = 39;
			walls[310][1] = 47;
			
			walls[311][0] = 40;
			walls[311][1] = 47;
			
			walls[312][0] = 41;
			walls[312][1] = 47;
			
			walls[313][0] = 42;
			walls[313][1] = 47;
			
			walls[314][0] = 43;
			walls[314][1] = 47;
			// ------------------------------ 48
			walls[315][0] = 2;
			walls[315][1] = 48;
			
			walls[316][0] = 3;
			walls[316][1] = 48;
			
			walls[317][0] = 4;
			walls[317][1] = 48;
			
			walls[318][0] = 11;
			walls[318][1] = 48;
			
			walls[319][0] = 21;
			walls[319][1] = 48;
			
			walls[320][0] = 22;
			walls[320][1] = 48;
			
			walls[321][0] = 23;
			walls[321][1] = 48;
			
			walls[322][0] = 24;
			walls[322][1] = 48;
			
			walls[323][0] = 25;
			walls[323][1] = 48;
			
			walls[324][0] = 30;
			walls[324][1] = 48;
		
			
			return walls;
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * Create a Chest array which contains all the chests of this map.<br>
	 * All artifacts and potions in the chests are random.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Chest array which contains all the chests of this map
	 */
	public static Chest[] placeChests() {
		if (mapID == 1) {
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
		else if (mapID == 2) {
			Weapon[] weapons = (Weapon[]) shuffleItemArray(createWeapons());
			Artifact[] artifacts = (Artifact[]) shuffleItemArray(createArtifacts());
			Potion[] potions = (Potion[]) shuffleItemArray(createPotions());
			Chest[] chests = new Chest[35];
			
			chests[0] = new Chest("Chest ", 24, 1, weapons[5]);
			chests[1] = new Chest("Chest ", 31, 4, potions[14]);
			chests[2] = new Chest("Chest ", 36, 6, weapons[11], potions[1]);
			chests[3] = new Chest("Chest ", 2, 9, artifacts[10]);
			chests[4] = new Chest("Chest ", 32, 11, artifacts[7]);
			chests[5] = new Chest("Chest ", 40, 13, artifacts[14], potions[9]);
			chests[6] = new Chest("Chest ", 19, 14, weapons[6]);
			chests[7] = new Chest("Chest ", 30, 15, potions[10]);
			chests[8] = new Chest("Chest ", 28, 17, weapons[7], artifacts[2]);
			chests[9] = new Chest("Chest ", 40, 17, artifacts[5]);
			chests[10] = new Chest("Chest ", 8, 19, weapons[2]);
			chests[11] = new Chest("Chest ", 13, 20, potions[0]);
			chests[12] = new Chest("Chest ", 31, 22, artifacts[11], potions[6]);
			chests[13] = new Chest("Chest ", 39, 22, potions[12]);
			chests[14] = new Chest("Chest ", 10, 24, weapons[3]);
			chests[15] = new Chest("Chest ", 12, 24, artifacts[13], potions[8]);
			chests[16] = new Chest("Chest ", 2, 26, artifacts[0]);
			chests[17] = new Chest("Chest ", 20, 28, weapons[1]);
			chests[18] = new Chest("Chest ", 45, 29, potions[5]);
			chests[19] = new Chest("Chest ", 33, 30, artifacts[3]);
			chests[20] = new Chest("Chest ", 1, 31, artifacts[6]);
			chests[21] = new Chest("Chest ", 48, 31, weapons[9], artifacts[4]);
			chests[22] = new Chest("Chest ", 9, 32, weapons[12], potions[2]);
			chests[23] = new Chest("Chest ", 22, 33, artifacts[8]);
			chests[24] = new Chest("Chest ", 25, 33, artifacts[12], potions[7]);
			chests[25] = new Chest("Chest ", 35, 34, weapons[14], potions[4]);
			chests[26] = new Chest("Chest ", 7, 35, weapons[4]);
			chests[27] = new Chest("Chest ", 34, 37, weapons[13], potions[3]);
			chests[28] = new Chest("Chest ", 35, 37, artifacts[9]);
			chests[29] = new Chest("Chest ", 36, 37, weapons[8]);
			chests[30] = new Chest("Chest ", 8, 41, weapons[10]);
			chests[31] = new Chest("Chest ", 4, 45, potions[11]);
			chests[32] = new Chest("Chest ", 5, 45, weapons[0]);
			chests[33] = new Chest("Chest ", 25, 46, potions[13]);
			chests[34] = new Chest("Chest ", 7, 48, artifacts[1]);
			
			for (int numChest = 1; numChest - 1 < chests.length; ++numChest) {
				chests[numChest - 1].setName(chests[numChest - 1].getName() + numChest);
			}
			
			return chests;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Create a Boss array which contains all the bosses of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Boss array which contains all the bosses of this map
	 */
	public static Boss[] spawBoss() {
		if (mapID == 1) {
			Boss[] bosses = new Boss[2];
			bosses[0] = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 6, 1, 300, 50, 30, 35);
			bosses[1] = new Boss("V O I D    E T E R N Y S", "Hidden", "Incarnation of the void", -1, -1, 500, 120, 60, 999); // Does not appear on the map unless engages in a fight
			// Hidden at 
			return bosses;
		}
		else if (mapID == 2) {
			Boss[] bosses = new Boss[2];
			bosses[0] = new Boss("Wywern Salsem", "Dungeon", "Keeper of the Secret Door", 39, 43, 300, 50, 30, 35);
			bosses[1] = new Boss("OwO", "Hidden", "Incarnation of OwO", -1, -1, 400, 85, 50, 1); // Does not appear on the map unless engages in a fight
			// Hidden at (10, 3)
			return bosses;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Create a Enemy array which contains all the enemies of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Enemy array which contains all the enemies of this map
	 */
	public static Enemy[] spawnEnemies() {
		if (mapID == 1) {
			Enemy[] enemies = new Enemy[26];
			enemies[0] = new Monglr(1, 17, 17);
			enemies[1] = new Monglr(2, 15, 10);
			enemies[2] = new Slime(1, 14, 15);
			enemies[3] = new Slime(2, 11, 4);
			enemies[4] = new Altriss(1, 3, 3);
			enemies[5] = new Altriss(2, 6, 3);
			enemies[6] = new Altriss(3, 9, 3);
			enemies[7] = new Typhru(1, 1, 5);
			enemies[8] = new Typhru(2, 1, 7);
			enemies[9] = new Typhru(3, 2, 6);
			enemies[10] = new Talphru(1, 2, 5);
			enemies[11] = new Talphru(2, 2, 7);
			enemies[12] = new Slime(3, 3, 18);
			enemies[13] = new Slime(4, 4, 16);
			enemies[14] = new Slime(5, 4, 18);
			enemies[15] = new Monglr(3, 14, 9);
			enemies[16] = new Altriss(4, 15, 18);
			enemies[17] = new Venna(1, 16, 8);
			
			enemies[18] = new Barbarian(Barbarian.getNames()[0], 8, 11);
			enemies[19] = new Barbarian(Barbarian.getNames()[1], 8, 12);
			enemies[20] = new Defender(Defender.getNames()[0], 7, 10);
			enemies[21] = new Defender(Defender.getNames()[1], 7, 13);
			enemies[22] = new Barbarian(Barbarian.getNames()[2], 7, 7);
			enemies[23] = new Defender(Defender.getNames()[2], 8, 6);
			enemies[24] = new Valky(Valky.getNames()[0], 10, 14);
			enemies[25] = new Valky(Valky.getNames()[1], 12, 17);
			
			return enemies;
		}
		else if (mapID == 2) {
			Enemy[] enemies = new Enemy[91];
			// Monglr
			enemies[0] = new Monglr(1, 14, 1);
			enemies[1] = new Monglr(2, 14, 4);
			enemies[2] = new Monglr(3, 18, 8);
			enemies[3] = new Monglr(4, 39, 15);
			enemies[4] = new Monglr(5, 31, 23);
			enemies[5] = new Monglr(6, 32, 23);
			enemies[6] = new Monglr(7, 33, 29);
			enemies[7] = new Monglr(8, 22, 35);
			enemies[8] = new Monglr(9, 35, 42);
			enemies[9] = new Monglr(10, 6, 44);
			// Writlor
			enemies[10] = new Writlor(1, 16, 2);
			enemies[11] = new Writlor(2, 16, 3);
			enemies[12] = new Writlor(3, 20, 11);
			enemies[13] = new Writlor(4, 24, 19);
			enemies[14] = new Writlor(5, 25, 20);
			enemies[15] = new Writlor(6, 26, 20);
			enemies[16] = new Writlor(7, 10, 34);
			enemies[17] = new Writlor(8, 11, 35);
			enemies[18] = new Writlor(9, 37, 41);
			enemies[19] = new Writlor(10, 5, 46);
			enemies[20] = new Writlor(11, 3, 47);
			// Slime
			enemies[21] = new Slime(1, 11, 9);
			enemies[22] = new Slime(2, 7, 12);
			enemies[23] = new Slime(3, 43, 19);
			enemies[24] = new Slime(4, 43, 23);
			enemies[25] = new Slime(5, 46, 25);
			enemies[26] = new Slime(6, 19, 41);
			enemies[27] = new Slime(7, 44, 43);
			// Typhru
			enemies[28] = new Typhru(1, 27, 6);
			enemies[29] = new Typhru(2, 25, 7);
			enemies[30] = new Typhru(3, 32, 30);
			enemies[31] = new Typhru(4, 34, 30);
			enemies[32] = new Typhru(5, 41, 32);
			enemies[33] = new Typhru(6, 32, 34);
			enemies[34] = new Typhru(7, 30, 35);
			enemies[35] = new Typhru(8, 31, 35);
			enemies[36] = new Typhru(9, 32, 36);
			enemies[37] = new Typhru(10, 13, 41);
			enemies[38] = new Typhru(11, 24, 45);
			// Talphru
			enemies[39] = new Talphru(1, 26, 6);
			enemies[40] = new Talphru(2, 26, 7);
			enemies[41] = new Talphru(3, 33, 31);
			enemies[42] = new Talphru(4, 32, 35);
			enemies[43] = new Talphru(5, 33, 35);
			enemies[44] = new Talphru(6, 11, 46);
			enemies[45] = new Talphru(7, 26, 47);
			// Venna
			enemies[46] = new Venna(1, 11, 5);
			enemies[47] = new Venna(2, 30, 14);
			enemies[48] = new Venna(3, 31, 14);
			enemies[49] = new Venna(4, 25, 25);
			enemies[50] = new Venna(5, 21, 33);
			enemies[51] = new Venna(6, 6, 37);
			enemies[52] = new Venna(7, 22, 45);
			// Immec
			enemies[53] = new Immec(1, 8, 4);
			enemies[54] = new Immec(2, 36, 17);
			enemies[55] = new Immec(3, 26, 26);
			enemies[56] = new Immec(4, 36, 26);
			enemies[57] = new Immec(5, 36, 43);
			// Altriss
			enemies[58] = new Altriss(1, 30, 18);
			enemies[59] = new Altriss(2, 24, 25);
			enemies[60] = new Altriss(3, 27, 26);
			enemies[61] = new Altriss(4, 10, 44);
			enemies[62] = new Altriss(5, 25, 44);
			enemies[63] = new Altriss(6, 15, 45);
			enemies[64] = new Altriss(7, 39, 45);
			// Nevfa
			enemies[65] = new Nevfa(1, 16, 14);
			enemies[66] = new Nevfa(2, 16, 16);
			enemies[67] = new Nevfa(3, 26, 45);
			enemies[68] = new Nevfa(4, 24, 47);
			enemies[69] = new Nevfa(5, 8, 48);
			// Onefa
			enemies[70] = new Onefa(1, 17, 15);
			enemies[71] = new Onefa(2, 27, 16);
			enemies[72] = new Onefa(3, 33, 16);
			enemies[73] = new Onefa(4, 23, 46);
			enemies[74] = new Onefa(5, 27, 46);
			// Barbarian
			enemies[75] = new Barbarian(Barbarian.getNames()[0], 35, 6);
			enemies[76] = new Barbarian(Barbarian.getNames()[1], 16, 32);
			enemies[77] = new Barbarian(Barbarian.getNames()[2], 6, 35);
			// Defender
			enemies[78] = new Defender(Defender.getNames()[0], 8, 26);
			enemies[79] = new Defender(Defender.getNames()[1], 13, 26);
			enemies[80] = new Defender(Defender.getNames()[2], 8, 27);
			// Fighter
			enemies[81] = new Fighter(Fighter.getNames()[0], 10, 25);
			enemies[82] = new Fighter(Fighter.getNames()[1], 5, 28);
			enemies[83] = new Fighter(Fighter.getNames()[2], 14, 28);
			// Valky
			enemies[84] = new Valky(Valky.getNames()[0], 6, 19);
			enemies[85] = new Valky(Valky.getNames()[1], 7, 20);
			enemies[86] = new Valky(Valky.getNames()[2], 12, 20);
			// Scout
			enemies[87] = new Scout(Scout.getNames()[0], 23, 29);
			enemies[88] = new Scout(Scout.getNames()[1], 17, 30);
			enemies[89] = new Scout(Scout.getNames()[2], 18, 30);
			enemies[90] = new Scout(Scout.getNames()[3], 4, 31);
			
			
			
			return enemies;
		}
		else {
			return null;
		}
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
