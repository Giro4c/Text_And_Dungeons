package the_game;

public class Teleport extends Entity {

	public Teleport(String name) {
		super(name, "Teleport");
	}

	public Teleport(String name, int xTerminal1, int yTerminal1, int xTerminal2, int yTerminal2) {
		super(name, "Teleport");
		this.terminal1[0] = xTerminal1;
		this.terminal1[1] = yTerminal1;
		this.terminal2[0] = xTerminal2;
		this.terminal2[1] = yTerminal2;
	}


	private int[] terminal1 = {-1, -1};
	private int[] terminal2 = {-1, -1};
	
	public int[] getTerminal1() {
		return terminal1;
	}
	public void setTerminal1(int[] terminal1) {
		if (terminal1.length == 2) {
			this.terminal1 = terminal1;
		}
	}
	public int getxTerminal1() {
		return this.terminal1[0];
	}
	public void setxTerminal1(int xTerminal1) {
		this.terminal1[0] = xTerminal1;
	}
	public int getyTerminal1() {
		return this.terminal1[1];
	}
	public void setyTerminal1(int yTerminal1) {
		this.terminal1[1] = yTerminal1;
	}
	
	public int[] getTerminal2() {
		return terminal2;
	}
	public void setTerminal2(int[] terminal2) {
		if (terminal2.length == 2) {
			this.terminal2 = terminal2;
		}	
	}
	public int getxTerminal2() {
		return terminal2[0];
	}
	public void setxTerminal2(int xTerminal2) {
		this.terminal2[0] = xTerminal2;
	}
	public int getyTerminal2() {
		return terminal2[1];
	}
	public void setyTerminal2(int yTerminal2) {
		this.terminal2[1] = yTerminal2;
	}
	
	@Override
	public String toString() {
		String teleport = super.toString() + "Coordinates Terminal 1 : " + this.getxTerminal1() + ", " + this.getyTerminal1() + '\n';
		teleport = teleport + "Coordinates Terminal 2 : " + this.getxTerminal2() + ", " + this.getyTerminal2() + '\n';
		return teleport;
	}
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teleport teleport = (Teleport) o;
        return super.equals(o) && this.getxTerminal1() == teleport.getxTerminal1() && this.getyTerminal1() == teleport.getyTerminal1()
        		&& this.getxTerminal2() == teleport.getxTerminal2() && this.getyTerminal2() == teleport.getyTerminal2();
    }
	
}
