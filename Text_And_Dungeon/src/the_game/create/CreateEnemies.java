package the_game.create;

import the_game.Enemy;
import the_game.enemyWarrior_classes.*;
import the_game.monster_classes.*;

public class CreateEnemies {

	/**
	 * Create a Enemy array which contains all the enemies of this map.<br>
	 * Can be upgraded to include an <code>int</code> parameter which would indicate which map to create (in case more maps are added to the game)
	 * @return a Enemy array which contains all the enemies of this map
	 */
	public static Enemy[] spawnEnemies() {
		if (Create.getMapID() == 1) {
			Enemy[] enemies = new Enemy[26];
			enemies[0] = new Monglr(1, 17, 17);
			enemies[1] = new Monglr(2, 15, 10);
			enemies[2] = new Slime(1, 14, 15);
			enemies[3] = new Slime(2, 11, 4);
			enemies[4] = new Altriss(1, 3, 3);
			enemies[5] = new Altriss(2, 6, 3);
			enemies[6] = new Altriss(3, 9, 3);
			enemies[7] = new Typhru(1, 1, 5);
			enemies[8] = new Typhru(2, 1, 7);
			enemies[9] = new Typhru(3, 2, 6);
			enemies[10] = new Talphru(1, 2, 5);
			enemies[11] = new Talphru(2, 2, 7);
			enemies[12] = new Slime(3, 3, 18);
			enemies[13] = new Slime(4, 4, 16);
			enemies[14] = new Slime(5, 4, 18);
			enemies[15] = new Monglr(3, 14, 9);
			enemies[16] = new Altriss(4, 15, 18);
			enemies[17] = new Venna(1, 16, 8);
			
			enemies[18] = new Barbarian(Barbarian.getNames()[0], 8, 11);
			enemies[19] = new Barbarian(Barbarian.getNames()[1], 8, 12);
			enemies[20] = new Defender(Defender.getNames()[0], 7, 10);
			enemies[21] = new Defender(Defender.getNames()[1], 7, 13);
			enemies[22] = new Barbarian(Barbarian.getNames()[2], 7, 7);
			enemies[23] = new Defender(Defender.getNames()[2], 8, 6);
			enemies[24] = new Valky(Valky.getNames()[0], 10, 14);
			enemies[25] = new Valky(Valky.getNames()[1], 12, 17);
			
			return enemies;
		}
		else if (Create.getMapID() == 2) {
			Enemy[] enemies = new Enemy[91];
			// Monglr
			enemies[0] = new Monglr(1, 14, 1);
			enemies[1] = new Monglr(2, 14, 4);
			enemies[2] = new Monglr(3, 18, 8);
			enemies[3] = new Monglr(4, 39, 15);
			enemies[4] = new Monglr(5, 31, 23);
			enemies[5] = new Monglr(6, 32, 23);
			enemies[6] = new Monglr(7, 33, 29);
			enemies[7] = new Monglr(8, 22, 35);
			enemies[8] = new Monglr(9, 35, 42);
			enemies[9] = new Monglr(10, 6, 44);
			// Writlor
			enemies[10] = new Writlor(1, 16, 2);
			enemies[11] = new Writlor(2, 16, 3);
			enemies[12] = new Writlor(3, 20, 11);
			enemies[13] = new Writlor(4, 24, 19);
			enemies[14] = new Writlor(5, 25, 20);
			enemies[15] = new Writlor(6, 26, 20);
			enemies[16] = new Writlor(7, 10, 34);
			enemies[17] = new Writlor(8, 11, 35);
			enemies[18] = new Writlor(9, 37, 41);
			enemies[19] = new Writlor(10, 5, 46);
			enemies[20] = new Writlor(11, 3, 47);
			// Slime
			enemies[21] = new Slime(1, 11, 9);
			enemies[22] = new Slime(2, 7, 12);
			enemies[23] = new Slime(3, 43, 19);
			enemies[24] = new Slime(4, 43, 23);
			enemies[25] = new Slime(5, 46, 25);
			enemies[26] = new Slime(6, 19, 41);
			enemies[27] = new Slime(7, 44, 43);
			// Typhru
			enemies[28] = new Typhru(1, 27, 6);
			enemies[29] = new Typhru(2, 25, 7);
			enemies[30] = new Typhru(3, 32, 30);
			enemies[31] = new Typhru(4, 34, 30);
			enemies[32] = new Typhru(5, 41, 32);
			enemies[33] = new Typhru(6, 32, 34);
			enemies[34] = new Typhru(7, 30, 35);
			enemies[35] = new Typhru(8, 31, 35);
			enemies[36] = new Typhru(9, 32, 36);
			enemies[37] = new Typhru(10, 13, 41);
			enemies[38] = new Typhru(11, 24, 45);
			// Talphru
			enemies[39] = new Talphru(1, 26, 6);
			enemies[40] = new Talphru(2, 26, 7);
			enemies[41] = new Talphru(3, 33, 31);
			enemies[42] = new Talphru(4, 32, 35);
			enemies[43] = new Talphru(5, 33, 35);
			enemies[44] = new Talphru(6, 11, 46);
			enemies[45] = new Talphru(7, 26, 47);
			// Venna
			enemies[46] = new Venna(1, 11, 5);
			enemies[47] = new Venna(2, 30, 14);
			enemies[48] = new Venna(3, 31, 14);
			enemies[49] = new Venna(4, 25, 25);
			enemies[50] = new Venna(5, 21, 33);
			enemies[51] = new Venna(6, 6, 37);
			enemies[52] = new Venna(7, 22, 45);
			// Immec
			enemies[53] = new Immec(1, 8, 4);
			enemies[54] = new Immec(2, 36, 17);
			enemies[55] = new Immec(3, 26, 26);
			enemies[56] = new Immec(4, 36, 26);
			enemies[57] = new Immec(5, 36, 43);
			// Altriss
			enemies[58] = new Altriss(1, 30, 18);
			enemies[59] = new Altriss(2, 24, 25);
			enemies[60] = new Altriss(3, 27, 26);
			enemies[61] = new Altriss(4, 10, 44);
			enemies[62] = new Altriss(5, 25, 44);
			enemies[63] = new Altriss(6, 15, 45);
			enemies[64] = new Altriss(7, 39, 45);
			// Nevfa
			enemies[65] = new Nevfa(1, 16, 14);
			enemies[66] = new Nevfa(2, 16, 16);
			enemies[67] = new Nevfa(3, 26, 45);
			enemies[68] = new Nevfa(4, 24, 47);
			enemies[69] = new Nevfa(5, 8, 48);
			// Onefa
			enemies[70] = new Onefa(1, 17, 15);
			enemies[71] = new Onefa(2, 27, 16);
			enemies[72] = new Onefa(3, 33, 16);
			enemies[73] = new Onefa(4, 23, 46);
			enemies[74] = new Onefa(5, 27, 46);
			// Barbarian
			enemies[75] = new Barbarian(Barbarian.getNames()[0], 35, 6);
			enemies[76] = new Barbarian(Barbarian.getNames()[1], 16, 32);
			enemies[77] = new Barbarian(Barbarian.getNames()[2], 6, 35);
			// Defender
			enemies[78] = new Defender(Defender.getNames()[0], 8, 26);
			enemies[79] = new Defender(Defender.getNames()[1], 13, 26);
			enemies[80] = new Defender(Defender.getNames()[2], 8, 27);
			// Fighter
			enemies[81] = new Fighter(Fighter.getNames()[0], 10, 25);
			enemies[82] = new Fighter(Fighter.getNames()[1], 5, 28);
			enemies[83] = new Fighter(Fighter.getNames()[2], 14, 28);
			// Valky
			enemies[84] = new Valky(Valky.getNames()[0], 6, 19);
			enemies[85] = new Valky(Valky.getNames()[1], 7, 20);
			enemies[86] = new Valky(Valky.getNames()[2], 12, 20);
			// Scout
			enemies[87] = new Scout(Scout.getNames()[0], 23, 29);
			enemies[88] = new Scout(Scout.getNames()[1], 17, 30);
			enemies[89] = new Scout(Scout.getNames()[2], 18, 30);
			enemies[90] = new Scout(Scout.getNames()[3], 4, 31);
			
			
			
			return enemies;
		}
		else {
			return null;
		}
	}
	
}
