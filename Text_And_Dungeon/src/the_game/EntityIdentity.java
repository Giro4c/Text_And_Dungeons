package the_game;

/**
 * A class used to avoid having to redo some verifications in Entity arrays. 
 * It contains the minimum of information to determine which array the entity belong to and its index in said array.
 * @author Camille Girodengo
 *
 */
public class EntityIdentity {

	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public EntityIdentity(Entity entity, int index) {
		super();
		this.entity = entity;
		this.index = index;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private Entity entity;
	private int index;

	public Entity getEntity() {
		return entity;
	}

	public int getIndex() {
		return index;
	}
	
	
}
