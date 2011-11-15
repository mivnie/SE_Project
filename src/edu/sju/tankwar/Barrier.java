package edu.sju.tankwar;

import edu.sju.tankwar.math.GameConstants;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @file Barrier.java
 * @brief barriers in the game
 * @author 
 *  The team name Team F
 *	The principal author's name : Yuanhai Shi
 *	Acknowledgment of help from other team members, by name: n/a
 * @version 1.0
 */

public class Barrier implements GameConstants {

	/** paint for barrier */
	private Paint p;

	/** inner Rectangle for barrier image*/
	private Rect inRect;

	/** outer Rectangle for barrier image*/
	private Rect outRect;

	/** row for barrier image*/
	private int r;

	/** column for barrier image*/
	private int c;

	/**
	 * non-param constructor
	 */
	public Barrier() {
	}

	/**
	 * Barrier constructor
	 * @param r row position of barrier on the map
	 * @param c column position of barrier on the map
	 */
	public Barrier(int r, int c) {
		this.r = r;
		this.c = c;
		p = new Paint();
		inRect = new Rect(c * UNIT + 1, r * UNIT + 1, (c + 1) * UNIT - 1,
				(r + 1) * UNIT - 1);
		outRect = new Rect(c * UNIT, r * UNIT, (c + 1) * UNIT, (r + 1) * UNIT);
	}

	/**
	 * draw a barrier on the canvas
	 * @param canvas game view canvas
	 */
	public void drawBarrier(Canvas canvas) {
		p.setStyle(Paint.Style.FILL);
		p.setColor(Color.RED);
		canvas.drawRect(inRect, p);
		p.setColor(Color.CYAN);
		p.setStyle(Paint.Style.STROKE);
		canvas.drawRect(outRect, p);
	}
	
	/**
	 * override the equals method
	 * @param canvas game view canvas
	 */
	@Override
	public boolean equals(Object o) {
		Barrier barrier = (Barrier) o;
		return this.r == barrier.r && this.c == barrier.c;
	}
}
