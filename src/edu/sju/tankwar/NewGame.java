
package edu.sju.tankwar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Description: activity when clicking the new button
 * @file NewGame.java
 * @author 
 *  The team name Team F
 *  The principal author's name : Xiaohui Liu Update
 *  Acknowledgment of help from other team members, by name: n/a
 * @version 1.1
   
 */
public class NewGame extends Activity {
	/**
	 * oncreate for NewGame activity
	 * @param savedInstanceState savedInstanceState
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout);
		GameView gameView = (GameView) findViewById(R.id.tankwar);
        gameView.setDialog(new AlertDialog.Builder(this).setMessage("GAME OVER ").setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				// 
				if(keyCode==KeyEvent.KEYCODE_BACK){
					Log.i("System.out", "Game Over!");
					finish();
				}
				
				return false;
			}
		}).create());
		gameView.setFocusable(true);	
		
	}
}
