
public class EnemyWarrior extends Enemy{

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public EnemyWarrior(String name, int x, int y, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Opposing Warrior", x, y, hP, atk, def, vit, expGenerated);
		// TODO Auto-generated constructor stub
	}

	public EnemyWarrior(String name, int hP, int atk, int def, int vit, int expGenerated) {
		super(name, "Opposing Warrior", hP, atk, def, vit, expGenerated);
		// TODO Auto-generated constructor stub
	}

	public EnemyWarrior(String name, int x, int y, int expGenerated) {
		super(name, "Opposing Warrior", x, y, expGenerated);
		// TODO Auto-generated constructor stub
	}

	public EnemyWarrior(String name, int expGenerated) {
		super(name, "Opposing Warrior", expGenerated);
		// TODO Auto-generated constructor stub
	}
	
}
