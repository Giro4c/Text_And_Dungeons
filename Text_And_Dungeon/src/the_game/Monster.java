package the_game;
/**
 * The class which represents a monster enemy in the game.
 * @author Camille Girodengo
 *
 */
public class Monster extends Enemy{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Monster(String name, int x, int y, boolean visible, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Monster", x, y, visible, hP, atk, def, vit, expGenerated);
	}
	
}
