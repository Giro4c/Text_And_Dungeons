package the_game.monster_classes;

import the_game.Monster;

public class Slime extends Monster{

	public Slime(int numInSpecie, int x, int y, boolean visible) {
		super("Slime " + numInSpecie, x, y, visible, 10, 10, 10, 10, 30);
	}

}
