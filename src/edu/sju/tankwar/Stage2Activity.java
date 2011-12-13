/**
 * 
 */
package edu.sju.tankwar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

/**
 * @author shiyuanhai
 *
 */
public class Stage2Activity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout2);
		GameViewStage2 gameView = (GameViewStage2) findViewById(R.id.tankwar2);
		gameView.setDialog(new AlertDialog.Builder(this).setMessage("You lose, Press Back Button to Restart").setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
					GameViewStage2 gameView = (GameViewStage2) findViewById(R.id.tankwar2);
					if(gameView.winGame){
						finish();
						Tank.stage = 3;
						Intent i1 = new Intent();
						i1.setClass(Stage2Activity.this, Stage3Activity.class);
						startActivity(i1);
					}else {
						finish();
						/*Tank.stage = 2;
						Intent i1 = new Intent();
						i1.setClass(Stage2Activity.this, Stage2Activity.class);
						startActivity(i1);*/
					}

				}
				else if(keyCode==KeyEvent.KEYCODE_BACK){
					Log.i("System.out", "GAME OVER!");
					finish();
				}
			
				
				return false;
			}
		}).create());
		gameView.setFocusable(true);	
		
	}
}
