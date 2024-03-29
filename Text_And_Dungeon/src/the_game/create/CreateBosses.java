package the_game.create;

import the_game.Boss;

public class CreateBosses {

	/**
	 * Create a Boss array which contains all the bosses of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Boss array which contains all the bosses of this map
	 */
	public static Boss[] spawBoss() {
		if (Create.getMapID() == 1) {
			Boss[] bosses = new Boss[2];
			bosses[0] = new Boss("Dragon Cirk", "Dungeon", "Destroyer of the Holy Land", 1, 6, 1, true, 300, 50, 30, 35);
			bosses[1] = new Boss("V O I D    E T E R N Y S", "Hidden", "Incarnation of the void", 2, 16, 1, false, 500, 120, 60, 999); // Does not appear on the map unless specific event is triggered
			bosses[1].setPhaseStats(2, 300, 50, 30, 35);
			return bosses;
		}
		else if (Create.getMapID() == 2) {
			Boss[] bosses = new Boss[2];
			bosses[0] = new Boss("Wywern Salsem", "Dungeon", "Keeper of the Secret Door", 1, 39, 43, true, 300, 50, 30, 35);
			bosses[1] = new Boss("OwO", "Hidden", "Incarnation of OwO", 1, 10, 3, false, 400, 85, 50, 1); // Does not appear on the map unless specific event is triggered
			return bosses;
		}
		else {
			return null;
		}
	}
	
}
