package the_game.create;

import the_game.Hero;
import the_game.Message;

public class CreateHero {

	public static Hero createHero() {
		Hero hero = null;
		if (Create.getMapID() == 1) {
			// Start coordinates for hero : 1, 15
			hero = new Hero(Message.characterNaming(), 1, 15, true, 100, 30, 15, 20);
		}
		else if (Create.getMapID() == 2) {
			// Start coordinates for hero : 4, 11
			hero = new Hero(Message.characterNaming(), 4, 11, true, 100, 30, 15, 20);
		}
		return hero;
	}
	
}
