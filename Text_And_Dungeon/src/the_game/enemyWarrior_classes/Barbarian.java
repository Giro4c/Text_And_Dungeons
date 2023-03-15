package the_game.enemyWarrior_classes;

import the_game.EnemyWarrior;

public class Barbarian extends EnemyWarrior{

	public Barbarian(String name, int x, int y) {
		super(name, x, y, 80, 25, 15, 15, 65);
	}
	
	private static String[] names = inventNames();
		
	private static String[] inventNames() {
		String[] names = new String[5];
		
		names[0] = "Goliath";
		names[1] = "Gladius";
		names[2] = "Lysandre";
		names[3] = "Lucius";
		names[4] = "Gladiator";
		
		return names;
	}

	public static String[] getNames() {
		return names;
	}
	
	
	
}
