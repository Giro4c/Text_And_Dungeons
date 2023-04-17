package the_game;

import the_game.create.Create;

/**
 * The class which represent any entity that can be defeated in the game.
 * @author Camille Girodengo
 *
 */
public class LivingEntity extends VisibleEntity {
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public LivingEntity(String name, String type, int x, int y, boolean visible) {
		super(name, type, x, y, visible);
	}

	public LivingEntity(String name, String type, int x, int y, boolean visible, int hP, int atk, int def, int spd) {
		super(name, type, x, y, visible);
		HP = hP;
		Atk = atk;
		Def = def;
		Speed = spd;
	}



	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int HP = 100;
	private int Atk = 20;
	private int Def = 15;
	private int Speed = 20;
	
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
		String stats = "Statistics :" + '\n';
		stats = stats + '\t' + "HP : " + this.HP + '\n';
		stats = stats + '\t' + "Atk : " + this.Atk + '\n';
		stats = stats + '\t' + "Def : " + this.Def + '\n';
		stats = stats + '\t' + "Speed : " + this.Speed;
		return super.toString() + '\n' + stats + '\n';
	}
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivingEntity livingEntity = (LivingEntity) o;
        return super.equals(o) && this.Atk == livingEntity.Atk && this.Def == livingEntity.Def 
        		&& this.HP == livingEntity.HP && this.Speed == livingEntity.Speed;
    }
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Verify if there is a wall, a chest or if the space is clear right next to the living entity in the given direction
	 * @param direction the direction to check
	 * @param walls a Wall array which contains the location of all walls of the map except the borders.
	 * @param chests a Chest array which contains the location of all the chests of the map
	 * @return <ul>
	 * 	<li>(new Wall(), index in the Wall array) if there is a wall that is not a border</li>
	 * 	<li>(new Wall(), -1) if there is a wall border</li>
	 * 	<li>(a Chest, its index in the chest array) if there is a chest</li>
	 * 	<li>("None", -1) if there is nothing</li>
	 * 	</ul>
	 */
	public EntityIdentity verifyDirection (char direction, Wall[] walls, Chest[] chests) {
		// Up
		if (direction == 'z') {
			if (this.getY() == 1 ) {
				return new EntityIdentity(new Wall(), -1);
			}
			else {
				for (int indexWall = 0; indexWall < walls.length; ++indexWall) {
					if (walls[indexWall].getY() == this.getY() - 1 && walls[indexWall].getX() == this.getX()) {
						return new EntityIdentity(walls[indexWall], indexWall);
					}
				}
				for (int indexChest = 0; indexChest < chests.length; ++indexChest) {
					if (chests[indexChest].getY() == this.getY() - 1 && chests[indexChest].getX() == this.getX()) {
						return new EntityIdentity(chests[indexChest], indexChest);
					}
				}
				return new EntityIdentity(new Entity(null, "None"), -1);
			}
		}
		// Down
		else if (direction == 's') {
			if (this.getY() == Create.getMapLength() - 2) {
				return new EntityIdentity(new Wall(), -1);
			}
			else {
				for (int indexWall = 0; indexWall < walls.length; ++indexWall) {
					if (walls[indexWall].getY() == this.getY() + 1 && walls[indexWall].getX() == this.getX()) {
						return new EntityIdentity(walls[indexWall], indexWall);
					}
				}
				for (int indexChest = 0; indexChest < chests.length; ++indexChest) {
					if (chests[indexChest].getY() == this.getY() + 1 && chests[indexChest].getX() == this.getX()) {
						return new EntityIdentity(chests[indexChest], indexChest);
					}
				}
				return new EntityIdentity(new Entity(null, "None"), -1);
			}
		}
		// Left
		else if (direction == 'q') {
			if (this.getX() == 1 ) {
				return new EntityIdentity(new Wall(), -1);
			}
			else {
				for (int indexWall = 0; indexWall < walls.length; ++indexWall) {
					if (walls[indexWall].getX() == this.getX() - 1 && walls[indexWall].getY() == this.getY()) {
						return new EntityIdentity(walls[indexWall], indexWall);
					}
				}
				for (int indexChest = 0; indexChest < chests.length; ++indexChest) {
					if (chests[indexChest].getX() == this.getX() - 1 && chests[indexChest].getY() == this.getY()) {
						return new EntityIdentity(chests[indexChest], indexChest);
					}
				}
				return new EntityIdentity(new Entity(null, "None"), -1);
			}
		}
		// Right
		else if (direction == 'd') {
			if (this.getX() == Create.getMapLength() - 2) {
				return new EntityIdentity(new Wall(), -1);
			}
			else {
				for (int indexWall = 0; indexWall < walls.length; ++indexWall) {
					if (walls[indexWall].getX() == this.getX() + 1 && walls[indexWall].getY() == this.getY()) {
						return new EntityIdentity(walls[indexWall], indexWall);
					}
				}
				for (int indexChest = 0; indexChest < chests.length; ++indexChest) {
					if (chests[indexChest].getX() == this.getX() + 1 && chests[indexChest].getY() == this.getY()) {
						return new EntityIdentity(chests[indexChest], indexChest);
					}
				}
				return new EntityIdentity(new Entity(null, "None"), -1);
			}
		}
		else {
			return new EntityIdentity(null, -1);
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
	public EntityIdentity[] verifySuroundings (Wall[] walls, Chest[] chests) {
		EntityIdentity[] surroundings = new EntityIdentity[4];
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
			this.setY(this.getY() - 1);
		}
		else if (direction == 's') { // Down
			this.setY(this.getY() + 1);
		}
		else if (direction == 'q') { // Left
			this.setX(this.getX() - 1);
		}
		else if (direction == 'd') { // Right
			this.setX(this.getX() + 1);
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
