package edu.sju.tankwar;

/**
 * Description: GameMap of game
 * @file GameMap.java
 * @author team_f
 * @version 1.0
 */
public class GameMap {

	public int map[][];
	public int map_row;
	public int map_column;

	/**
	 * non_param constructor
	 */
	public GameMap() {
		map_column = 0;
		map_row = 0;
		map = new int[map_row + 1][map_column + 1];
	}

	/**
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
	 * init the map
	 */
	public void map1() {
		// TODO init the map
		for (int i = 10; i < 15; i++) {
			for (int j = 3; j < 6; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
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
	
	public void map2() {
		for (int i = 10; i < 15; i++) {
			for (int j = 3; j < 6; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
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
	}
	
	public void map3() {
		for (int i = 10; i < 15; i++) {
			for (int j = 3; j < 6; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

			for (int j = 15; j < 18; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
			}

		}
	}
	
	
	
}
