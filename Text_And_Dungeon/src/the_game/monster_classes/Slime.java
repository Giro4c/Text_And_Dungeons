package the_game.monster_classes;

import the_game.Monster;

public class Slime extends Monster{

	public Slime(int numInSpecie, int x, int y) {
		super("Slime " + numInSpecie, x, y, 10, 10, 10, 10, 30);
	}

}
