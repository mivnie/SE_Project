
package edu.sju.tankwar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import edu.sju.tankwar.math.*;

/**
 * Description: shell in the gameshell in the game
 * @file Shell.java
 * @author team_f
 *  The team name Team F
   	The principal author's name : Suhao Qin
   	Acknowledgment of help from other team members, by name: n/a
 * @version 1.0
 */
public class Shell implements GameConstants {
	/** radius for the circle of the shell image */
	public int radius = 2; 
	/** center of the shell */
	public Point centerPoint;
	/** paint for the shell */
	private Paint paint;
	/** direction of shell */
	public int direction;
	/** speed */
	private int speed = UNIT; 
	/** flag */
	public int flag = 0;
	
	/** 
	 *  constructor
	*/
	public Shell() {
		paint = new Paint();
		paint.setColor(Color.GRAY);
	}
	
	/**
	 * set the center point of the shell image
	 * @param p centerpoint
	*/
	public void setCenterPoint(Point p) {
		centerPoint = new Point(p.getX(), p.getY());
	}

	/**
	 * draw shell on the canvas
	 * @param canvas canvas of the game
	*/
	public void drawShell(Canvas canvas) {
		canvas.drawCircle(centerPoint.x, centerPoint.y, radius, paint);
	}

	/**
	 * move a shell,by changing its centerpoint
	 */
	public void move() {
		switch (direction) {
		case LEFT:
			centerPoint.setX(centerPoint.getX() - speed);
			break;
		case UP:
			centerPoint.setY(centerPoint.getY() - speed);
			break;
		case RIGHT:
			centerPoint.setX(centerPoint.getX() + speed);
			break;
		case DOWN:
			centerPoint.setY(centerPoint.getY() + speed);
			break;
		default:
			break;
		}
	}
	
	/**
	 * get the rect for fill
	 * @return rect
	 */
	public Rect getFillRect() {
		return new Rect(centerPoint.getX() - radius, centerPoint.getY()
				- radius, centerPoint.getX() + radius, centerPoint.getY()
				+ radius);
	}

	/**
	 * get flag of shell
	 * @return flag of shell
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * get center point of shell
	 * @return center point
	 */
	public Point getPoint() {
		return centerPoint;
	}
}