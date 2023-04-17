package the_game.create;

import the_game.Wall;

public class CreateWalls {

	/**
	 * Create a Wall array which contains the location of all the walls of the map except the borders.
	 * @return a <code>Wall[]</code> which contains the location of all the walls of the map except the borders
	 */
	public static Wall[] placeWalls(){
		if (Create.getMapID() == 1) {
			Wall[] walls = new Wall[33];
			// All the walls that are not extremities :
			// ------------------------------ 1
			walls[0] = new Wall(1, 1, true);
			walls[1] = new Wall(12, 1, true);
			// ------------------------------ 2
			walls[2] = new Wall(13, 2, true);
			// ------------------------------ 3
			walls[3] = new Wall(14, 3, true);
			// ------------------------------ 4
			walls[4] = new Wall(14, 4, true);
			// ------------------------------ 5
			walls[5] = new Wall(14, 5, true);
			// ------------------------------ 6
			walls[6] = new Wall(15, 6, true);
			// ------------------------------ 7
			walls[7] = new Wall(16, 7, true);
			walls[8] = new Wall(17, 7, true);
			walls[9] = new Wall(18, 7, true);
			// ------------------------------ 11
			walls[10] = new Wall(5, 11, true);
			walls[11] = new Wall(6, 11, true);
			// ------------------------------ 12
			walls[12] = new Wall(5, 12, true);
			walls[13] = new Wall(6, 12, true);
			walls[14] = new Wall(15, 12, true);
			walls[15] = new Wall(16, 12, true);
			walls[16] = new Wall(17, 12, true);
			walls[17] = new Wall(18, 12, true);
			// ------------------------------ 13
			walls[18] = new Wall(14, 13, true);
			walls[19] = new Wall(15, 13, true);
			// ------------------------------ 14
			walls[20] = new Wall(1, 14, true);
			walls[21] = new Wall(16, 14, true);
			walls[22] = new Wall(17, 14, true);
			walls[23] = new Wall(18, 14, true);
			// ------------------------------ 16
			walls[24] = new Wall(1, 16, true);
			// ------------------------------ 17
			walls[25] = new Wall(6, 17, true);
			walls[26] = new Wall(7, 17, true);
			walls[27] = new Wall(8, 17, true);
			walls[28] = new Wall(9, 17, true);
			walls[29] = new Wall(10, 17, true);
			// ------------------------------ 18
			walls[30] = new Wall(5, 18, true);
			walls[31] = new Wall(11, 18, true);
			walls[32] = new Wall(12, 18, true);

			return walls;
		}
		else if (Create.getMapID() == 2) {
			Wall[] walls = new Wall[324];
			// All the walls that are not extremities :
			// ------------------------------ 1
			walls[0] = new Wall(5, 1, true);
			walls[1] = new Wall(6, 1, true);
			walls[2] = new Wall(7, 1, true);
			walls[3] = new Wall(20, 1, true);
			walls[4] = new Wall(22, 1, true);
			walls[5] = new Wall(28, 1, true);
			walls[6] = new Wall(29, 1, true);
			// ------------------------------ 2
			walls[7] = new Wall(4, 2, true);
			walls[8] = new Wall(21, 2, true);
			walls[9] = new Wall(30, 2, true);
			// ------------------------------ 3
			walls[10] = new Wall(3, 3, true);
			walls[11] = new Wall(30, 3, true);
			walls[12] = new Wall(31, 3, true);
			// ------------------------------ 4
			walls[13] = new Wall(3, 4, true);
			walls[14] = new Wall(19, 4, true);
			walls[15] = new Wall(20, 4, true);
			walls[16] = new Wall(21, 4, true);
			walls[17] = new Wall(32, 4, true);
			walls[18] = new Wall(33, 4, true);
			walls[19] = new Wall(34, 4, true);
			walls[20] = new Wall(35, 4, true);
			walls[21] = new Wall(36, 4, true);
			// ------------------------------ 5
			walls[22] = new Wall(4, 5, true);
			walls[23] = new Wall(5, 5, true);
			walls[24] = new Wall(19, 5, true);
			walls[25] = new Wall(21, 5, true);
			walls[26] = new Wall(37, 5, true);
			// ------------------------------ 6
			walls[27] = new Wall(6, 6, true);
			walls[28] = new Wall(7, 6, true);
			walls[29] = new Wall(8, 6, true);
			walls[30] = new Wall(9, 6, true);
			walls[31] = new Wall(10, 6, true);
			walls[32] = new Wall(11, 6, true);
			walls[33] = new Wall(12, 6, true);
			walls[34] = new Wall(13, 6, true);
			walls[35] = new Wall(14, 6, true);
			walls[36] = new Wall(19, 6, true);
			walls[37] = new Wall(20, 6, true);
			walls[38] = new Wall(27, 6, true);
			// ------------------------------ 7
			walls[39] = new Wall(2, 7, true);
			walls[40] = new Wall(3, 7, true);
			walls[41] = new Wall(4, 7, true);
			walls[42] = new Wall(5, 7, true);
			walls[43] = new Wall(6, 7, true);
			walls[44] = new Wall(7, 7, true);
			walls[45] = new Wall(8, 7, true);
			walls[46] = new Wall(36, 7, true);
			// ------------------------------ 8
			walls[47] = new Wall(1, 8, true);
			walls[48] = new Wall(37, 8, true);
			// ------------------------------ 9
			walls[49] = new Wall(1, 9, true);
			walls[50] = new Wall(26, 9, true);
			walls[51] = new Wall(27, 9, true);
			walls[52] = new Wall(37, 9, true);
			// ------------------------------ 10
			walls[53] = new Wall(2, 10, true);
			walls[54] = new Wall(36, 10, true);
			// ------------------------------ 11
			walls[55] = new Wall(3, 11, true);
			walls[56] = new Wall(36, 11, true);
			// ------------------------------ 12
			walls[57] = new Wall(4, 12, true);
			walls[58] = new Wall(12, 12, true);
			walls[59] = new Wall(13, 12, true);
			walls[60] = new Wall(37, 12, true);
			walls[61] = new Wall(38, 12, true);
			walls[62] = new Wall(39, 12, true);
			walls[63] = new Wall(40, 12, true);
			// ------------------------------ 13
			walls[64] = new Wall(5, 13, true);
			walls[65] = new Wall(12, 13, true);
			walls[66] = new Wall(41, 13, true);
			walls[67] = new Wall(42, 13, true);
			walls[68] = new Wall(43, 13, true);
			// ------------------------------ 14
			walls[69] = new Wall(5, 14, true);
			walls[70] = new Wall(44, 14, true);
			// ------------------------------ 15
			walls[71] = new Wall(6, 15, true);
			walls[72] = new Wall(44, 15, true);
			// ------------------------------ 16
			walls[73] = new Wall(7, 16, true);
			walls[74] = new Wall(8, 16, true);
			walls[75] = new Wall(9, 16, true);
			walls[76] = new Wall(29, 16, true);
			walls[77] = new Wall(30, 16, true);
			walls[78] = new Wall(44, 16, true);
			// ------------------------------ 17
			walls[79] = new Wall(10, 17, true);
			walls[80] = new Wall(11, 17, true);
			walls[81] = new Wall(12, 17, true);
			walls[82] = new Wall(13, 17, true);
			walls[83] = new Wall(29, 17, true);
			walls[84] = new Wall(30, 17, true);
			walls[85] = new Wall(44, 17, true);
			// ------------------------------ 18
			walls[86] = new Wall(5, 18, false);
			walls[87] = new Wall(6, 18, false);
			walls[88] = new Wall(7, 18, false);
			walls[89] = new Wall(8, 18, false);
			walls[90] = new Wall(9, 18, false);
			walls[91] = new Wall(10, 18, false);
			walls[92] = new Wall(11, 18, false);
			walls[93] = new Wall(14, 18, true);
			walls[94] = new Wall(45, 18, true);
			// ------------------------------ 19
			walls[95] = new Wall(2, 19, false);
			walls[96] = new Wall(3, 19, false);
			walls[97] = new Wall(4, 19, false);
			walls[98] = new Wall(12, 19, false);
			walls[99] = new Wall(13, 19, false);
			walls[100] = new Wall(15, 19, true);
			walls[101] = new Wall(16, 19, true);
			walls[102] = new Wall(46, 19, true);
			// ------------------------------ 20
			walls[103] = new Wall(1, 20, false);
			walls[104] = new Wall(14, 20, false);
			walls[105] = new Wall(17, 20, true);
			walls[106] = new Wall(24, 20, true);
			walls[107] = new Wall(47, 20, true);
			// ------------------------------ 21
			walls[108] = new Wall(2, 21, false);
			walls[109] = new Wall(8, 21, false);
			walls[110] = new Wall(9, 21, false);
			walls[111] = new Wall(10, 21, false);
			walls[112] = new Wall(11, 21, false);
			walls[113] = new Wall(12, 21, false);
			walls[114] = new Wall(13, 21, false);
			walls[115] = new Wall(18, 21, true);
			walls[116] = new Wall(19, 21, true);
			walls[117] = new Wall(37, 21, true);
			walls[118] = new Wall(48, 21, true);
			// ------------------------------ 22
			walls[119] = new Wall(3, 22, false);
			walls[120] = new Wall(4, 22, false);
			walls[121] = new Wall(5, 22, false);
			walls[122] = new Wall(6, 22, false);
			walls[123] = new Wall(7, 22, false);
			walls[124] = new Wall(20, 22, true);
			walls[125] = new Wall(37, 22, true);
			walls[126] = new Wall(48, 22, true);
			// ------------------------------ 23
			walls[127] = new Wall(10, 23, true);
			walls[128] = new Wall(11, 23, true);
			walls[129] = new Wall(12, 23, true);
			walls[130] = new Wall(21, 23, true);
			walls[131] = new Wall(38, 23, true);
			walls[132] = new Wall(39, 23, true);
			// ------------------------------ 24
			walls[133] = new Wall(9, 24, true);
			walls[134] = new Wall(13, 24, true);
			walls[135] = new Wall(21, 24, true);
			// ------------------------------ 25
			walls[136] = new Wall(1, 25, true);
			walls[137] = new Wall(2, 25, true);
			walls[138] = new Wall(8, 25, true);
			walls[139] = new Wall(13, 25, true);
			walls[140] = new Wall(21, 25, true);
			// ------------------------------ 26
			walls[141] = new Wall(3, 26, true);
			walls[142] = new Wall(7, 26, true);
			walls[143] = new Wall(10, 26, true);
			walls[144] = new Wall(11, 26, true);
			walls[145] = new Wall(14, 26, true);
			walls[146] = new Wall(15, 26, true);
			walls[147] = new Wall(21, 26, true);
			// ------------------------------ 27
			walls[148] = new Wall(4, 27, true);
			walls[149] = new Wall(5, 27, true);
			walls[150] = new Wall(6, 27, true);
			walls[151] = new Wall(9, 27, true);
			walls[152] = new Wall(12, 27, true);
			walls[153] = new Wall(16, 27, true);
			walls[154] = new Wall(17, 27, true);
			walls[155] = new Wall(20, 27, true);
			// ------------------------------ 28
			walls[156] = new Wall(9, 28, true);
			walls[157] = new Wall(13, 28, true);
			walls[158] = new Wall(18, 28, true);
			walls[159] = new Wall(19, 28, true);
			walls[160] = new Wall(38, 28, true);
			walls[161] = new Wall(39, 28, true);
			walls[162] = new Wall(40, 28, true);
			walls[163] = new Wall(41, 28, true);
			walls[164] = new Wall(42, 28, true);
			walls[165] = new Wall(43, 28, true);
			walls[166] = new Wall(44, 28, true);
			// ------------------------------ 29
			walls[167] = new Wall(8, 29, true);
			walls[168] = new Wall(13, 29, true);
			walls[169] = new Wall(40, 29, true);
			walls[170] = new Wall(41, 29, true);
			walls[171] = new Wall(44, 29, true);
			// ------------------------------ 30
			walls[172] = new Wall(9, 30, true);
			walls[173] = new Wall(14, 30, true);
			walls[174] = new Wall(42, 30, true);
			walls[175] = new Wall(43, 30, true);
			walls[176] = new Wall(44, 30, true);
			walls[177] = new Wall(45, 30, true);
			walls[178] = new Wall(46, 30, true);
			// ------------------------------ 31
			walls[179] = new Wall(10, 31, true);
			walls[180] = new Wall(14, 31, true);
			walls[181] = new Wall(23, 31, true);
			walls[182] = new Wall(24, 31, true);
			// ------------------------------ 32
			walls[183] = new Wall(11, 32, true);
			walls[184] = new Wall(12, 32, true);
			walls[185] = new Wall(13, 32, true);
			walls[186] = new Wall(22, 32, true);
			walls[187] = new Wall(25, 32, true);
			walls[188] = new Wall(47, 32, true);
			walls[189] = new Wall(48, 32, true);
			// ------------------------------ 33
			walls[190] = new Wall(23, 33, true);
			walls[191] = new Wall(24, 33, true);
			walls[192] = new Wall(43, 33, true);
			walls[193] = new Wall(44, 33, true);
			walls[194] = new Wall(45, 33, true);
			walls[195] = new Wall(46, 33, true);
			// ------------------------------ 34
			walls[196] = new Wall(5, 34, true);
			walls[197] = new Wall(36, 34, true);
			walls[198] = new Wall(37, 34, true);
			walls[199] = new Wall(38, 34, true);
			walls[200] = new Wall(39, 34, true);
			walls[201] = new Wall(40, 34, true);
			walls[202] = new Wall(41, 34, true);
			walls[203] = new Wall(42, 34, true);
			// ------------------------------ 35
			walls[204] = new Wall(4, 35, true);
			walls[205] = new Wall(34, 35, true);
			walls[206] = new Wall(35, 35, true);
			walls[207] = new Wall(36, 35, true);
			// ------------------------------ 36
			walls[208] = new Wall(30, 36, true);
			walls[209] = new Wall(31, 36, true);
			walls[210] = new Wall(37, 36, true);
			// ------------------------------ 37
			walls[211] = new Wall(15, 37, true);
			walls[212] = new Wall(29, 37, true);
			walls[213] = new Wall(32, 37, true);
			walls[214] = new Wall(33, 37, true);
			walls[215] = new Wall(37, 37, true);
			// ------------------------------ 38
			walls[216] = new Wall(26, 38, true);
			walls[217] = new Wall(27, 38, true);
			walls[218] = new Wall(28, 38, true);
			walls[219] = new Wall(34, 38, true);
			walls[220] = new Wall(35, 38, true);
			walls[221] = new Wall(36, 38, true);
			// ------------------------------ 39
			walls[222] = new Wall(1, 39, true);
			walls[223] = new Wall(2, 39, true);
			walls[224] = new Wall(3, 39, true);
			walls[225] = new Wall(12, 39, true);
			walls[226] = new Wall(29, 39, true);
			walls[227] = new Wall(30, 39, true);
			walls[228] = new Wall(31, 39, true);
			walls[229] = new Wall(32, 39, true);
			walls[230] = new Wall(33, 39, true);
			walls[231] = new Wall(34, 39, true);
			walls[232] = new Wall(35, 39, true);
			walls[233] = new Wall(36, 39, true);
			walls[234] = new Wall(37, 39, true);
			walls[235] = new Wall(38, 39, true);
			walls[236] = new Wall(39, 39, true);
			// ------------------------------ 40
			walls[237] = new Wall(4, 40, true);
			walls[238] = new Wall(5, 40, true);
			walls[239] = new Wall(21, 40, true);
			walls[240] = new Wall(22, 40, true);
			walls[241] = new Wall(23, 40, true);
			walls[242] = new Wall(24, 40, true);
			walls[243] = new Wall(40, 40, true);
			walls[244] = new Wall(41, 40, true);
			walls[245] = new Wall(42, 40, true);
			walls[246] = new Wall(43, 40, true);
			walls[247] = new Wall(44, 40, true);
			// ------------------------------ 41
			walls[248] = new Wall(6, 41, true);
			walls[249] = new Wall(7, 41, true);
			walls[250] = new Wall(23, 41, true);
			walls[251] = new Wall(25, 41, true);
			walls[252] = new Wall(26, 41, true);
			walls[253] = new Wall(27, 41, true);
			walls[254] = new Wall(45, 41, true);
			walls[255] = new Wall(46, 41, true);
			// ------------------------------ 42
			walls[256] = new Wall(8, 42, true);
			walls[257] = new Wall(9, 42, true);
			walls[258] = new Wall(20, 42, true);
			walls[259] = new Wall(24, 42, true);
			walls[260] = new Wall(25, 42, true);
			walls[261] = new Wall(28, 42, true);
			walls[262] = new Wall(29, 42, true);
			walls[263] = new Wall(30, 42, true);
			walls[264] = new Wall(31, 42, true);
			walls[265] = new Wall(47, 42, true);
			// ------------------------------ 43
			walls[266] = new Wall(6, 43, true);
			walls[267] = new Wall(7, 43, true);
			walls[268] = new Wall(19, 43, true);
			walls[269] = new Wall(20, 43, true);
			walls[270] = new Wall(26, 43, true);
			walls[271] = new Wall(27, 43, true);
			walls[272] = new Wall(28, 43, true);
			walls[273] = new Wall(32, 43, true);
			walls[274] = new Wall(47, 43, true);
			// ------------------------------ 44
			walls[275] = new Wall(3, 44, true);
			walls[276] = new Wall(4, 44, true);
			walls[277] = new Wall(5, 44, true);
			walls[278] = new Wall(18, 44, true);
			walls[279] = new Wall(19, 44, true);
			walls[280] = new Wall(29, 44, true);
			walls[281] = new Wall(32, 44, true);
			walls[282] = new Wall(46, 44, true);
			// ------------------------------ 45
			walls[283] = new Wall(1, 45, true);
			walls[284] = new Wall(2, 45, true);
			walls[285] = new Wall(6, 45, true);
			walls[286] = new Wall(30, 45, true);
			walls[287] = new Wall(33, 45, true);
			walls[288] = new Wall(34, 45, true);
			walls[289] = new Wall(47, 45, true);
			// ------------------------------ 46
			walls[290] = new Wall(14, 46, true);
			walls[291] = new Wall(15, 46, true);
			walls[292] = new Wall(16, 46, true);
			walls[293] = new Wall(17, 46, true);
			walls[294] = new Wall(18, 46, true);
			walls[295] = new Wall(31, 46, true);
			walls[296] = new Wall(35, 46, true);
			walls[297] = new Wall(44, 46, true);
			walls[298] = new Wall(45, 46, true);
			walls[299] = new Wall(46, 46, true);
			// ------------------------------ 47
			walls[300] = new Wall(1, 47, true);
			walls[301] = new Wall(12, 47, true);
			walls[302] = new Wall(13, 47, true);
			walls[303] = new Wall(19, 47, true);
			walls[304] = new Wall(20, 47, true);
			walls[305] = new Wall(31, 47, true);
			walls[306] = new Wall(36, 47, true);
			walls[307] = new Wall(37, 47, true);
			walls[308] = new Wall(38, 47, true);
			walls[309] = new Wall(39, 47, true);
			walls[310] = new Wall(40, 47, true);
			walls[311] = new Wall(41, 47, true);
			walls[312] = new Wall(42, 47, true);
			walls[313] = new Wall(43, 47, true);
			// ------------------------------ 48
			walls[314] = new Wall(2, 48, true);
			walls[315] = new Wall(3, 48, true);
			walls[316] = new Wall(4, 48, true);
			walls[317] = new Wall(11, 48, true);
			walls[318] = new Wall(21, 48, true);
			walls[319] = new Wall(22, 48, true);
			walls[320] = new Wall(23, 48, true);
			walls[321] = new Wall(24, 48, true);
			walls[322] = new Wall(25, 48, true);
			walls[323] = new Wall(30, 48, true);
			
			return walls;
		}
		else {
			return null;
		}
	}
	
}
