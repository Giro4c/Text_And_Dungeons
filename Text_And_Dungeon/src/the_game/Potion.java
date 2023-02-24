package the_game;
/**
 * The class which represent a potion item.
 * @author Camille Girodengo
 *
 */
public class Potion extends Item{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Potion(String name, String[] statBonusNames, int[] statBonusValues) {
		super(name, "Potion", statBonusNames, statBonusValues);
	}

	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String name = "Name : " + this.getName();
		String type = "Type : " + this.getType();
		return name + '\n' + type + '\n' + "Healing Power : +" + this.getStatBonusValues()[0] + "HP" + '\n';
	}
	
}
