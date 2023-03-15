package the_game.enemyWarrior_classes;

import the_game.EnemyWarrior;

public class Scout extends EnemyWarrior {

	public Scout(String name, int x, int y) {
		super(name, x, y, 70, 33, 17, 45, 80);
	}

	private static String[] names = inventNames();
	
	private static String[] inventNames() {
		String[] names = new String[5];
		
		names[0] = "Ser";
		names[1] = "Minimus";
		names[2] = "Starla";
		names[3] = "Proma";
		names[4] = "Speel";
		
		return names;
	}

	public static String[] getNames() {
		return names;
	}
	
}
