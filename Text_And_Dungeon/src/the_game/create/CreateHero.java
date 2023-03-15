package the_game.create;

import the_game.Hero;
import the_game.Message;

public class CreateHero {

	public static Hero createHero() {
		Hero hero = new Hero(Message.characterNaming(), 100, 30, 15, 20);
		if (Create.getMapID() == 1) {
			// Start coordinates for hero : 1, 15
			hero.setX(1);
			hero.setY(15);
		}
		else if (Create.getMapID() == 2) {
			// Start coordinates for hero : 4, 11
			hero.setX(4);
			hero.setY(11);
		}
		return hero;
	}
	
}
