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
	
	public Enemy(String name, String type, int x, int y, boolean visible, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, type, x, y, visible, hP, atk, def, vit);
		this.expGenerated = expGenerated;
	}

	public Enemy(String name, String type, int x, int y, boolean visible, int expGenerated) {
		super(name, type, x, y, visible);
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
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enemy enemy = (Enemy) o;
        return super.equals(o) && this.expGenerated == enemy.expGenerated;
    }
	
}
