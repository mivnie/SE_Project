/**
 * 
 */
package edu.sju.tankwar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import edu.sju.tankwar.math.*;

/**
 * @author team_f
 * 
 */
public class Shell implements GameConstants {

	public int radius = 2;// radius for the circle of the shell image

	public Point centerPoint;// center of the shell

	private Paint paint;

	public int direction;// direction of shell

	private int speed = UNIT;// speed

	public int flag = 0;

	public Shell() {
		paint = new Paint();
		paint.setColor(Color.GRAY);
	}

	public void setCenterPoint(Point p) {
		centerPoint = new Point(p.getX(), p.getY());
	}

	public void drawShell(Canvas canvas) {
		canvas.drawCircle(centerPoint.x, centerPoint.y, radius, paint);// draw a
																		// shell
																		// on
																		// the
																		// canvas
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

	public Rect getFillRect() {
		return new Rect(centerPoint.getX() - radius, centerPoint.getY()
				- radius, centerPoint.getX() + radius, centerPoint.getY()
				+ radius);
	}

	public int getFlag() {
		return flag;
	}

	public Point getPoint() {
		return centerPoint;
	}
}
