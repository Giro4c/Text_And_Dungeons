package the_game;
/**
 * The class which contains basic characteristics of the dungeon.
 * @author Camille Girodengo
 * @deprecated No longer used, all informations transfered to class {@link Create}.
 */
public class Dungeon {
	
	public Dungeon() {
		super();
	}
	
	private final int WIDTH = 20;
	
	private final int LENGHT = 20;
	
	private int[][] locWalls = vectorWalls();
	
	private int[][] vectorWalls(){
		int[][] walls = new int[33][2];
		// All the walls that are not extremities :
		walls[0][0] = 1;
		walls[0][1] = 1;
		
		walls[1][0] = 1;
		walls[1][1] = 14;
		
		walls[2][0] = 1;
		walls[2][1] = 16;
		
		walls[3][0] = 5;
		walls[3][1] = 12;
		
		walls[4][0] = 5;
		walls[4][1] = 11;
		
		walls[5][0] = 5;
		walls[5][1] = 18;
		
		walls[6][0] = 6;
		walls[6][1] = 12;
		
		walls[7][0] = 6;
		walls[7][1] = 11;
		
		walls[8][0] = 6;
		walls[8][1] = 17;
		
		walls[9][0] = 7;
		walls[9][1] = 17;
		
		walls[10][0] = 8;
		walls[10][1] = 17;
		
		walls[11][0] = 9;
		walls[11][1] = 17;
		
		walls[12][0] = 10;
		walls[12][1] = 17;
		
		walls[13][0] = 11;
		walls[13][1] = 18;
		
		walls[14][0] = 12;
		walls[14][1] = 1;
		
		walls[15][0] = 12;
		walls[15][1] = 18;
		
		walls[16][0] = 13;
		walls[16][1] = 2;
		
		walls[17][0] = 14;
		walls[17][1] = 3;
		
		walls[18][0] = 14;
		walls[18][1] = 4;
		
		walls[19][0] = 14;
		walls[19][1] = 5;
		
		walls[20][0] = 14;
		walls[20][1] = 13;
		
		walls[21][0] = 15;
		walls[21][1] = 6;
		
		walls[22][0] = 15;
		walls[22][1] = 12;
		
		walls[23][0] = 15;
		walls[23][1] = 13;
		
		walls[24][0] = 16;
		walls[24][1] = 7;
		
		walls[25][0] = 16;
		walls[25][1] = 12;
		
		walls[26][0] = 16;
		walls[26][1] = 14;
		
		walls[27][0] = 17;
		walls[27][1] = 7;
		
		walls[28][0] = 17;
		walls[28][1] = 12;
		
		walls[29][0] = 17;
		walls[29][1] = 14;
		
		walls[30][0] = 18;
		walls[30][1] = 7;
		
		walls[31][0] = 18;
		walls[31][1] = 12;
		
		walls[32][0] = 18;
		walls[32][1] = 14;
		
		return walls;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getLenght() {
		return LENGHT;
	}
	
	public int[][] getLocWalls() {
		return locWalls;
	}

	public void setLocWalls(int[][] locWalls) {
		this.locWalls = locWalls;
	}
	
}
