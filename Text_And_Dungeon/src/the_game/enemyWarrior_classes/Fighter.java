package the_game.enemyWarrior_classes;

import the_game.EnemyWarrior;

public class Fighter extends EnemyWarrior {

	public Fighter(String name, int x, int y) {
		super(name, x, y, 65, 42, 10, 25, 100);
	}
	
	private static String[] names = inventNames();
	
	private static String[] inventNames() {
		String[] names = new String[5];
		
		names[0] = "Demodeus";
		names[1] = "Demlyr";
		names[2] = "Alexander";
		names[3] = "Heracles";
		names[4] = "Timael";
		
		return names;
	}

	public static String[] getNames() {
		return names;
	}

}
