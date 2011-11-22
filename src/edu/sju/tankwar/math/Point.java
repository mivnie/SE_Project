package edu.sju.tankwar.math;

/**
 * Description: Point in the canvas
 * 
 * @file Point.java
 * @author The team name Team F The principal author's name : Spoorthy
 *         Acknowledgment of help from other team members, by name: n/a
 * @version 1.0
 */
public class Point {
	/** x coordinate */
	public int x;
	/** y coordinate */
	public int y;

	/**
	 * non-parm constructor
	 */
	public Point() {

	}

	/**
	 * constructor with x,y
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * getter for x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * setter for x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getter for y
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * setter for x
	 */
	public void setY(int y) {
		this.y = y;
	}

}