package the_game;
/**
 * The class which represent any element of the game that has a name and a type.
 * @author Camille Girodengo
 *
 */
public class Entity {
	
	/* -------------------------------------------------------------------- *
	 * ---------------------------CONSTRUCTORS----------------------------- *
	 * -------------------------------------------------------------------- */
	
	public Entity(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * ------------------VARIABLES / GETTERS / SETTERS--------------------- *
	 * -------------------------------------------------------------------- */
	
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getFullName() {
		return this.type + " " + this.name;
	}
	
	
	
	/* -------------------------------------------------------------------- *
	 * -----------------------------TO STRING------------------------------ *
	 * -------------------------------------------------------------------- */
	
	public String toString() {
		String name = "Name : " + this.name;
		String type = "Type : " + this.type;
		return name + '\n' + type + '\n';
	}
	
	/* -------------------------------------------------------------------- *
	 * -------------------------------EQUALS------------------------------- *
	 * -------------------------------------------------------------------- */
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        if (this.name == null) {
        	if (entity.name != null) return false;
        }
        else if (this.name.equals(entity.name) != true) return false;
        if (this.type == null) {
        	if (entity.type != null) return false;
        }
        else if (this.type.equals(entity.type) != true) return false;
        
        return true;
    }
	
}
