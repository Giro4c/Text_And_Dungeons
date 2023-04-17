package the_game;

public class Teleport extends Entity {

	public Teleport(String name, int xTerminal1, int yTerminal1, int xTerminal2, int yTerminal2, boolean visible) {
		super(name, "Teleport");
		this.terminal1 = new Terminal(xTerminal1, yTerminal1, visible);
		this.terminal2 = new Terminal(xTerminal2, yTerminal2, visible);
	}

	public Teleport(String name, int xTerminal1, int yTerminal1, boolean visible1, int xTerminal2, int yTerminal2, boolean visible2) {
		super(name, "Teleport");
		this.terminal1 = new Terminal(xTerminal1, yTerminal1, visible1);
		this.terminal2 = new Terminal(xTerminal2, yTerminal2, visible2);
	}

	private Terminal terminal1;
	private Terminal terminal2;
	
	public Terminal getTerminal1() {
		return terminal1;
	}

	public void setTerminal1(Terminal terminal1) {
		this.terminal1 = terminal1;
	}

	public Terminal getTerminal2() {
		return terminal2;
	}

	public void setTerminal2(Terminal terminal2) {
		this.terminal2 = terminal2;
	}

	@Override
	public String toString() {
		String teleport = super.toString() + "Coordinates Terminal 1 : " + this.getTerminal1().getX() + ", " + this.getTerminal1().getY() + '\n';
		teleport = teleport + "Coordinates Terminal 2 : " + this.getTerminal2().getX() + ", " + this.getTerminal2().getY() + '\n';
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
        return super.equals(o) && this.getTerminal1().equals(teleport.getTerminal1()) && this.getTerminal2().equals(teleport.getTerminal2());
    }
	
}
