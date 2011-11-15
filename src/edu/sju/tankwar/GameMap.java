package edu.sju.tankwar;

/**
 * @file GameMap.java
 * @brief GameMap of game
 * @author team_f
 * @version 1.0
 */
public class GameMap {

	public int map[][];
	public int map_row;
	public int map_column;

	/**
	 *  non_param constructor	
	 */
	public GameMap() {
		map_column = 0;
		map_row = 0;
		map = new int[map_row + 1][map_column + 1];
	}

	/**
	 * @param row row in 2D
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
	public void init() {
		// TODO init the map
	}
}
