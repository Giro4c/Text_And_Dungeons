package the_game.enemyWarrior_classes;

import the_game.EnemyWarrior;

public class Defender extends EnemyWarrior{

	public Defender(String name, int x, int y, boolean visible) {
		super(name, x, y, visible, 100, 20, 30, 12, 65);
	}
	
	private static String[] names = inventNames();
	
	private static String[] inventNames() {
		String[] names = new String[5];
		
		names[0] = "Archibald";
		names[1] = "Maximilian";
		names[2] = "Cornelius";
		names[3] = "Altheus";
		names[4] = "Mercurio";
		
		return names;
	}

	public static String[] getNames() {
		return names;
	}
	
}
