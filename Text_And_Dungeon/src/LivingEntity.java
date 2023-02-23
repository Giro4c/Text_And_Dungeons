
public class LivingEntity extends Entity {
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public LivingEntity(String name, String type) {
		super(name, type);
	}
	
	public LivingEntity(String name, String type, int x, int y) {
		super(name, type);
		this.x = x;
		this.y = y;
	}

	public LivingEntity(String name, String type, int hP, int atk, int def, int spd) {
		super(name, type);
		HP = hP;
		Atk = atk;
		Def = def;
		Speed = spd;
	}

	public LivingEntity(String name, String type, int x, int y, int hP, int atk, int def, int spd) {
		super(name, type);
		this.x = x;
		this.y = y;
		HP = hP;
		Atk = atk;
		Def = def;
		Speed = spd;
	}



	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int x = 0;
	private int y = 0;
	private int HP = 100;
	private int Atk = 20;
	private int Def = 15;
	private int Speed = 20;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setHP(int hP) {
		HP = hP;
	}
	
	public int getAtk() {
		return Atk;
	}
	
	public void setAtk(int atk) {
		Atk = atk;
	}
	
	public int getDef() {
		return Def;
	}
	
	public void setDef(int def) {
		Def = def;
	}
	
	public int getSpeed() {
		return Speed;
	}
	
	public void setSpeed(int spd) {
		Speed = spd;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String coordinates = "Coordinates : x=" + this.x + " y=" + this.y;
		String stats = "Statistics :" + '\n';
		stats = stats + '\t' + "HP : " + this.HP + '\n';
		stats = stats + '\t' + "Atk : " + this.Atk + '\n';
		stats = stats + '\t' + "Def : " + this.Def + '\n';
		stats = stats + '\t' + "Speed : " + this.Speed;
		return super.toString() + coordinates + '\n' + stats + '\n';
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Verify if there is a wall, a chest or if the space is clear right next to the living entity in the given direction
	 * @param direction the direction to check
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @return "Wall" if there is a wall, "Chest" if there is a chest and "Clear" if there is nothing.
	 */
	public String verifyDirection (char direction, int[][] walls, Chest[] chests) {
		// Up
		if (direction == 'z') {
			if (this.y == 1 ) {
				return "Wall";
			}
			else {
				for (int[] wall : walls) {
					if (wall[1] == this.y - 1 && wall[0] == this.x) {
						return "Wall";
					}
				}
				for (Chest chest : chests) {
					if (chest.getY() == this.y - 1 && chest.getX() == this.x) {
						return "Chest";
					}
				}
				return "Clear";
			}
		}
		// Down
		else if (direction == 's') {
			if (this.y == Create.getMapLength() - 2) {
				return "Wall";
			}
			else {
				for (int[] wall : walls) {
					if (wall[1] == this.y + 1 && wall[0] == this.x) {
						return "Wall";
					}
				}
				for (Chest chest : chests) {
					if (chest.getY() == this.y + 1 && chest.getX() == this.x) {
						return "Chest";
					}
				}
				return "Clear";
			}
		}
		// Left
		else if (direction == 'q') {
			if (this.x == 1 ) {
				return "Wall";
			}
			else {
				for (int[] wall : walls) {
					if (wall[0] == this.x - 1 && wall[1] == this.y) {
						return "Wall";
					}
				}
				for (Chest chest : chests) {
					if (chest.getX() == this.x - 1 && chest.getY() == this.y) {
						return "Chest";
					}
				}
				return "Clear";
			}
		}
		// Right
		else if (direction == 'd') {
			if (this.x == Create.getMapLength() - 2) {
				return "Wall";
			}
			else {
				for (int[] wall : walls) {
					if (wall[0] == this.getX() + 1 && wall[1] == this.y) {
						return "Wall";
					}
				}
				for (Chest chest : chests) {
					if (chest.getX() == this.x + 1 && chest.getY() == this.y) {
						return "Chest";
					}
				}
				return "Clear";
			}
		}
		else {
			return "Error";
		}
	}
	
	// 0 : up, 1 : right, 2 : down, 3 : left
	/**
	 * Verify what is around the living entity in all four directions (up, right, down, left)
	 * @param walls an array of int arrays which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @return a String array. String[0] is for the direction "up", String[1] is for the direction "right", String[2] is for the direction "down", and String[3] is for the direction "left". Each equals either "Wall", "Chest" or "Clear"
	 * @see #verifyDirection(char, int[][], Chest[])
	 */
	public String[] verifySuroundings (int[][] walls, Chest[] chests) {
		String[] surroundings = new String[4];
		surroundings[0] = verifyDirection('z', walls, chests);
		surroundings[1] = verifyDirection('d', walls, chests);
		surroundings[2] = verifyDirection('s', walls, chests);
		surroundings[3] = verifyDirection('q', walls, chests);
		return surroundings;
		
	}
	
	/**
	 * Void to move on the map
	 * @param direction the direction in which the living entity must move
	 */
	public void move(char direction) {
		if (direction == 'z') { // Up
			--this.y;
		}
		else if (direction == 's') { // Down
			++this.y;
		}
		else if (direction == 'q') { // Left
			--this.x;
		}
		else if (direction == 'd') { // Right
			++this.x;
		}
		Message.moves(direction, this);
	}
	
	/**
	 * Void to attack another living entity
	 * @param target the living entity to attack
	 */
	public void attack(LivingEntity target) {
		if (target.getDef() >= this.Atk) {
			target.setHP(target.getHP()-1);
			Message.attacks(this, target, 1);
		}
		else {
			int damage = this.Atk - target.getDef();
			target.setHP(target.getHP()-damage);
			Message.attacks(this, target, damage);
		}
		if (target.getHP() <= 0) {
			Message.isKO(target);
		}
	}
	
}
