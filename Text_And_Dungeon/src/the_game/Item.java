package the_game;
/**
 * The class which represents any item that can be used or equipped in the game.
 * @author Camille Girodengo
 *
 */
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
	
	
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        if (this.statBonusNames.length != item.statBonusNames.length || this.statBonusValues.length != item.statBonusValues.length) return false;
        for (int indexStat = 0; indexStat < this.statBonusNames.length; ++indexStat) {
        	if (this.statBonusNames[indexStat].equals(item.statBonusNames[indexStat]) == false || this.statBonusValues[indexStat] != item.statBonusValues[indexStat]) return false;
        }
        return super.equals(o);
    }
	
}
