/**
 * 
 */
package edu.sju.tankwar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * @author shiyuanhai
 *
 */
public class Stage3Activity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_layout3);
		GameViewStage3 gameView = (GameViewStage3) findViewById(R.id.tankwar3);
		gameView.setDialog(new AlertDialog.Builder(this).setMessage("You lose, Press Back Button to Restart").setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
					GameViewStage3 gameView = (GameViewStage3) findViewById(R.id.tankwar3);
					if(gameView.winGame){
						finish();
						Tank.stage = 1;
					}else {
						finish();
						Tank.stage = 3;
						Intent i1 = new Intent();
						i1.setClass(Stage3Activity.this, Stage3Activity.class);
						startActivity(i1);
					}

				}
				
				return false;
			}
		}).create());
		gameView.setFocusable(true);	
		
	}
}
