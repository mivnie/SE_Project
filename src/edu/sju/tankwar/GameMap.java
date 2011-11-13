/**
 * 
 */
package edu.sju.tankwar;

/**
 * @author team_f
 * 
 */
public class GameMap {

	public int map[][];
	public int map_row;
	public int map_column;

	/**
	 * 
	 */
	public GameMap() {
		map_column = 0;
		map_row = 0;
		map = new int[map_row + 1][map_column + 1];
	}

	/**
	 * 
	 */
	public GameMap(int row, int column) {
		map_column = column;
		map_row = row;
		map = new int[map_row + 1][map_column + 1];
	}

	public void init() {
		// TODO init the map
	}
}
