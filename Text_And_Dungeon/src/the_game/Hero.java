package the_game;

/**
 * The class representing the living entity Hero and all informations associated with it.
 * @author Camille Girodengo
 *
 */
public class Hero extends LivingEntity {
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Hero(String name) {
		super(name, "Hero");
		currentMaxHP = this.getHP();

	}
	
	public Hero(String name, int x, int y, int hP, int atk, int def, int vit) {
		super(name, "Hero", x, y, hP, atk, def, vit);
		currentMaxHP = hP;
	}

	public Hero(String name, int x, int y) {
		super(name, "Hero", x, y);
		currentMaxHP = this.getHP();
	}

	public Hero(String name, int hP, int atk, int def, int vit) {
		super(name, "Hero", hP, atk, def, vit);
		currentMaxHP = hP;
	}

	public Hero(String name, Weapon currentWeapon, Artifact currentArtifact) {
		super(name, "Hero");
		currentMaxHP = this.getHP();
		equipWeapon(currentWeapon);
		equipArtifact(currentArtifact);
		this.inventory.setWeapon(0, currentWeapon);
		this.inventory.setArtifact(0, currentArtifact);
	}
	
	public Hero(String name, int x, int y, Weapon currentWeapon, Artifact currentArtifact) {
		super(name, "Hero", x, y);
		currentMaxHP = this.getHP();
		equipWeapon(currentWeapon);
		equipArtifact(currentArtifact);
		this.inventory.setWeapon(0, currentWeapon);
		this.inventory.setArtifact(0, currentArtifact);
	}

	public Hero(String name, int x, int y, int hP, int atk, int def, int vit, Weapon currentWeapon, Artifact currentArtifact) {
		super(name, "Hero", x, y, hP, atk, def, vit);
		currentMaxHP = hP;
		equipWeapon(currentWeapon);
		equipArtifact(currentArtifact);
		this.inventory.setWeapon(0, currentWeapon);
		this.inventory.setArtifact(0, currentArtifact);
	}

	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int currentMaxHP;
	private Weapon currentWeapon;
	private Artifact currentArtifact;
	private Inventory inventory = new Inventory();
	private int level = 1;
	private int currentExp = 0;
	private double nextLevelExp = 100;
	private int specialActionCount = 0;
	private int specialLocation = 0;
	
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	public Artifact getCurrentArtifact() {
		return currentArtifact;
	}

	public void setCurrentArtifact(Artifact currentArtifact) {
		this.currentArtifact = currentArtifact;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public int getCurrentMaxHP() {
		return currentMaxHP;
	}

	public void setCurrentMaxHP(int currentMaxHP) {
		this.currentMaxHP = currentMaxHP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	public double getNextLevelExp() {
		return nextLevelExp;
	}

	public void setNextLevelExp(int nextLevelExp) {
		this.nextLevelExp = nextLevelExp;
	}

	public int getSpecialActionCount() {
		return specialActionCount;
	}

	/**
	 * Particular setter which updates other variables of hero if <code>specialActionCount</code> is set to a specific value.
	 * @param specialActionCount the new int value for <code>specialActionCount</code>
	 */
	public void setSpecialActionCount(int specialActionCount) {
		this.specialActionCount = specialActionCount;
		if (this.specialActionCount == 6) {
			this.specialLocation = 1;
			this.setX(17);
			this.setY(5);
		}
	}

	public int getSpecialLocation() {
		return specialLocation;
	}
	
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String name = "Name : " + this.getName() + '\n';
		String type = "Type : " + this.getType() + '\n';
		String coordinates = "Coordinates : x=" + this.getX() + " y=" + this.getY() + '\n';
		String level = "Level :" + this.level + '\n';
		String stats = "Statistics :" + '\n';
		stats = stats + '\t' + "HP : " + this.getHP() + "/" + this.currentMaxHP + '\n';
		stats = stats + '\t' + "Atk : " + this.getAtk() + '\n';
		stats = stats + '\t' + "Def : " + this.getDef() + '\n';
		stats = stats + '\t' + "Speed : " + this.getSpeed() + '\n';
		String weapon;
		if (this.currentWeapon == null) {
			weapon = "Equipped weapon : none";
		}
		else {
			weapon = "Equipped weapon : " + this.currentWeapon.getName();
		}
		String artifact;
		if (this.currentArtifact == null) {
			artifact = "Equipped artifact : none";
		}
		else {
			artifact = "Equipped artifact : " + this.currentArtifact.getName();
		}
		String exp = "Experience : " + this.currentExp + "/" + (int) this.nextLevelExp + " EXP" + '\n';
		return name + type + coordinates + level + stats + weapon + '\n' + artifact + '\n' + exp;
	}
	
	
	
	
	/* -------------------------------------------------------------------- *
	 * ----------------------------ALL METHODS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	/**
	 * Opens a known chest and add the items it contains if there is enough place in the inventory.
	 * @param chest a chest to open
	 */
	public void openChest(Chest chest) {
		int count;
		if (chest.getHiddenWeapon() != null) {
			count = 0;
			while (count < this.inventory.getWeapons().length) {
				if (this.inventory.getWeapons()[count] == null) {
					Message.getItem(this, chest.getHiddenWeapon());
					this.inventory.setWeapon(count, chest.getHiddenWeapon());
					chest.setHiddenWeapon(null);
					break;
				}
				++count;
			}
			if (count == this.inventory.getWeapons().length) {
				Message.cannotGetItem(this, chest.getHiddenWeapon());
			}
		}
		if (chest.getHiddenArtifact() != null) {
			count = 0;
			while (count < this.inventory.getArtifacts().length) {
				if (this.inventory.getArtifacts()[count] == null) {
					Message.getItem(this, chest.getHiddenArtifact());
					this.inventory.setArtifact(count, chest.getHiddenArtifact());
					chest.setHiddenArtifact(null);
					break;
				}
				++count;
			}
			if (count == this.inventory.getArtifacts().length) {
				Message.cannotGetItem(this, chest.getHiddenArtifact());
			}
		}
		if (chest.getHiddenPotion() != null) {
			count = 0;
			while (count < this.inventory.getPotions().length) {
				if (this.inventory.getPotions()[count] == null) {
					Message.getItem(this, chest.getHiddenPotion());
					this.inventory.setPotion(count, chest.getHiddenPotion());
					chest.setHiddenPotion(null);
					break;
				}
				++count;
			}
			if (count == this.inventory.getPotions().length) {
				Message.cannotGetItem(this, chest.getHiddenPotion());
			}
		}
	}
	
	/**
	 * Finds the chest right next to the hero in the direction given and opens it once found
	 * @param direction <p>the character representing the direction in which the function must find the chest.<br>
	 * The inputs associated to each cardinal direction is : 'z' -> Up, 's' -> Down, 'q' -> Left, 'd' -> Right.</p>
	 * @param chests an array of chests in which the function must find the chest to open
	 * @see #openChest(Chest)
	 * @deprecated No longer necessary since EntityIdentity class implementation
	 */
	public void openChest(char direction, Chest[] chests) {
		int chestX = this.getX();
		int chestY = this.getY();
		if (direction == 'z') { // Up
			--chestY;
		}
		else if (direction == 's') { // Down
			++chestY;
		}
		else if (direction == 'q') { // Left
			--chestX;
		}
		else if (direction == 'd') { // Right
			++chestX;
		}
		for (Chest chest : chests) {
			if (chestX == chest.getX() && chestY == chest.getY()) {
				openChest(chest);
				break;
			}
		}
	}
	
	/**
	 * Throws the weapon which is contained at a specific index in the Weapon array of the inventory
	 * @param nbElement the index of the weapon to throw
	 * @exception does not throw the weapon if it is currently equipped
	 */
	public void throwWeapon(int nbElement) {
		if (this.inventory.getWeapons()[nbElement] != this.currentWeapon) { // Weapon is not equipped ( != currentWeapon )
			Message.throwItem(this, this.inventory.getWeapons()[nbElement]);
			this.inventory.setWeapon(nbElement, null);
		}
		else { // Weapon is equipped, ( == currentWeapon )
			Message.cannotThrowItem(this, this.currentWeapon);
		}
	}
	
	/**
	 * Throws the artifact which is contained at a specific index in the Artifact array of the inventory
	 * @param nbElement the index of the artifact to throw
	 * @exception does not throw the artifact if it is currently equipped
	 */
	public void throwArtifact(int nbElement) {
		if (this.inventory.getArtifacts()[nbElement] != this.currentArtifact) { // Artifact is not equipped ( != currentArtifact )
			Message.throwItem(this, this.inventory.getArtifacts()[nbElement]);
			this.inventory.setArtifact(nbElement, null);
		}
		else { // Artifact is equipped, ( == currentArtifact )
			Message.cannotThrowItem(this, this.currentArtifact);
		}
	}
	
	/**
	 * Throws the potion which is contained at a specific index in the Potion array of the inventory
	 * @param nbElement the index of the potion to throw
	 */
	public void throwPotion(int nbElement) {
		Message.throwItem(this, this.inventory.getPotions()[nbElement]);
		this.inventory.setPotion(nbElement, null);
	}
	
	/**
	 * Checks if there is a hostile living entity in the direct vicinity of the hero
	 * @param enemies a array of common enemies
	 * @param bosses a array of boss enemies
	 * @return Whether or not an enemy is right next to the hero
	 */
	public boolean isEnemyAround(Enemy[] enemies, Boss[] bosses) {

		for (Enemy enemy : enemies) {
			if (enemy.getHP() > 0) {
				if (enemy.getY() == this.getY() - 1 && enemy.getX() == this.getX()) {
					return true;
				}
				else if (enemy.getY() == this.getY() + 1 && enemy.getX() == this.getX()) {
					return true;
				}
				else if (enemy.getX() == this.getX() - 1 && enemy.getY() == this.getY()) {
					return true;
				}
				else if (enemy.getX() == this.getX() + 1 && enemy.getY() == this.getY()) {
					return true;
				}
			}
		}
		for (Boss boss : bosses) {
			if (boss.getHP() > 0) {
				if (boss.getY() == this.getY() - 1 && boss.getX() == this.getX()) {
					return true;
				}
				else if (boss.getY() == this.getY() + 1 && boss.getX() == this.getX()) {
					return true;
				}
				else if (boss.getX() == this.getX() - 1 && boss.getY() == this.getY()) {
					return true;
				}
				else if (boss.getX() == this.getX() + 1 && boss.getY() == this.getY()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * Search the names and indexes of the enemies around the hero
	 * @param enemies a array of common enemies
	 * @param bosses a array of boss enemies
	 * @return <p>A EntityIdentity array of size 4. A case for each direction which contains the name and the index of the enemy next to the hero in this direction or <code>null</code> if there is no enemy.
	 * Association of index for each direction : 0 -> Up, 1 -> Right, 2 -> Down, 3 -> Left</p>
	 */
	public EntityIdentity[] whoIsAround(Enemy[] enemies, Boss[] bosses) {
		EntityIdentity[] enemiesNames = new EntityIdentity[4];
		for (int indexEnemy = 0; indexEnemy < enemies.length; ++indexEnemy) { 
			if (enemies[indexEnemy].getHP() > 0) {
				if (enemies[indexEnemy].getY() == this.getY() - 1 && enemies[indexEnemy].getX() == this.getX()) {
					enemiesNames[0] = new EntityIdentity(enemies[indexEnemy], indexEnemy);
				}
				else if (enemies[indexEnemy].getY() == this.getY() + 1 && enemies[indexEnemy].getX() == this.getX()) {
					enemiesNames[2] = new EntityIdentity(enemies[indexEnemy], indexEnemy);
				}
				else if (enemies[indexEnemy].getX() == this.getX() - 1 && enemies[indexEnemy].getY() == this.getY()) {
					enemiesNames[3] = new EntityIdentity(enemies[indexEnemy], indexEnemy);
				}
				else if (enemies[indexEnemy].getX() == this.getX() + 1 && enemies[indexEnemy].getY() == this.getY()) {
					enemiesNames[1] = new EntityIdentity(enemies[indexEnemy], indexEnemy);
				}
			}
		} 
		for (int indexBoss = 0; indexBoss < bosses.length; ++indexBoss) {
			if (bosses[indexBoss].getHP() > 0) {
				if (bosses[indexBoss].getY() == this.getY() - 1 && bosses[indexBoss].getX() == this.getX()) {
					enemiesNames[0] = new EntityIdentity(bosses[indexBoss], indexBoss);
				}
				else if (bosses[indexBoss].getY() == this.getY() + 1 && bosses[indexBoss].getX() == this.getX()) {
					enemiesNames[2] = new EntityIdentity(bosses[indexBoss], indexBoss);
				}
				else if (bosses[indexBoss].getX() == this.getX() - 1 && bosses[indexBoss].getY() == this.getY()) {
					enemiesNames[3] = new EntityIdentity(bosses[indexBoss], indexBoss);
				}
				else if (bosses[indexBoss].getX() == this.getX() + 1 && bosses[indexBoss].getY() == this.getY()) {
					enemiesNames[1] = new EntityIdentity(bosses[indexBoss], indexBoss);
				}
			}
		}
		
		return enemiesNames;
	}
	
	/**
	 * Replaces the currently equipped weapon by another one and updates the hero's stats depending on the stats bonuses the previous and current weapon have.
	 * @param newWeapon the new weapon to equip
	 */
	public void equipWeapon(Weapon newWeapon) {
		if (this.currentWeapon != null) {
			unEquipWeapon();
		}
		this.currentWeapon = newWeapon;
		Message.equips(this, this.currentWeapon);
		for (int i = 0; i < this.currentWeapon.getStatBonusNames().length; ++i) {
			if (this.currentWeapon.getStatBonusNames()[i] == "Attack") {
				this.setAtk(getAtk() + this.currentWeapon.getStatBonusValues()[i]);
			}
			else if (this.currentWeapon.getStatBonusNames()[i] == "Defense") {
				this.setDef(getDef() + this.currentWeapon.getStatBonusValues()[i]);
			}
			else if (this.currentWeapon.getStatBonusNames()[i] == "HP") {
				this.setHP(getHP() + this.currentWeapon.getStatBonusValues()[i]);
				this.currentMaxHP = this.currentMaxHP + this.currentWeapon.getStatBonusValues()[i];
			}
			else if (this.currentWeapon.getStatBonusNames()[i] == "Speed") {
				this.setSpeed(getSpeed() + this.currentWeapon.getStatBonusValues()[i]);
			}
		}
	}
	
	/**
	 * Replaces the currently equipped artifact by another one and updates the hero's stats depending on the stats bonuses the previous and current artifact have.
	 * @param newArtifact the new artifact to equip
	 */
	public void equipArtifact(Artifact newArtifact) {
		if (this.currentArtifact != null) {
			unEquipArtifact();
		}
		this.currentArtifact = newArtifact;
		Message.equips(this, this.currentArtifact);
		for (int i = 0; i < this.currentArtifact.getStatBonusNames().length; ++i) {
			if (this.currentArtifact.getStatBonusNames()[i] == "Attack") {
				this.setAtk(getAtk() + this.currentArtifact.getStatBonusValues()[i]);
			}
			else if (this.currentArtifact.getStatBonusNames()[i] == "Defense") {
				this.setDef(getDef() + this.currentArtifact.getStatBonusValues()[i]);
			}
			else if (this.currentArtifact.getStatBonusNames()[i] == "HP") {
				this.setHP(getHP() + this.currentArtifact.getStatBonusValues()[i]);
				this.currentMaxHP = this.currentMaxHP + this.currentArtifact.getStatBonusValues()[i];
			}
			else if (this.currentArtifact.getStatBonusNames()[i] == "Speed") {
				this.setSpeed(getSpeed() + this.currentArtifact.getStatBonusValues()[i]);
			}
		}
	}
	
	/**
	 * Unequips the weapon currently equipped and updates the hero's stats
	 */
	public void unEquipWeapon() {
		if (this.currentWeapon != null) {
			for (int i = 0; i < this.currentWeapon.getStatBonusNames().length; ++i) {
				if (this.currentWeapon.getStatBonusNames()[i] == "Attack") {
					this.setAtk(getAtk() - this.currentWeapon.getStatBonusValues()[i]);
				}
				else if (this.currentWeapon.getStatBonusNames()[i] == "Defense") {
					this.setDef(getDef() - this.currentWeapon.getStatBonusValues()[i]);
				}
				else if (this.currentWeapon.getStatBonusNames()[i] == "HP") {
					this.setHP(getHP() - this.currentWeapon.getStatBonusValues()[i]);
					this.currentMaxHP = this.currentMaxHP - this.currentWeapon.getStatBonusValues()[i];
				}
				else if (this.currentWeapon.getStatBonusNames()[i] == "Speed") {
					this.setSpeed(getSpeed() - this.currentWeapon.getStatBonusValues()[i]);
				}
			}
			Message.unEquips(this, this.currentWeapon);
			this.currentWeapon = null;
		}
		else {
			Message.notExists("Selected current Weapon");
		}
	}
	
	/**
	 * Unequips the artifact currently equipped and updates the hero's stats
	 */
	public void unEquipArtifact() {
		if (this.currentArtifact != null) {
			for (int i = 0; i < this.currentArtifact.getStatBonusNames().length; ++i) {
				if (this.currentArtifact.getStatBonusNames()[i] == "Attack") {
					this.setAtk(getAtk() - this.currentArtifact.getStatBonusValues()[i]);
				}
				else if (this.currentArtifact.getStatBonusNames()[i] == "Defense") {
					this.setDef(getDef() - this.currentArtifact.getStatBonusValues()[i]);
				}
				else if (this.currentArtifact.getStatBonusNames()[i] == "HP") {
					this.setHP(getHP() - this.currentArtifact.getStatBonusValues()[i]);
					this.currentMaxHP = this.currentMaxHP - this.currentArtifact.getStatBonusValues()[i];
				}
				else if (this.currentArtifact.getStatBonusNames()[i] == "Speed") {
					this.setSpeed(getSpeed() - this.currentArtifact.getStatBonusValues()[i]);
				}
			}
			Message.unEquips(this, this.currentArtifact);
			this.currentArtifact = null;
		}
		else {
			Message.notExists("Selected current Artifact");
		}
	}
	
	/**
	 * Uses a known potion and restore the hero's hp
	 * @param potion the known potion to use 
	 */
	public void usePotion(Potion potion) {
		if (potion.getStatBonusValues()[0] + this.getHP() > this.currentMaxHP) {
			int hpRecovered = this.currentMaxHP - this.getHP();
			this.setHP(currentMaxHP);
			Message.usesPotion(this, potion, hpRecovered);
		}
		else {
			this.setHP(this.getHP() + potion.getStatBonusValues()[0]);
			Message.usesPotion(this, potion, potion.getStatBonusValues()[0]);
		}
	}
	
	
	/**
	 * Find the potion associated with a certain index in the potion array in the inventory and uses it
	 * @param nbElement index of the potion in the potion array in the inventory
	 * @see #usePotion(Potion)
	 */
	public void usePotion(int nbElement) {
		this.usePotion(this.inventory.getPotions()[nbElement]);
		this.throwPotion(nbElement);
	}
	
	/**
	 * Verifies if the condition to level up has been met and updates the variables
	 * @see #nextLevel()
	 */
	private void checkLevel() {
		if (this.currentExp >= this.nextLevelExp) {
			this.currentExp = this.currentExp - (int)(this.nextLevelExp);
			nextLevel();
		}
	}
	
	/**
	 * Updates the variables and stats after the level up
	 */
	private void nextLevel() {
		 ++this.level;
		 this.nextLevelExp = this.nextLevelExp + Math.floor(this.nextLevelExp * (this.level - 1) * 0.1);
		 // Update HP
		 this.currentMaxHP = this.currentMaxHP + 5;
		 this.setHP(this.getHP() + 5);
		 // Update Attack
		 this.setAtk(this.getAtk() + 3);
		 // Update Defense
		 this.setDef(this.getDef() + 1);
		 // Update Speed
		 this.setSpeed(this.getSpeed() + 2);
		 Message.nextLevel(this);
	}
	
	/**
	 * Attack an <code>Enemy</code> and updates the current exp if the target's hp are bellow 1.
	 * @param target the <code>Enemy</code> to attack
	 * @see #attack(LivingEntity)
	 */
	public void attack(Enemy target) {
		super.attack(target);
		if (target.getHP() <= 0) {
			this.currentExp = this.currentExp + target.getExpGenerated();
			checkLevel();
		}
		
	}
	
	/**
	 * Check if there is an element at the hero's location that can be interacted with and returns what it is (type and index)
	 * @param teleports a Teleport array which contains all the teleports of the current map
	 * @return EntityIdentity ("None", -1) if nothing is under. Otherwise, a EntityIdentity which indicates which entity is under the hero and its index in the array it was found in. 
	 */
	public EntityIdentity checkUnder(Teleport[] teleports) {
		for (int indexTeleport = 0; indexTeleport < teleports.length; ++indexTeleport) {
			if ((teleports[indexTeleport].getxTerminal1() == this.getX() && teleports[indexTeleport].getyTerminal1() == this.getY()) || (teleports[indexTeleport].getxTerminal2() == this.getX() && teleports[indexTeleport].getyTerminal2() == this.getY())) {
				return new EntityIdentity(teleports[indexTeleport], indexTeleport);
			}
		}
		return new EntityIdentity(new Entity(null, "None"), -1);
	}
	
	/**
	 * The hero uses a teleport's terminal to appear where the paired terminal is located
	 * @param teleport the Teleport which will be interacted with.
	 */
	public void useTeleport(Teleport teleport) {
		if (teleport.getxTerminal1() == this.getX() && teleport.getyTerminal1() == this.getY()) {
			this.setX(teleport.getxTerminal2());
			this.setY(teleport.getyTerminal2());
			Message.usesTeleport(this, teleport, 2);
		}
		else if (teleport.getxTerminal2() == this.getX() && teleport.getyTerminal2() == this.getY()) {
			this.setX(teleport.getxTerminal1());
			this.setY(teleport.getyTerminal1());
			Message.usesTeleport(this, teleport, 1);
		}
	}
	
	/**
	 * Finds if a teleport terminal has the same coordinates and uses it.
	 * @param teleports a Teleport array which contains all the teleports of the current map
	 * @deprecated No longer necessary since EntityIdentity class implementation
	 */
	public void useTeleport(Teleport[] teleports) {
		for (Teleport teleport : teleports) {
			if (teleport.getxTerminal1() == this.getX() && teleport.getyTerminal1() == this.getY()) {
				this.useTeleport(teleport);
				break;
			}
			else if (teleport.getxTerminal2() == this.getX() && teleport.getyTerminal2() == this.getY()) {
				this.useTeleport(teleport);
				break;
			}
		}
	}


}
