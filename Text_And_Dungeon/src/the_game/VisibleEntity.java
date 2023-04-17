package the_game;

public class VisibleEntity extends Entity{

	private int x = -1;
	private int y = -1;
	private boolean visible;

	public VisibleEntity(String name, String type, int x, int y, boolean visible) {
		super(name, type);
		this.x = x;
		this.y = y;
		this.visible = visible;
	}

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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return super.toString() + "Coordinates : x=" + this.x + " y=" + this.y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisibleEntity visibleEntity = (VisibleEntity) o;
        return super.equals(o) && this.x == visibleEntity.x && this.y == visibleEntity.y && this.visible == visibleEntity.visible;
	}
	
}
