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
			chests[0] = new Chest("Chest 1", 1, 6, true, weapons[8], artifacts[0], potions[0]);
			chests[1] = new Chest("Chest 2", 2, 18, true, weapons[12], artifacts[1], potions[1]);
			chests[2] = new Chest("Chest 3", 7, 11, true, weapons[13], artifacts[2], potions[2]);
			chests[3] = new Chest("Chest 4", 7, 12, true, weapons[10], artifacts[3], potions[3]);
			chests[4] = new Chest("Chest 5", 17, 18, true, weapons[1], artifacts[4], potions[4]);
			chests[5] = new Chest("Chest 6", 18, 8, true, weapons[3], artifacts[5], potions[5]);
			chests[6] = new Chest("Chest 7", 2, 14, true, weapons[0], artifacts[6], potions[6]);
			chests[7] = new Chest("Chest 8", 9, 7, true, weapons[14], artifacts[7], potions[7]);
			chests[8] = new Chest("Chest 9", 11, 6, true, weapons[4], artifacts[8], potions[8]);
			chests[9] = new Chest("Chest 10", 11, 17, true, weapons[5], artifacts[9], potions[9]);
			chests[10] = new Chest("Chest 11", 1, 10, true, weapons[2], artifacts[10], potions[10]);
			chests[11] = new Chest("Chest 12", 18, 10, true, weapons[7], artifacts[11], potions[11]);
			chests[12] = new Chest("Chest 13", 18, 11, true, weapons[6], artifacts[12], potions[12]);
			chests[13] = new Chest("Chest 14", 18, 15, true, weapons[9], artifacts[13], potions[13]);
			chests[14] = new Chest("Chest 15", 11, 14, true, weapons[11], artifacts[14], potions[14]);
			
			return chests;
		}
		else if (Create.getMapID() == 2) {
			Weapon[] weapons = (Weapon[]) CreateItems.shuffleItemArray(CreateItems.createWeapons());
			Artifact[] artifacts = (Artifact[]) CreateItems.shuffleItemArray(CreateItems.createArtifacts());
			Potion[] potions = (Potion[]) CreateItems.shuffleItemArray(CreateItems.createPotions());
			Chest[] chests = new Chest[35];
			
			chests[0] = new Chest("Chest ", 24, 1, true, weapons[5], null, null);
			chests[1] = new Chest("Chest ", 31, 4, true, null, null, potions[14]);
			chests[2] = new Chest("Chest ", 36, 6, true, weapons[11], null, potions[1]);
			chests[3] = new Chest("Chest ", 2, 9, true, null, artifacts[10], null);
			chests[4] = new Chest("Chest ", 32, 11, true, null, artifacts[7], null);
			chests[5] = new Chest("Chest ", 40, 13, true, null, artifacts[14], potions[9]);
			chests[6] = new Chest("Chest ", 19, 14, true, weapons[6], null, null);
			chests[7] = new Chest("Chest ", 30, 15, true, null, null, potions[10]);
			chests[8] = new Chest("Chest ", 28, 17, true, weapons[7], artifacts[2], null);
			chests[9] = new Chest("Chest ", 40, 17, true, null, artifacts[5], null);
			chests[10] = new Chest("Chest ", 8, 19, false, weapons[2], null, null);
			chests[11] = new Chest("Chest ", 13, 20, false, null, null, potions[0]);
			chests[12] = new Chest("Chest ", 31, 22, true, null, artifacts[11], potions[6]);
			chests[13] = new Chest("Chest ", 39, 22, true, null, null, potions[12]);
			chests[14] = new Chest("Chest ", 10, 24, true, weapons[3], null, null);
			chests[15] = new Chest("Chest ", 12, 24, true, null, artifacts[13], potions[8]);
			chests[16] = new Chest("Chest ", 2, 26, true, null, artifacts[0], null);
			chests[17] = new Chest("Chest ", 20, 28, true, weapons[1], null, null);
			chests[18] = new Chest("Chest ", 45, 29, true, null, null, potions[5]);
			chests[19] = new Chest("Chest ", 33, 30, true, null, artifacts[3], null);
			chests[20] = new Chest("Chest ", 1, 31, true, null, artifacts[6], null);
			chests[21] = new Chest("Chest ", 48, 31, true, weapons[9], artifacts[4], null);
			chests[22] = new Chest("Chest ", 9, 32, true, weapons[12], null, potions[2]);
			chests[23] = new Chest("Chest ", 22, 33, true, null, artifacts[8], null);
			chests[24] = new Chest("Chest ", 25, 33, true, null, artifacts[12], potions[7]);
			chests[25] = new Chest("Chest ", 35, 34, true, weapons[14], null, potions[4]);
			chests[26] = new Chest("Chest ", 7, 35, true, weapons[4], null, null);
			chests[27] = new Chest("Chest ", 34, 37, true, weapons[13], null, potions[3]);
			chests[28] = new Chest("Chest ", 35, 37, true, null, artifacts[9], null);
			chests[29] = new Chest("Chest ", 36, 37, true, weapons[8], null, null);
			chests[30] = new Chest("Chest ", 8, 41, true, weapons[10], null, null);
			chests[31] = new Chest("Chest ", 4, 45, true, null, null, potions[11]);
			chests[32] = new Chest("Chest ", 5, 45, true, weapons[0], null, null);
			chests[33] = new Chest("Chest ", 25, 46, true, null, null, potions[13]);
			chests[34] = new Chest("Chest ", 7, 48, true, null, artifacts[1], null);
			
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
