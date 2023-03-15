package the_game.create;

import the_game.Artifact;
import the_game.Chest;
import the_game.Potion;
import the_game.Weapon;

public class CreateChests {

	/**
	 * Create a Chest array which contains all the chests of this map.<br>
	 * All artifacts and potions in the chests are random.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Chest array which contains all the chests of this map
	 */
	public static Chest[] placeChests() {
		if (Create.getMapID() == 1) {
			Weapon[] weapons = CreateItems.createWeapons();
			Artifact[] artifacts = (Artifact[]) CreateItems.shuffleItemArray(CreateItems.createArtifacts());
			Potion[] potions = (Potion[]) CreateItems.shuffleItemArray(CreateItems.createPotions());
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
		else if (Create.getMapID() == 2) {
			Weapon[] weapons = (Weapon[]) CreateItems.shuffleItemArray(CreateItems.createWeapons());
			Artifact[] artifacts = (Artifact[]) CreateItems.shuffleItemArray(CreateItems.createArtifacts());
			Potion[] potions = (Potion[]) CreateItems.shuffleItemArray(CreateItems.createPotions());
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
	
}
