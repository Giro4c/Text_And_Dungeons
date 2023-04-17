package the_game;
/**
 * The class which represent a special type of hostile living entity known as Boss. 
 * @author Camille Girodengo
 *
 */
public class Boss extends LivingEntity {

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */

	public Boss(String name, String type, String title, int numPhases, int x, int y, boolean visible, int hP, int atk, int def, int vit) {
		super(name, type + " Boss", x, y, visible, hP, atk, def, vit);
		this.title = title;
		this.NUM_PHASES = numPhases;
		this.currentPhase = 1;
		// Initialize phase stats arrays
		this.phasesStatHp = new int[numPhases];
		this.phasesStatAtk = new int[numPhases];
		this.phasesStatDef = new int[numPhases];
		this.phasesStatSpd = new int[numPhases];
		// Initialize stats for all phases
		for (int numPhase = 1; numPhase <= this.NUM_PHASES; ++numPhase) {
			this.setPhaseStats(numPhase, hP, atk, def, vit);
		}
	}


	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private String title;
	private final int NUM_PHASES;
	private int currentPhase;
	private int[] phasesStatHp;
	private int[] phasesStatAtk;
	private int[] phasesStatDef;
	private int[] phasesStatSpd;
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCurrentPhase() {
		return currentPhase;
	}

	public void setCurrentPhase(int currentPhase) {
		if (currentPhase <= NUM_PHASES) {
			this.currentPhase = currentPhase;
			this.setHP(this.phasesStatHp[currentPhase - 1]);
			this.setAtk(this.phasesStatAtk[currentPhase - 1]);
			this.setDef(this.phasesStatDef[currentPhase - 1]);
			this.setSpeed(this.phasesStatSpd[currentPhase - 1]);
		}
	}

	public int[] getPhasesStatHp() {
		return phasesStatHp;
	}

	public void setPhasesStatHp(int[] phasesStatHp) {
		this.phasesStatHp = phasesStatHp;
	}

	public int[] getPhasesStatAtk() {
		return phasesStatAtk;
	}

	public void setPhasesStatAtk(int[] phasesStatAtk) {
		this.phasesStatAtk = phasesStatAtk;
	}

	public int[] getPhasesStatDef() {
		return phasesStatDef;
	}

	public void setPhasesStatDef(int[] phasesStatDef) {
		this.phasesStatDef = phasesStatDef;
	}

	public int[] getPhasesStatSpd() {
		return phasesStatSpd;
	}

	public void setPhasesStatSpd(int[] phasesStatSpd) {
		this.phasesStatSpd = phasesStatSpd;
	}

	public int getNUM_PHASES() {
		return NUM_PHASES;
	}
	
	public void setPhaseStats(int numPhase, int hP, int atk, int def, int speed) {
		if (numPhase > 0 && numPhase <= NUM_PHASES) {
			this.phasesStatHp[numPhase - 1] = hP;
			this.phasesStatAtk[numPhase - 1] = atk;
			this.phasesStatDef[numPhase - 1] = def;
			this.phasesStatSpd[numPhase - 1] = speed;
		}
	}

	@Override
	public String getFullName() {
		return super.getFullName() + ", " + this.title;
	}
	
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String name = "Name : " + this.getName() + ", " + this.title + '\n';
		String type = "Type : " + this.getType() + '\n';
		String coordinates = "Coordinates : x=" + this.getX() + " y=" + this.getY() + '\n';
		String stats = "Statistics :" + '\n';
		stats = stats + '\t' + "HP : " + this.getHP() + '\n';
		stats = stats + '\t' + "Atk : " + this.getAtk() + '\n';
		stats = stats + '\t' + "Def : " + this.getDef() + '\n';
		stats = stats + '\t' + "Speed : " + this.getSpeed() + '\n';
		return name + type + coordinates + stats;
	}
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boss boss = (Boss) o;
        for (int numPhase = 0; numPhase < this.NUM_PHASES; ++numPhase) {
			if (this.phasesStatHp[numPhase] != boss.phasesStatHp[numPhase] || this.phasesStatAtk[numPhase] != boss.phasesStatAtk[numPhase]
					|| this.phasesStatDef[numPhase] != boss.phasesStatDef[numPhase] || this.phasesStatSpd[numPhase] != boss.phasesStatSpd[numPhase]) return false;
		}
        return super.equals(o) && this.title.equals(boss.title) && this.NUM_PHASES == boss.NUM_PHASES && this.currentPhase == boss.currentPhase;
    }
	
}
