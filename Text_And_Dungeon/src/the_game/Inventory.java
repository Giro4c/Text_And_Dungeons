package the_game;
/**
 * The class which represents a hero's inventory.
 * @author Camille Girodengo
 *
 */
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
	
	public void setWeapon(int nbElement, Weapon weapon) {
		this.weapons[nbElement] = weapon;
	}
	
	public Artifact[] getArtifacts() {
		return artifacts;
	}
	
	public void setArtifact(int nbElement, Artifact artifact) {
		this.artifacts[nbElement] = artifact;
	}
	
	public Potion[] getPotions() {
		return potions;
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
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        
        for (int indexWeapon = 0; indexWeapon < this.weapons.length; ++indexWeapon) {
        	if (this.weapons[indexWeapon] == null && inventory.weapons[indexWeapon] == null) continue;
        	if (this.weapons[indexWeapon].equals(inventory.weapons[indexWeapon]) == false) return false;
        }
        for (int indexArtifact = 0; indexArtifact < this.artifacts.length; ++indexArtifact) {
        	if (this.artifacts[indexArtifact] == null && inventory.artifacts[indexArtifact] == null) continue;
        	if (this.artifacts[indexArtifact].equals(inventory.artifacts[indexArtifact]) == false) return false;
        }
        for (int indexPotion = 0; indexPotion < this.potions.length; ++indexPotion) {
        	if (this.potions[indexPotion] == null && inventory.potions[indexPotion] == null) continue;
        	if (this.potions[indexPotion].equals(inventory.potions[indexPotion]) == false) return false;
        }
        
        return true;
    }
	
}
