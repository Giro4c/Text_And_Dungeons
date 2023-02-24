package the_game;
/**
 * The class which represents an artifact item in the game.
 * @author Camille Girodengo
 *
 */
public class Artifact extends Item{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */

	public Artifact(String name, String[] statBonusNames, int[] statBonusValues) {
		super(name, "Artifact", statBonusNames, statBonusValues);
	}
	
}
