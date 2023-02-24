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

	public Boss(String name, String type, String title, int x, int y, int hP, int atk, int def, int vit) {
		super(name, type + " Boss", x, y, hP, atk, def, vit);
		this.title = title;
	}

	public Boss(String name, String type, String title, int hP, int atk, int def, int vit) {
		super(name, type + " Boss", hP, atk, def, vit);
		this.title = title;
	}

	public Boss(String name, String type, String title, int x, int y) {
		super(name, type + " Boss", x, y);
		this.title = title;
	}

	public Boss(String name, String type, String title) {
		super(name, type + " Boss");
		this.title = title;
	}

	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
}
