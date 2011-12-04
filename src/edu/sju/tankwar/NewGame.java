
package edu.sju.tankwar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
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
		gameView.setDialog(new AlertDialog.Builder(this).setMessage("You lose, Press Back Button to Restart").setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
					GameView gameView = (GameView) findViewById(R.id.tankwar);
					if(gameView.winGame){
						finish();
						Tank.stage = 2;
						Intent i1 = new Intent();
						i1.setClass(NewGame.this, Stage2Activity.class);
						startActivity(i1);
					}else {
						finish();
						Tank.stage = 1;
						Intent i1 = new Intent();
						i1.setClass(NewGame.this, NewGame.class);
						startActivity(i1);
					}

				}
				
				return false;
			}
		}).create());
		gameView.setFocusable(true);	
		
	}
}
