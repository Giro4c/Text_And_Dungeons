package the_game;
import java.util.Random;

import the_game.Deprecated_classes.Create;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		Message.mapChoice();
		Hero hero = Create.createHero();
		
		int[][] walls = Create.placeWalls();
//		System.out.print(walls.length);
//		System.out.print('\n');
		Chest[] chests = Create.placeChests();
		Enemy[] enemies = Create.spawnEnemies();
		Boss[] bosses = Create.spawBoss();
		
		Message.welcome2(Create.createMap(walls, chests, enemies, bosses, hero));
		
	}
	
	private static void swapInt(int[] intArray, int index1, int index2) {
		int container = intArray[index1];
		intArray[index1] = intArray[index2];
		intArray[index2] = container;
	}
	
	private static int[] shuffleIntArray(int[] intArray) {
		Random rand = new Random();
		int randIndex;
		for (int i = 0; i < intArray.length; ++i) {
			randIndex = rand.nextInt(intArray.length);
			swapInt(intArray, i, randIndex);
		}
		return intArray;
	}
	
	private static void showIntArray(int[] intArray) {
		for(int intVal : intArray) {
			System.out.print(intVal);
			System.out.print('\n');
		}
	}

	private static void stock() {
		
		
		
		
		
	}
	
}
