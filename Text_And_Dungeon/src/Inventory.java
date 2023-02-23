
public class Inventory {
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Inventory() {
		super();
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private final String[] inventoryItemTypes = {"Weapon", "Artifact", "Potion"};
	private Weapon[] weapons = new Weapon[2];
	private Artifact[] artifacts = new Artifact[3];
	private Potion[] potions = new Potion[5];
	
	public String[] getInventoryitemtypes() {
		return inventoryItemTypes;
	}
	
	public Weapon[] getWeapons() {
		return weapons;
	}
	
	public void setWeapons(Weapon[] weapons) {
		this.weapons = weapons;
	}
	
	public void setWeapon(int nbElement, Weapon weapon) {
		this.weapons[nbElement] = weapon;
	}
	
	public Artifact[] getArtifacts() {
		return artifacts;
	}
	
	public void setArtifacts(Artifact[] artifacts) {
		this.artifacts = artifacts;
	}
	
	public void setArtifact(int nbElement, Artifact artifact) {
		this.artifacts[nbElement] = artifact;
	}
	
	public Potion[] getPotions() {
		return potions;
	}
	
	public void setPotions(Potion[] potions) {
		this.potions = potions;
	}
	
	public void setPotion(int nbElement, Potion potion) {
		this.potions[nbElement] = potion;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	public String toString() {
		String weaponsNames = "Weapons :" + '\n';
		int i = 1;
		for (Weapon weapon : this.weapons) {
			if (weapon == null) {
				weaponsNames = weaponsNames + '\t' + i + ": " + "None" + '\n';
			}
			else {
				weaponsNames = weaponsNames + '\t' + i + ": " + weapon.getName() + '\n';
			}
			++i;
		}
		String artifactsNames = "Artifacts :" + '\n';
		i = 1;
		for (Artifact artifact : this.artifacts) {
			if (artifact == null) {
				artifactsNames = artifactsNames + '\t' + i + ": " + "None" + '\n';
			}
			else {
				artifactsNames = artifactsNames + '\t' + i + ": " + artifact.getName() + '\n';
			}
			++i;
		}
		String potionsNames = "Potions :" + '\n';
		i = 1;
		for (Potion potion : this.potions) {
			if (potion == null) {
				potionsNames = potionsNames + '\t' + i + ": " + "None" + '\n';
			}
			else {
				potionsNames = potionsNames + '\t' + i + ": " + potion.getName() + '\n';
			}
			++i;
		}
		return "Inventory :" + '\n' + weaponsNames + artifactsNames + potionsNames;
	}
	
}
