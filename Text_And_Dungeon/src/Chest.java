
public class Chest extends Entity{
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Chest(String name) {
		super(name, "Chest");
		this.hiddenWeapon = null;
		this.hiddenArtifact = null;
		this.hiddenPotion = null;
	}
	public Chest(String name, int x, int y) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
	}
	public Chest(String name, int x, int y, Weapon hiddenWeapon, Artifact hiddenArtifact) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenWeapon = hiddenWeapon;
		this.hiddenArtifact = hiddenArtifact;
	}
	public Chest(String name, int x, int y, Weapon hiddenWeapon, Potion hiddenPotion) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenWeapon = hiddenWeapon;
		this.hiddenPotion = hiddenPotion;
	}
	public Chest(String name, int x, int y, Weapon hiddenWeapon) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenWeapon = hiddenWeapon;
	}
	public Chest(String name, int x, int y, Artifact hiddenArtifact, Potion hiddenPotion) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenArtifact = hiddenArtifact;
		this.hiddenPotion = hiddenPotion;
	}
	public Chest(String name, int x, int y, Artifact hiddenArtifact) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenArtifact = hiddenArtifact;
	}
	public Chest(String name, int x, int y, Potion hiddenPotion) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenPotion = hiddenPotion;
	}
	public Chest(String name, int x, int y, Weapon hiddenWeapon, Artifact hiddenArtifact, Potion hiddenPotion) {
		super(name, "Chest");
		this.x = x;
		this.y = y;
		this.hiddenWeapon = hiddenWeapon;
		this.hiddenArtifact = hiddenArtifact;
		this.hiddenPotion = hiddenPotion;
	}


	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private int x = 0;
	private int y = 0;
	private Weapon hiddenWeapon = null;
	private Artifact hiddenArtifact = null;
	private Potion hiddenPotion = null;
	
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
		String chestContent = "Name : " + this.getName() + '\n' + "Location : x=" + this.x + " y=" + this.y + '\n';
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
	
}
