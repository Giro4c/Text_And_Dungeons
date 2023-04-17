package the_game.create;

import the_game.Teleport;

public class CreateTeleports {

	/**
	 * Create a Teleport array which contains all the teleports of this map.
	 * @return a Teleport array which contains all the teleports of this map
	 */
	public static Teleport[] placeTeleports() {
		if (Create.getMapID() == 1) {
			return null;
		}
		else if (Create.getMapID() == 2) {
			Teleport[] teleports = new Teleport[8];
			teleports[0] = new Teleport("Waypoint", 8, 2, 43, 14, true);
			teleports[1] = new Teleport("Waypoint", 21, 6, 4, 34, true);
			teleports[2] = new Teleport("Waypoint", 27, 10, 17, 39, true);
			teleports[3] = new Teleport("Waypoint", 11, 13, 28, 39, true);
			teleports[4] = new Teleport("Waypoint", 18, 20, 37, 31, true);
			teleports[5] = new Teleport("Waypoint", 4, 21, false, 11, 24, true);
			teleports[6] = new Teleport("Waypoint", 41, 26, 25, 31, true);
			teleports[7] = new Teleport("Waypoint", 18, 43, 28, 21, true);
			
			return teleports;
			
		}
		else {
			return null;
		}
	}
	
}
