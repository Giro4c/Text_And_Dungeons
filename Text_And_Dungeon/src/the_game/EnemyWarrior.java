package the_game;
/**
 * The class which represents a warrior enemy in the game.
 * @author Camille Girodengo
 *
 */
public class EnemyWarrior extends Enemy{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public EnemyWarrior(String name, int x, int y, boolean visible, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Opposing Warrior", x, y, visible, hP, atk, def, vit, expGenerated);
	}
	
}
