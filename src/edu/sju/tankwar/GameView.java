package edu.sju.tankwar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import android.app.AlertDialog;
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
 * Description: custom view for game main view
 * 
 * @file GameView.java The team name Team F The principal author's name : n/a
 *       Acknowledgment of help from other team members, by name: n/a
 * @version 1.1
 * @Xiaohui modified by 11-21
 */
public class GameView extends View implements GameConstants {
	/** x,position of base */
	private static int BASE_X = 160;
	/** y,position of base */
	private static int BASE_Y = 340;
	/** height of the view */
	protected int height;
	/** width of the view */
	protected int width;
	/** image source of the base */
	private Bitmap base;
	/** list of shells */
	protected List<Shell> shellsList = new ArrayList<Shell>();
	/** list of tanks */
	protected List<Tank> tankList = new ArrayList<Tank>();
	/** list of barriers */
	private List<Barrier> barriersList = new ArrayList<Barrier>();
	/**
	 * 2D matrix.represents the point on the
	 * canvas.status:0:free£¬1:tank£¬2:barrier£¬3:base.
	 */
	public static int map[][];
	/** row on the canvas */
	private int row;
	/** column on the canvas */
	private int column;
	/** mytank object */
	public Tank myTank;
	/** enemy tanks**/
	private Random tankRandom=new Random();
	/** how many enemy tanks is hit by myTank**/
	private int hits = 0;
	/** game Result dialog **/
	private AlertDialog dialog;
	
	//private TableLayout msgPanel;
	
	/** game status. */
	private String gameStatus = "STOP";
	/** gameHandler */
	private Handler gameHandler = new Handler();
	/** main draw thread */
	private Runnable drawThread = new Runnable() {
		@Override
		public void run() {
			update();
		}

	};
	
	public boolean winGame;
	

	/**
	 * constructor for GameView
	 * 
	 * @param context
	 */
	public GameView(Context context) {
		super(context);
		winGame = false;
	}

	/**
	 * constructor for GameView with attrs
	 * 
	 * @param context
	 *            context
	 * @attrs attributes attributes
	 */
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		base = ((BitmapDrawable) getResources().getDrawable(R.drawable.dby))
				.getBitmap();
		winGame = false;
	}

	public void setDialog(AlertDialog ad){
		this.dialog=ad;
	}

	/**
	 * override onDraw method which handles all the drawing operations
	 * 
	 * @param cavas
	 *            for game drawing
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		//super.onDraw(canvas);
		
		canvas.drawBitmap(base, BASE_X, BASE_Y, null);// draw base
		
		int shellSize = shellsList.size();
		for (int j = 0; j < shellSize; j++) {
			shellsList.get(j).drawShell(canvas);
		}

		int i=tankList.size();
		for(int j=0;j<i;j++){
			tankList.get(j).drawTank(canvas);
		}
		
		i = barriersList.size();
		
		for (int j = 0; j < i; j++) {
			barriersList.get(j).drawBarrier(canvas);
		}
		
		myTank.drawTank(canvas);

	}

	/**
	 * init the map
	 */
	public void initMap() {

		GameMap gMap = new GameMap(row,column);
		//map = gMap.map;
			gMap.map1();
		for(int i=0;i<row+1;i++){
			for (int j = 0; j < column+1; j++) {
				map[i][j] = gMap.map[i][j];
				if (map[i][j] == 2)
				barriersList.add(new Barrier(i, j));
			}
		}
		
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
	}

	/**
	 * override onSize method,will be called when size of the view is changed
	 * 
	 * @param w
	 *            width
	 * @param h
	 *            height
	 * @param oldw
	 *            old width
	 * @param oldh
	 *            old height
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
		//gameHandler.post(drawThread);

	}

	/**
	 * override the onKeyDown method to listen the key events
	 * 
	 * @param keyCode
	 *            keycode
	 * @param event
	 *            key event
	 * @return operation completed or not
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
			if (judgeHitWall(shells)) {
				if (GameFactory.shellsFactory.size() < SHELLS_FACTORY_SIZE) {
					GameFactory.shellsFactory.push(shells);
				}
				shellsList.remove(j--);
				i--;
			}
			shells.move();// shell move
		}
		if (gameStatus.equals("START")) {
			 
			randomTank();
			postInvalidate();
			gameHandler.postDelayed(drawThread, 100);
		}
		Log.i("System.out", String.valueOf(System.currentTimeMillis() - begin));
	}

	/**
	 * draw enemy tanks
	 */
	public void randomTank(){
		//long dur = System.currentTimeMillis()- begin;
		//TODO: Make enemy tanks more smart
		if(tankRandom.nextInt(100)%10==0){
			if(tankList.size()<8 &&map[tankIntalizeHeight/UNIT][tankIntalizeWidth/UNIT]==0){
				tankList.add(new Tank((BitmapDrawable)getResources().getDrawable(R.drawable.tank_d),new Point(tankIntalizeWidth,tankIntalizeHeight), 1,DOWN,height,width));
				tankList.add(new Tank((BitmapDrawable)getResources().getDrawable(R.drawable.tank_d),new Point(tankIntalizeWidth+130,tankIntalizeHeight), 1,DOWN,height,width));
				tankList.add(new Tank((BitmapDrawable)getResources().getDrawable(R.drawable.tank_d),new Point(tankIntalizeWidth+270,tankIntalizeHeight), 1,DOWN,height,width));
			}
		}
		

		Iterator<Tank> it=tankList.iterator();
		while(it.hasNext()){
			Tank t=it.next();
			int r=tankRandom.nextInt(100)%10;
			switch (r) {
			case 0:
				t.moveRight();
				break;
			case 1:
				t.moveLeft();
				break;
			case 2:
				//t.moveUp();
				t.moveDown();
				break;
			case 3:
				t.moveDown();
				break;
			case 4:
				shellsList.add(t.fire());
				break;
			default:
				t.move();
			}
		}
	}
	
	
	
	/**
	 * judge if a shell hits a wall, then remove the wall from the barrierList
	 * judge if shell hits base, game over
	 * judge if a shell hits tank invoke method to decide enemy tanks or mytank
	 * @param s
	 *            shell
	 */
	public boolean judgeHitWall(Shell s) {
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
			gameStatus="STOP";
			dialog.show();
			return false;
		}
		if (map[j][i] == 2) {
			barriersList.remove(new Barrier(j, i));
			map[j][i] = 0;
			return true;
		}
		if (map[j][i] == 1) {
			return judgeHitTank(s);
		}
		return false;
	}
	
	
	/**
	 * judge if a shell hits a tank
	 * 
	 * judge if shell hits myTank, game over
	 * if my tank's shell hits one enemy tank, enemy tank removes
	 * when 10 enemy tanks are killed, game over
	 * @param s
	 *            shell
	 */
	
	public boolean judgeHitTank(Shell s){
		Iterator<Tank> tIt;
		if(myTank.hit(s)){
			gameStatus="STOP";
			dialog.show();
			return false;
		}
		tIt=tankList.iterator();
		while(tIt.hasNext()){
			Tank t=tIt.next();
			if(t.hit(s)){
				hits++;				
				tIt.remove();
				if(hits == 1){
					gameStatus="STOP";
					winGame = true;
					dialog.setMessage("Mission completed,Press Center Button To Next Stage!");
					dialog.show();
					return false;
				}
				
				return true;
			}
		}
		
		return false;
	}
	

}
