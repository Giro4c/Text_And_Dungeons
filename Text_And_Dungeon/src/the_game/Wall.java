package the_game;

/**
 * A class which represent a wall in the game
 * @author Camille Girodengo
 *
 */
public class Wall extends VisibleEntity{

	public Wall(int x, int y, boolean visible) {
		super(null, "Wall", x, y, visible);
	}

	public Wall() {
		super(null, "Wall", -1, -1, true);
	}
	
	
	
}
