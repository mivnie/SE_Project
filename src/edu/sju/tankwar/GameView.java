/**
 * 
 */
package edu.sju.tankwar;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import edu.sju.tankwar.math.*;

/**
 * @author team_f
 * 
 */
public class GameView extends View implements GameConstants {

	private static int BASE_X = 160;// position of base
	private static int BASE_Y = 340;
	protected int height;// height of the view
	protected int width;// width of the view
	private Bitmap base;// image source of the base
	protected List<Shell> shellsList = new ArrayList<Shell>();// list of shells
	protected List<Tank> tankList = new ArrayList<Tank>();// list of tanks
	private List<Barrier> barriersList = new ArrayList<Barrier>();// list of
																	// barriers
	public static int map[][];// 2D matrix.represents the point on the
								// canvas.status:
								// 0:free£¬1:tank£¬2:barrier£¬3:base.
	private int row;// row on the canvas
	private int column;// column
	public Tank myTank;// mytank object
	private String gameStatus = "STOP";// game status.
	private Handler gameHandler = new Handler();
	private Runnable drawThread = new Runnable() {
		@Override
		public void run() {
			update();
		}

	};

	/**
	 * @param context
	 */
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

	}

	/**
	 * 
	 */
	public GameView(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, attrs);
		base = ((BitmapDrawable) getResources().getDrawable(R.drawable.dby))
				.getBitmap();

	}

	/**
	 * override onDraw method which handles all the drawing operations
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(base, BASE_X, BASE_Y, null);// draw base
		int shellSize = shellsList.size();
		for (int j = 0; j < shellSize; j++) {
			shellsList.get(j).drawShell(canvas);
		}
		int i = barriersList.size();
		for (int j = 0; j < i; j++) {
			barriersList.get(j).drawBarrier(canvas);
		}
		myTank.drawTank(canvas);

	}

	/**
	 * init the map
	 */
	public void initMap() {
		// init the base
		for (int i = BASE_Y / UNIT; i < BASE_Y / UNIT + base.getHeight() / UNIT; i++) {
			for (int j = BASE_X / UNIT; j < BASE_X / UNIT + base.getWidth()
					/ UNIT; j++) {
				map[i][j] = 3;
			}
		}
		for (int i = (BASE_Y - 2 * UNIT) / UNIT; i < (BASE_Y + base.getHeight())
				/ UNIT; i++) {
			for (int j = (BASE_X - 2 * UNIT) / UNIT; j < (BASE_X
					+ base.getWidth() + 2 * UNIT)
					/ UNIT; j++) {
				if (map[i][j] == 3)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
		}
		// init the map
		// TODO implement the Map class,with all map operation within it.
		
		for (int i = 5; i < 17; i++) {
			for (int j = 2; j < 5; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 7; j < 10; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 12; j < 15; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 17; j < 20; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 22; j < 25; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 27; j < 30; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
		}
		
		for (int i = 20; i < 23; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			for (int j = 24; j < 32; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
		}
		
		for (int i = 18; i < 25; i++) {
			for (int j = 12; j < 20; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
		}
		
		for (int i = 26; i < 35; i++) {
			for (int j = 1; j < 4; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}

			for (int j = 6; j < 9; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}

			for (int j = 12; j < 14; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}

			if (i >= 28 && i <= 31) {
				for (int j = 14; j < 18; j++) {
					if (map[i][j] == 2)
						continue;
					map[i][j] = 2;
					barriersList.add(new Barrier(i, j));
				}
			}

			for (int j = 18; j < 20; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}

			for (int j = 23; j < 26; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}

			for (int j = 28; j < 31; j++) {
				if (map[i][j] == 2)
					continue;
				map[i][j] = 2;
				barriersList.add(new Barrier(i, j));
			}
			
		}
	}

	/**
	 * override onSize method,will be called when size of the view is changed
	 */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		height = h;
		width = w;
		row = height / UNIT;
		column = width / UNIT;
		myTank = new Tank((BitmapDrawable) getResources().getDrawable(
				R.drawable.tank), new Point((column / 2 - 8) * UNIT, (row - 3)
				* UNIT), 0, UP, h, w);
		BASE_X = ((column / 2) - 2) * UNIT;
		BASE_Y = row * UNIT - base.getHeight();
		map = new int[row + 1][column + 1];
		initMap();
	}

	/**
	 * override the onKeyDown method to listen the key events
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.d("TAG", "activity onKeyDown");
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			if (!gameStatus.equals("STOP")) {
				myTank.moveRight();
			}
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			if (!gameStatus.equals("STOP")) {
				myTank.moveLeft();
			}
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			if (!gameStatus.equals("STOP")) {
				myTank.moveUp();
			}
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			if (!gameStatus.equals("STOP")) {
				myTank.moveDown();
			}
			break;
		case KeyEvent.KEYCODE_DPAD_CENTER:
			if (gameStatus.equals("STOP")) {
				gameStatus = "START";
				gameHandler.post(drawThread);
			} else {
				shellsList.add(myTank.fire());
			}
			break;
		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * update all the elements on the canvas
	 */
	public void update() {
		long begin = System.currentTimeMillis();
		int i = shellsList.size();
		Shell shells;
		for (int j = 0; j < i; j++) {
			if (gameStatus.equals("STOP"))
				break;
			shells = shellsList.get(j);
			if (shells.direction == UP) {
				if (shells.getPoint().y <= 0) {
					if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
						GameFactory.shellsFactory.push(shells);
					}
					shellsList.remove(j--);
					i--;
					continue;
				}
			} else if (shells.direction == DOWN) {
				if (shells.getPoint().y >= height) {
					if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
						GameFactory.shellsFactory.push(shells);
					}
					shellsList.remove(j--);
					i--;
					continue;
				}
			} else if (shells.direction == LEFT) {
				if (shells.getPoint().x <= 0) {
					if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
						GameFactory.shellsFactory.push(shells);
					}
					shellsList.remove(j--);
					i--;
					continue;
				}
			} else if (shells.direction == RIGHT) {
				if (shells.getPoint().x >= width) {
					if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
						GameFactory.shellsFactory.push(shells);
					}
					shellsList.remove(j--);
					i--;
					continue;
				}
			}
			if (juageHitWall(shells)) {
				if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
					GameFactory.shellsFactory.push(shells);
				}
				shellsList.remove(j--);
				i--;
			}
			shells.move();// shell move
		}
		if (gameStatus.equals("START")) {
			postInvalidate();
			gameHandler.postDelayed(drawThread, 100);
		}
		Log.i("System.out", String.valueOf(System.currentTimeMillis() - begin));
	}

	/**
	 * @param shell
	 *            judge if a shell hits a wall, then remove the wall from the
	 *            barrierList
	 */
	public boolean juageHitWall(Shell s) {
		int i = 0, j = 0;
		if (s.direction == UP) {
			i = (s.getPoint().getX() - s.radius) / UNIT;
			j = (s.getPoint().getY() - s.radius) / UNIT;
		} else if (s.direction == DOWN) {
			i = (s.getPoint().getX() - s.radius) / UNIT;
			j = (s.getPoint().getY() + s.radius) / UNIT;
		} else if (s.direction == RIGHT) {
			i = (s.getPoint().getX() + s.radius) / UNIT;
			j = (s.getPoint().getY() - s.radius) / UNIT;
		} else if (s.direction == LEFT) {
			i = (s.getPoint().getX() - s.radius) / UNIT;
			j = (s.getPoint().getY() - s.radius) / UNIT;
		}
		if (map[j][i] == 3) {
			// TODO judge if hit the base
		}
		if (map[j][i] == 2) {
			barriersList.remove(new Barrier(j, i));
			map[j][i] = 0;
			return true;
		}
		if (map[j][i] == 1) {
			// TODO judge if hit a tank
		}
		return false;
	}

}
