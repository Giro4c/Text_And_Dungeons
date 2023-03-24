package the_game.create;

import the_game.Teleport;

public class CreateTeleports {

	public static Teleport[] placeTeleports() {
		if (Create.getMapID() == 1) {
			return null;
		}
		else if (Create.getMapID() == 2) {
			Teleport[] teleports = new Teleport[8];
			teleports[0] = new Teleport("Waypoint");
			teleports[1] = new Teleport("Waypoint");
			teleports[2] = new Teleport("Waypoint");
			teleports[3] = new Teleport("Waypoint");
			teleports[4] = new Teleport("Waypoint");
			teleports[5] = new Teleport("Waypoint");
			teleports[6] = new Teleport("Waypoint");
			teleports[7] = new Teleport("Waypoint");
			
			return teleports;
			
		}
		else {
			return null;
		}
	}
	
}
