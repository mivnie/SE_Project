	/**
 * 
 */
package edu.sju.tankwar;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import edu.sju.tankwar.math.GameConstants;

/**
 * @author team_f
 *
 */
public class GameView extends View implements GameConstants {



	private Bitmap base;
	
	public static final int UNIT=10;
		
	public static final int LEFT=4;
	
	public static final int RIGHT=2;
	
	public static final int UP=1;
	
	public static final int DOWN=3;
	
	private static  int BASE_X=150;
	
	private static  int BASE_Y=400;
	
	protected int height;
	protected int width;
	protected List<Shell> shellsList=new ArrayList<Shell>();
	protected List<Tank> tankList=new ArrayList<Tank>();
	public  static int map[][];//0:free，1:tank，2:barrier，3:base
			
	//测试
    Paint mPaint; //画笔,包含了画几何图形、文本等的样式和颜色信息  

	
	
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
	public GameView(Context context,AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		 super(context, attrs);
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); 
		base=((BitmapDrawable)getResources().getDrawable(R.drawable.dby)).getBitmap();
		canvas.drawBitmap(base, BASE_X, BASE_Y, null);
	}
	
	//init map
	public void initMap(){
		//初始化大本营
		 for(int i=BASE_Y/UNIT;i<BASE_Y/UNIT+base.getHeight()/UNIT;i++){
			 for(int j=BASE_X/UNIT;j<BASE_X/UNIT+base.getWidth()/UNIT;j++){
				 map[i][j]=3;
			 }
		}
	}
}
