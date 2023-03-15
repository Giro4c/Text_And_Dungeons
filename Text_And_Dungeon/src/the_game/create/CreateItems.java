package the_game.create;

import java.util.Random;

import the_game.Artifact;
import the_game.Item;
import the_game.Potion;
import the_game.Weapon;

public class CreateItems {

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
	
}
