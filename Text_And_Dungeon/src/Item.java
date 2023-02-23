
public class Item extends Entity{
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Item(String name, String type, String[] statBonusNames, int[] statBonusValues) {
		super(name, type);
		this.statBonusNames = statBonusNames;
		this.statBonusValues = statBonusValues;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private String[] statBonusNames;
	private int[] statBonusValues;
	
	public String[] getStatBonusNames() {
		return statBonusNames;
	}
	
	public void setStatBonusNames(String[] statBonusNames) {
		this.statBonusNames = statBonusNames;
	}
	
	public int[] getStatBonusValues() {
		return statBonusValues;
	}
	
	public void setStatBonusValue(int[] statBonusValues) {
		this.statBonusValues = statBonusValues;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		String bonus = "Attributes :" + '\n';
		for (int i = 0; i < this.statBonusNames.length; ++i) {
			bonus = bonus + '\t' + this.statBonusNames[i] + " ";
			if (this.statBonusValues[i] >= 0) {
				bonus = bonus + "+";
			}
			bonus = bonus + this.statBonusValues[i] + '\n';
		}
		return super.toString() + bonus;
	}
	
}
