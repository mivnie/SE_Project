/**
 * 
 */
package edu.sju.tankwar;

import edu.sju.tankwar.math.GameConstants;
import edu.sju.tankwar.math.Point;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

/**
 * @author team_f
 * 
 */
public class Tank implements GameConstants {

	private Point centerPoint;// center of the tank image

	private Point gun = new Point();// gun of tank

	private int speed = UNIT;

	private int flag = MYTANK;// mytank or enemy

	private int screenHeight;

	private int screenWidth;

	private Bitmap tankBmp;// source image

	private int direction = UP;

	public Matrix matrix = new Matrix();

	private long lastTrunTime;

	private int column;// column of the tank image on the canvas
	private int row;// column of the tank image on the canvas

	/**
	 * 
	 */
	public Tank() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Tank(Point p) {
		this.centerPoint = p;
	}

	/**
	 * 
	 */
	public Tank(BitmapDrawable tankDrawable, int flag) {
		// TODO change the centerpoint when create a tank, this indicates the
		// place where a tank appears
		centerPoint = new Point(200, 350);
		this.flag = flag;
		this.tankBmp = tankDrawable.getBitmap();
		gun.setY(centerPoint.getY());
		gun.setX(centerPoint.getX() + tankBmp.getWidth() / 2);
		column = tankBmp.getWidth() / UNIT;
		row = tankBmp.getHeight() / UNIT;
	}

	/**
	 * 
	 */
	public Tank(BitmapDrawable tankDrawable, Point p, int flag, int direction,
			int h, int w) {
		this.flag = flag;
		this.tankBmp = tankDrawable.getBitmap();
		matrix.postRotate((direction - UP) * 90);
		tankBmp = Bitmap.createBitmap(tankBmp, 0, 0, tankBmp.getWidth(),
				tankBmp.getHeight(), matrix, true);
		this.direction = direction;
		this.centerPoint = p;
		gun.setY(centerPoint.getY());
		gun.setX(centerPoint.getX() + tankBmp.getWidth() / 2);
		this.screenHeight = h;
		this.screenWidth = w;
		column = tankBmp.getWidth() / UNIT;
		row = tankBmp.getHeight() / UNIT;
	}

	/**
	 * 
	 */
	public void setScreenHeight(int h) {
		screenHeight = h;
	}

	/**
	 * 
	 */
	public void setScreenWidth(int w) {
		screenWidth = w;
	}

	/**
	 * reset the gun
	 */
	private void resetFrontPoint() {
		if (direction == UP) {
			gun.setY(centerPoint.getY());
			gun.setX(centerPoint.getX() + tankBmp.getWidth() / 2);
		} else if (direction == DOWN) {
			gun.setY(centerPoint.getY() + tankBmp.getHeight());
			gun.setX(centerPoint.getX() + tankBmp.getWidth() / 2);
		} else if (direction == LEFT) {
			gun.setY(centerPoint.getY() + tankBmp.getHeight() / 2);
			gun.setX(centerPoint.getX());
		} else if (direction == RIGHT) {
			gun.setY(centerPoint.getY() + tankBmp.getHeight() / 2);
			gun.setX(centerPoint.getX() + tankBmp.getWidth());
		}
	}

	/**
	 * reset the position of tank
	 */
	private void resetTankPoint() {
		modifyMapStatus(0);// release the point where tank occupies
		if (direction == UP) {
			this.centerPoint.setY(centerPoint.getY() - speed);
		} else if (direction == DOWN) {
			this.centerPoint.setY(centerPoint.getY() + speed);
		} else if (direction == LEFT) {
			this.centerPoint.setX(centerPoint.getX() - speed);
		} else if (direction == RIGHT) {
			this.centerPoint.setX(centerPoint.getX() + speed);
		}
		resetFrontPoint();
		modifyMapStatus(1);
	}

	/**
	 * modify the status of the map
	 */
	private void modifyMapStatus(int status) {
		int bC = centerPoint.getX() / UNIT;
		int bR = centerPoint.getY() / UNIT;

		for (int i = bR; i < bR + row; i++) {
			for (int j = bC; j < bC + column; j++) {
				GameView.map[i][j] = status;
			}
		}
	}

	/**
	 * get direction
	 */
	public int getDirection() {
		return this.direction;
	}

	/**
	 * draw a tank on the canvas
	 */
	public void drawTank(Canvas canvas) {
		canvas.drawBitmap(tankBmp, centerPoint.x, centerPoint.y, null);
	}

	/**
	 * get the postion of the gun
	 */
	public Point getFrontPoint() {
		return this.gun;
	}

	/**
	 * 
	 */
	public void moveUp() {
		matrix.reset();
		matrix.postRotate((UP - direction) * 90);
		tankBmp = Bitmap.createBitmap(tankBmp, 0, 0, tankBmp.getWidth(),
				tankBmp.getHeight(), matrix, true);
		direction = UP;
		if (!canMove()) {
			resetFrontPoint();
			return;
		}
		resetTankPoint();
	}

	/**
	 * 
	 */
	public void moveDown() {
		matrix.reset();
		matrix.postRotate((DOWN - direction) * 90);
		tankBmp = Bitmap.createBitmap(tankBmp, 0, 0, tankBmp.getWidth(),
				tankBmp.getHeight(), matrix, true);
		direction = DOWN;
		if (!canMove()) {
			resetFrontPoint();
			return;
		}
		resetTankPoint();
	}

	/**
	 * 
	 */
	public void moveLeft() {
		matrix.reset();
		matrix.postRotate((LEFT - direction) * 90);
		tankBmp = Bitmap.createBitmap(tankBmp, 0, 0, tankBmp.getWidth(),
				tankBmp.getHeight(), matrix, true);
		direction = LEFT;
		if (!canMove()) {
			resetFrontPoint();
			return;
		}
		resetTankPoint();
	}

	/**
	 * 
	 */
	public void moveRight() {
		matrix.reset();
		matrix.postRotate((RIGHT - direction) * 90);
		tankBmp = Bitmap.createBitmap(tankBmp, 0, 0, tankBmp.getWidth(),
				tankBmp.getHeight(), matrix, true);
		direction = RIGHT;
		if (!canMove()) {
			resetFrontPoint();
			return;
		}
		resetTankPoint();
	}

	/**
	 * 
	 */
	public void move() {
		if (direction == UP) {
			moveUp();
		} else if (direction == DOWN) {
			moveDown();
		} else if (direction == LEFT) {
			moveLeft();
		} else if (direction == RIGHT) {
			moveRight();
		}
	}

	/**
	 * fire
	 */
	public Shell fire() {
		Shell shell = GameFactory.createShells();
		shell.setCenterPoint(gun);
		shell.direction = direction;
		shell.flag = flag;
		return shell;
	}

	/**
	 * 
	 */
	public Rect getFillRect() {
		return new Rect(centerPoint.getX(), centerPoint.getY(),
				centerPoint.getX() + tankBmp.getWidth() - 1, centerPoint.getY()
						+ tankBmp.getHeight() - 1);
	}

	/**
	 * 
	 */
	public boolean hit(Shell s) {
		if (s.getFlag() == flag) {
			return false;
		}
		if (getFillRect().intersect(s.getFillRect())) {
			modifyMapStatus(0);
			return true;
		}
		return false;
	}

	/**
	 * judge if the tank can move,then change its position by reset its position
	 */
	private boolean canMove() {
		if (System.currentTimeMillis() - lastTrunTime < 300) {// move time is
																// 300ms before
																// last move
			return false;
		}
		boolean f = false;
		if (direction == UP) {// when tank moves up
			if (centerPoint.getY() - speed >= 0) {
				if (GameView.map[(centerPoint.getY() - speed) / UNIT][centerPoint
						.getX() / UNIT] == 0
						&& GameView.map[(centerPoint.getY() - speed) / UNIT][(centerPoint
								.getX() + UNIT) / UNIT] == 0
						&& GameView.map[(centerPoint.getY() - speed) / UNIT][(centerPoint
								.getX() + 2 * UNIT) / UNIT] == 0) {
					f = true;
				}
			}
		} else if (direction == DOWN) {
			if (centerPoint.getY() + tankBmp.getHeight() + speed < screenHeight) {
				if (GameView.map[(centerPoint.getY() + 2 * UNIT + speed) / UNIT][centerPoint
						.getX() / UNIT] == 0
						&& GameView.map[(centerPoint.getY() + 2 * UNIT + speed)
								/ UNIT][(centerPoint.getX() + UNIT) / UNIT] == 0
						&& GameView.map[(centerPoint.getY() + 2 * UNIT + speed)
								/ UNIT][(centerPoint.getX() + 2 * UNIT) / UNIT] == 0) {
					f = true;
				}
			}
		} else if (direction == LEFT) {

			if (centerPoint.getX() - speed >= 0) {
				if (GameView.map[centerPoint.getY() / UNIT][(centerPoint.getX() - speed)
						/ UNIT] == 0
						&& GameView.map[(centerPoint.getY() + UNIT) / UNIT][(centerPoint
								.getX() - speed) / UNIT] == 0
						&& GameView.map[(centerPoint.getY() + 2 * UNIT) / UNIT][(centerPoint
								.getX() - speed) / UNIT] == 0) {
					f = true;
				}
			}
		} else if (direction == RIGHT) {
			if (centerPoint.getX() + tankBmp.getWidth() + speed < screenWidth) {
				if (GameView.map[centerPoint.getY() / UNIT][(centerPoint.getX()
						+ 2 * UNIT + speed)
						/ UNIT] == 0
						&& GameView.map[(centerPoint.getY() + UNIT) / UNIT][(centerPoint
								.getX() + 2 * UNIT + speed)
								/ UNIT] == 0
						&& GameView.map[(centerPoint.getY() + 2 * UNIT) / UNIT][(centerPoint
								.getX() + 2 * UNIT + speed)
								/ UNIT] == 0) {
					f = true;
				}
			}
		}
		if (f)
			lastTrunTime = System.currentTimeMillis();
		return f;
	}
}
