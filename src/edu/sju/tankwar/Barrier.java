/**
 * 
 */
package edu.sju.tankwar;

import edu.sju.tankwar.math.GameConstants;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author team_f
 * 
 */
public class Barrier implements GameConstants {

	private Paint p;

	private Rect inRect;

	private Rect outRect;

	private int r;

	private int c;

	/**
	 * 
	 */
	public Barrier() {
	}

	/**
	 * 
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
	 * @param canvas
	 *            draw a barrier on the canvas
	 */
	public void drawBarrier(Canvas canvas) {
		p.setStyle(Paint.Style.FILL);
		p.setColor(Color.YELLOW);
		canvas.drawRect(inRect, p);
		p.setColor(Color.WHITE);
		p.setStyle(Paint.Style.STROKE);
		canvas.drawRect(outRect, p);
	}

	@Override
	public boolean equals(Object o) {
		Barrier barrier = (Barrier) o;
		return this.r == barrier.r && this.c == barrier.c;
	}
}
