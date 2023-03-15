package the_game.enemyWarrior_classes;

import the_game.EnemyWarrior;

public class Valky extends EnemyWarrior{

	public Valky(String name, int x, int y) {
		super(name, x, y, 120, 40, 5, 35, 100);
	}
	
	private static String[] names = inventNames();
	
	private static String[] inventNames() {
		String[] names = new String[5];
		
		names[0] = "Agatha";
		names[1] = "Catherin";
		names[2] = "Valentia";
		names[3] = "Lessly";
		names[4] = "Palma";
		
		return names;
	}

	public static String[] getNames() {
		return names;
	}
	
}
