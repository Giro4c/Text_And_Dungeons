package the_game;
/**
 * The class which represent a weapon item.
 * @author Camille Girodengo
 *
 */
public class Weapon extends Item {

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Weapon(String name, String[] statBonusNames, int[] statBonusValues) {
		super(name, "Weapon", statBonusNames, statBonusValues);
	} 

}
