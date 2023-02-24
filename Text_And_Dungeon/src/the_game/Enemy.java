package the_game;
/**
 * The class which represents an enemy in the game.
 * @author Camille Girodengo
 *
 */
public class Enemy extends LivingEntity {

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Enemy(String name, String type, int x, int y, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, type, x, y, hP, atk, def, vit);
		this.expGenerated = expGenerated;
	}

	public Enemy(String name, String type, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, type, hP, atk, def, vit);
		this.expGenerated = expGenerated;
	}

	public Enemy(String name, String type, int x, int y, int expGenerated) {
		super(name, type, x, y);
		this.expGenerated = expGenerated;
	}

	public Enemy(String name, String type, int expGenerated) {
		super(name, type);
		this.expGenerated = expGenerated;
	}

	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int expGenerated;
	
	public int getExpGenerated() {
		return expGenerated;
	}

	public void setExpGenerated(int expGenerated) {
		this.expGenerated = expGenerated;
	}

	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		return super.toString() + "Exp generated : " + this.expGenerated + '\n';
 	}
	
}
