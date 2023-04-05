package the_game;

public class EntityIdentity {

	private Entity entity;
	private int index;
	
	public EntityIdentity(Entity entity, int index) {
		super();
		this.entity = entity;
		this.index = index;
	}

	public Entity getEntity() {
		return entity;
	}

	public int getIndex() {
		return index;
	}
	
}
