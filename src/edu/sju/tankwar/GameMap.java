package edu.sju.tankwar;

/**
 * Description: GameMap of game
 * @file GameMap.java
 * @author Team_F  Yuanhai Shi  
 * @version 1.2
 * @Xiaohui Modified by 12-05 on maps init
 * 
 */
public class GameMap {

	/**2D graphics map**/
	public int map[][];
	/**row of  map**/
	public int map_row;
	/**column of map **/
	public int map_column;

	/**
	 * GameMap constructor
	 */
	public GameMap() {
		map_column = 0;
		map_row = 0;
		map = new int[map_row + 1][map_column + 1];
	}

	/**GameMap constructor with parameters
	 * @param row
	 *            row in 2D
	 * @param column
	 */
	public GameMap(int row, int column) {
		map_column = column;
		map_row = row;
		map = new int[map_row + 1][map_column + 1];
	}

	/**
	 * init the map  for stage 1
	 */
	public void map1() {
		//  init the map
		for (int i = 10; i < 15; i++) {
			for (int j = 3; j < 6; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2; //barrier
			}

			for (int j = 15; j < 18; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 27; j < 30; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

		}

		for (int i = 20; i < 23; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
			for (int j = 24; j < 32; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
		}

		for (int i = 18; i < 25; i++) {
			for (int j = 14; j < 18; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
		}

		for (int i = 26; i < 31; i++) {
			for (int j = 1; j < 4; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 6; j < 9; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 12; j < 14; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			if (i >= 28 && i <= 31) {
				for (int j = 14; j < 18; j++) {
					if (map[i][j] == 2)
						continue;
					map[i][j] = 2;
				}
			}

			for (int j = 18; j < 20; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 23; j < 26; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 28; j < 31; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

		}
	}
	/* init map for stage 2
	 * 
	 */
	public void map2() {

		
		for (int i = 20; i < 23; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
			for (int j = 24; j < 32; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
		}

		for (int i = 18; i < 25; i++) {
			for (int j = 14; j < 18; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}
		}
	}
	/*
	 * init map for stage 3
	 * 
	 */
	public void map3() {
		
		for (int i = 20; i < 25; i++) {
			for (int j = 3; j < 6; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}



			for (int j = 27; j < 30; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

		}
	}
	
	
	
}
