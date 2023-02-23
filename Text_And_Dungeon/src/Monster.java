
public class Monster extends Enemy{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Monster(String name, int x, int y, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Monster", x, y, hP, atk, def, vit, expGenerated);

	}

	public Monster(String name, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Monster", hP, atk, def, vit, expGenerated);

	}

	public Monster(String name, int x, int y, int expGenerated) {
		super(name, "Monster", x, y, expGenerated);

	}

	public Monster(String name, int expGenerated) {
		super(name, "Monster", expGenerated);
		
	}
	
}
