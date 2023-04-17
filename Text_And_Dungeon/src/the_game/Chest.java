package the_game;
/**
 * The class which represents a chest in the game.
 * @author Camille Girodengo
 *
 */
public class Chest extends VisibleEntity{
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Chest(String name, int x, int y, boolean visible, Weapon hiddenWeapon, Artifact hiddenArtifact, Potion hiddenPotion) {
		super(name, "Chest", x, y, visible);
		this.hiddenWeapon = hiddenWeapon;
		this.hiddenArtifact = hiddenArtifact;
		this.hiddenPotion = hiddenPotion;
	}


	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private Weapon hiddenWeapon;
	private Artifact hiddenArtifact;
	private Potion hiddenPotion;
	
	public Weapon getHiddenWeapon() {
		return hiddenWeapon;
	}
	
	public void setHiddenWeapon(Weapon hiddenWeapon) {
		this.hiddenWeapon = hiddenWeapon;
	}
	
	public Artifact getHiddenArtifact() {
		return hiddenArtifact;
	}
	
	public void setHiddenArtifact(Artifact hiddenArtifact) {
		this.hiddenArtifact = hiddenArtifact;
	}
	
	public Potion getHiddenPotion() {
		return hiddenPotion;
	}
	
	public void setHiddenPotion(Potion hiddenPotion) {
		this.hiddenPotion = hiddenPotion;
	}

	

	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String chestContent = "Name : " + this.getName() + '\n' + "Location : x=" + this.getX() + " y=" + this.getY() + '\n';
		if (this.hiddenWeapon != null) {
			chestContent = chestContent + '\t' + "- " + this.hiddenWeapon.getFullName() + '\n';
		}
		if (this.hiddenArtifact != null) {
			chestContent = chestContent + '\t' + "- " + this.hiddenArtifact.getFullName() + '\n';
		}
		if (this.hiddenPotion != null) {
			chestContent = chestContent + '\t' + "- " + this.hiddenPotion.getFullName() + '\n';
		}
		if (this.hiddenWeapon == null && this.hiddenArtifact == null && this.hiddenPotion == null) {
			chestContent = chestContent + "This " + this.getType() + " is empty." + '\n';
		}
		return chestContent;
	}
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chest chest = (Chest) o;
        boolean equals = true;
        // To prevent null pointer exceptions from appearing each time the hidden artifact of this is null
        if (this.hiddenArtifact == null) {
        	if (chest.hiddenArtifact != null) return false;
        }
        else {
        	equals = this.hiddenArtifact.equals(chest.hiddenArtifact);
        }
        // To prevent null pointer exceptions from appearing each time the hidden weapon of this is null
        if (this.hiddenWeapon == null) {
        	if (chest.hiddenWeapon != null) return false;
        }
        else {
        	equals = equals && this.hiddenWeapon.equals(chest.hiddenWeapon);
        }
        // To prevent null pointer exceptions from appearing each time the hidden potion of this is null
        if (this.hiddenPotion == null) {
        	if (chest.hiddenPotion != null) return false;
        }
        else {
        	equals = equals && this.hiddenPotion.equals(chest.hiddenPotion);
        }
        
        return super.equals(o) && equals;
    }
	
}
